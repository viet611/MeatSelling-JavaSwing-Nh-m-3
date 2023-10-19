/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.DonViTinhDomainModel;
import domainmodels.GiamGiaTheoHSDDomainModel;
import domainmodels.HoaDonChiTietDomainModel;
import domainmodels.HoaDonDomainModel;
import domainmodels.HopThitDomainModel;
import domainmodels.KhachHangDomainModel;
import domainmodels.LoaiThitDomainModel;
import domainmodels.NhanVienDomainModel;
import domainmodels.TaiKhoanDangNhapDomainModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import repositories.DonViTinhRepository;
import repositories.GiamGiaTheoHSDRepository;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonRepository;
import repositories.HopThitRepository;
import repositories.KhachHangRepository;
import repositories.LoaiThitRepository;
import repositories.NhanVienRepository;
import repositories.TaiKhoanDangNhapRepository;
import repositories.ThanhVienRepository;
import viewmodel.DonViTinhViewModel;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;
import viewmodel.HopThitViewModel;
import viewmodel.KhachHangViewModel;
import viewmodel.LoaiThitViewModel;
import viewmodel.NhanVienViewModel;

/**
 *
 * @author vietv
 */
public class GioHangServices {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public NhanVienViewModel getByID(String idNV) {
        for (NhanVienDomainModel x : NhanVienRepository.getAll()) {
            if (idNV.equals(x.getId())) {
                NhanVienViewModel nhanVienVM = new NhanVienViewModel();
                nhanVienVM.setHoTen(x.getHoTen());
                for (TaiKhoanDangNhapDomainModel y : TaiKhoanDangNhapRepository.getAll()) {
                    if (y.getNhanVien() != null) {
                        if (y.getNhanVien().getId().equals(idNV)) {
                            nhanVienVM.setChucVu(y.getChucVu().getTen());
                        }
                    }
                }

                return nhanVienVM;
            }
        }
        return null;
    }

    public ArrayList<LoaiThitViewModel> getAllLoaiThit() {
        ArrayList<LoaiThitViewModel> list = new ArrayList<>();
        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            list.add(new LoaiThitViewModel(
                    x.getId(),
                    x.getMa(),
                    x.getGiaSuc().getTen(),
                    x.getViTriThit().getTen(),
                    x.getDonViTinh().getTenDonVi(),
                    String.valueOf(x.getGiaTien())));
        }
        return list;
    }

    public ArrayList<DonViTinhViewModel> getAllDonViTinh() {
        ArrayList<DonViTinhViewModel> list = new ArrayList<>();
        for (DonViTinhDomainModel x : DonViTinhRepository.getAll()) {
            list.add(new DonViTinhViewModel(
                    x.getId(),
                    x.getTenDonVi(),
                    String.valueOf(x.getQuyDoi())
            ));
        }
        return list;
    }

    private long getDaysBetween(Date pass, Date future) {
        long getDiff = future.getTime() - pass.getTime();
        long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff) + 1;
        return getDaysDiff;

    }

    private double getGiamGiaTheoHSD(HopThitDomainModel hopThitDM) {
        //Lấy 2 khoảng cách
        long daysBetweenNSXAndHSD = getDaysBetween(hopThitDM.getNSX(), hopThitDM.getHSD());
        Date today = new Date();
        long daysBetweenTodayAndHSD = getDaysBetween(today, hopThitDM.getHSD());
        //Today > HSD --> Hết hạn
        if (daysBetweenTodayAndHSD < 0) {
            return -1;
        }
        //tính % giảm giá
        double phanTramGiamGia = 0;
        double phanTramHSDConLai = (double) daysBetweenTodayAndHSD / daysBetweenNSXAndHSD * 100;
        for (GiamGiaTheoHSDDomainModel x : GiamGiaTheoHSDRepository.getAll()) {
            if (phanTramHSDConLai < x.getPhanTramHSDConLai()) {
                phanTramGiamGia = x.getPhanTramGiamGia();
            } else {
                break;
            }
        }
        return phanTramGiamGia / 100;
    }

    public ArrayList<HopThitViewModel> getAllHopThit() {
        ArrayList<HopThitViewModel> list = new ArrayList<>();
        for (HopThitDomainModel x : HopThitRepository.getAll()) {
            double giaGocTren1g = x.getLoaiThit().getGiaTien() / x.getLoaiThit().getDonViTinh().getQuyDoi();
            double khoiLuongGr = x.getKhoiLuong() * x.getDonViTinh().getQuyDoi();
            double giaGoc = giaGocTren1g * khoiLuongGr;
            double giaBan = giaGoc - giaGoc * getGiamGiaTheoHSD(x);
            String tinhTrang = getGiamGiaTheoHSD(x) == -1 ? "Hết hạn" : "Còn hạn";
            HopThitViewModel hopThit = new HopThitViewModel(
                    x.getId(),
                    x.getMa(),
                    x.getLoaiThit().getViTriThit().getTen() + " " + x.getLoaiThit().getGiaSuc().getTen(),
                    String.valueOf(x.getKhoiLuong()),
                    x.getDonViTinh().getTenDonVi(),
                    String.valueOf(giaGoc),
                    String.valueOf(giaBan),
                    sdf.format(x.getNSX()),
                    sdf.format(x.getHSD()),
                    tinhTrang);
            if (tinhTrang.equals("Hết hạn")) {
                hopThit.setGiaBan("Không bán");
            }
            list.add(hopThit);
        }

        return list;
    }

    private LoaiThitDomainModel getLoaiThitByTenLoaiThit(String tenLoaiThit) {
        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            if (tenLoaiThit.equals(x.getViTriThit().getTen() + " " + x.getGiaSuc().getTen())) {
                return x;
            }
        }
        return null;
    }

    private DonViTinhDomainModel getDonViTinhByTen(String tenDonVi) {
        for (DonViTinhDomainModel x : DonViTinhRepository.getAll()) {
            if (x.getTenDonVi().equals(tenDonVi)) {
                return x;
            }
        }
        return null;
    }

    public String addHopThit(HopThitViewModel hopThitVM) {
        if (hopThitVM.getMaHopThit().trim().length() == 0) {
            return "Bạn chưa nhập mã hộp thịt";
        }
        if (hopThitVM.getKhoiLuong().trim().length() == 0) {
            return "Bạn chưa nhập khối lượng";
        }
        if (hopThitVM.getNSX().trim().length() == 0) {
            return "Bạn chưa nhập ngày sản xuất";
        }
        if (hopThitVM.getHSD().trim().length() == 0) {
            return "Bạn chưa nhập hạn sử dụng";
        }
        HopThitDomainModel hopThitDM = new HopThitDomainModel();
        hopThitDM.setMa(hopThitVM.getMaHopThit());
        hopThitDM.setLoaiThit(getLoaiThitByTenLoaiThit(hopThitVM.getTenLoaiThit()));
        try {
            hopThitDM.setKhoiLuong(Double.parseDouble(hopThitVM.getKhoiLuong()));
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            return "Khối lượng nhập dạng số";
        }
        hopThitDM.setDonViTinh(getDonViTinhByTen(hopThitVM.getTenDonVi()));
        try {
            hopThitDM.setNSX(sdf.parse(hopThitVM.getNSX()));
            hopThitDM.setHSD(sdf.parse(hopThitVM.getHSD()));

        } catch (Exception e) {
            e.printStackTrace();
            return "NSX và HSD phải ở dạng 'dd-MM-yyyy'";
        }
        return HopThitRepository.add(hopThitDM) > 0 ? "Thêm thành công" : "Thêm thất bại";
    }

    private TaiKhoanDangNhapDomainModel getTaiKhoanByIDNV(String idNV) {
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (x.getNhanVien().getId().equals(idNV)) {
                return x;
            }
        }
        return null;
    }

    public String taoHoaDon(String idNV) {
        HoaDonDomainModel hoaDon = new HoaDonDomainModel(
                null,
                new Date(),
                null,
                getTaiKhoanByIDNV(idNV),
                null,
                "Mới tạo");
        HoaDonRepository.add(hoaDon);
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getTinhTrang().equals("Mới tạo")) {
                x.setTinhTrang("Chưa thanh toán");
                HoaDonRepository.update(x);
                return x.getId();
            }
        }
        return null;
    }

    public ArrayList<HoaDonChiTietViewModel> getAllHoaDonCTByID(String id) {
        ArrayList<HoaDonChiTietViewModel> list = new ArrayList<>();
        for (HoaDonChiTietDomainModel x : HoaDonChiTietRepository.getAllByIDHoaDon(id)) {
            HoaDonChiTietViewModel hoaDonCTVM = new HoaDonChiTietViewModel(
                    x.getId(),
                    x.getHopThit().getMa(),
                    null,
                    id);
            for (HopThitViewModel y : this.getAllHopThit()) {
                if (x.getHopThit().getId().equals(y.getId())) {
                    hoaDonCTVM.setGiaBan(y.getGiaBan());
                }
            }
            list.add(hoaDonCTVM);
        }
        return list;
    }

    private GiamGiaTheoHSDDomainModel getGiamGiaTheoPhanTramGiam(double phanTramGiam) {
        for (GiamGiaTheoHSDDomainModel x : GiamGiaTheoHSDRepository.getAll()) {
            if (phanTramGiam == x.getPhanTramGiamGia()) {
                return x;
            }
        }
        return null;
    }

    public String themVaoGioHang(HopThitViewModel hopThit, String idHoaDon) {
        for (HopThitDomainModel x : HopThitRepository.getAll()) {
            if (x.getId().equals(hopThit.getId())) {
                HoaDonChiTietDomainModel hoaDonCTDM = new HoaDonChiTietDomainModel(
                        null,
                        x,
                        getGiamGiaTheoPhanTramGiam((Double.parseDouble(hopThit.getGiaBan()) / Double.parseDouble(hopThit.getGiaGoc())) * 100),
                        HoaDonRepository.selectByID(idHoaDon));
                return HoaDonChiTietRepository.add(hoaDonCTDM) > 0 ? "Thêm thành công" : "Thêm thất bại";
            }
        }
        return null;
    }

    public String xoaKhoiGioHang(String idHoaDonCT) {
        return HoaDonChiTietRepository.delete(idHoaDonCT) > 0 ? "Xóa thành công" : "Xóa thất bại";
    }

    public KhachHangViewModel getKhachHangBySDT(String sdt) {
        if (sdt.trim().length() == 0) {
            return null;
        }
        KhachHangViewModel khachHang = new KhachHangViewModel();
        for (KhachHangDomainModel x : KhachHangRepository.getAll()) {
            if (x.getsDT().equals(sdt)) {
                khachHang.setIDThanhVien(x.getThanhVien().getId());
                khachHang.setHoTen(x.getHoTen());
                khachHang.setHangTV(x.getThanhVien().getHangThanhVien() == null ? "Không có hạng" : x.getThanhVien().getHangThanhVien().getTen());
                break;
            }
        }
        return khachHang;
    }

    public String getIDTaiKhoanDN(String idNhanVien) {
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (x.getNhanVien().getId().equals(idNhanVien)) {
                return x.getId();
            }
        }
        return null;
    }

    public String updateHoaDon(HoaDonViewModel hoaDonVM) {
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getId().equals(hoaDonVM.getId())) {
                HoaDonDomainModel hoaDonDM = new HoaDonDomainModel();
                hoaDonDM.setId(x.getId());
                hoaDonDM.setNgayTao(x.getNgayTao());
                try {
                    hoaDonDM.setNgayThanhToan(sdf.parse(hoaDonVM.getNgayThanhToan()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                hoaDonDM.setTaiKhoanDN(TaiKhoanDangNhapRepository.selectByID(getIDTaiKhoanDN(hoaDonVM.getIdNV())));
                hoaDonDM.setThanhVien(ThanhVienRepository.selectByID(hoaDonVM.getIdThanhVien()));
                hoaDonDM.setTinhTrang("Đã thanh toán");
                return HoaDonRepository.update(hoaDonDM) > 0 ? "Thanh toán thành công" : "Thanh toán thất bại";
            }
        }
        return null;
    }
}
