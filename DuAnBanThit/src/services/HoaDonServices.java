/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.HoaDonChiTietDomainModel;
import domainmodels.HoaDonDomainModel;
import domainmodels.KhachHangDomainModel;
import domainmodels.LoaiThitDomainModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonRepository;
import repositories.KhachHangRepository;
import repositories.NhanVienRepository;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author vietv
 */
public class HoaDonServices {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public String getTenNhanVienByID(String idNV) {
        return NhanVienRepository.selectByID(idNV).getHoTen();
    }

    public String getSDTByIDThanhVien(String idThanhVien) {
        for (KhachHangDomainModel x : KhachHangRepository.getAll()) {
            if (x.getThanhVien().getId().equals(idThanhVien)) {
                return x.getsDT();
            }
        }
        return null;
    }

    private double tinhGiaHopThit(HoaDonChiTietDomainModel hoaDonCTDM) {
        double giaTienMoi1g = hoaDonCTDM.getHopThit().getLoaiThit().getGiaTien() / hoaDonCTDM.getHopThit().getLoaiThit().getDonViTinh().getQuyDoi();
        double canNang = hoaDonCTDM.getHopThit().getKhoiLuong() * hoaDonCTDM.getHopThit().getDonViTinh().getQuyDoi();
        if (hoaDonCTDM.getGiamGiaTheoHSD() == null) {
            return canNang * giaTienMoi1g;
        } else {
            return canNang * giaTienMoi1g * hoaDonCTDM.getGiamGiaTheoHSD().getPhanTramGiamGia() / 100;
        }
    }

    public String getTenLoaiThitByIDHoaDonCT(String idHDCT) {
        LoaiThitDomainModel loaiThit = HoaDonChiTietRepository.selectByID(idHDCT).getHopThit().getLoaiThit();
        return loaiThit.getViTriThit().getTen() + " " + loaiThit.getGiaSuc().getTen();
    }

    public ArrayList<HoaDonChiTietViewModel> getAllHoaDonCTByID(String id) {
        ArrayList<HoaDonChiTietViewModel> list = new ArrayList<>();
        for (HoaDonChiTietDomainModel x : HoaDonChiTietRepository.getAllByIDHoaDon(id)) {
            HoaDonChiTietViewModel hoaDonCTVM = new HoaDonChiTietViewModel(
                    x.getId(),
                    x.getHopThit().getMa(),
                    String.valueOf(tinhGiaHopThit(x)),
                    id);
            list.add(hoaDonCTVM);
        }
        return list;
    }

    public String getTongTien(String idHoaDon) {
        double tongTien = 0;
        for (HoaDonChiTietViewModel x : getAllHoaDonCTByID(idHoaDon)) {
            tongTien += Double.parseDouble(x.getGiaBan());
        }
        return String.valueOf(tongTien);
    }

    public ArrayList<HoaDonViewModel> getAllAndSortHoaDon() {
        ArrayList<HoaDonViewModel> listAll = new ArrayList<>();
        ArrayList<HoaDonViewModel> listDaTT = new ArrayList<>();
        //Lọc
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (HoaDonChiTietRepository.getAllByIDHoaDon(x.getId()).isEmpty()) {
                HoaDonRepository.delete(x.getId());
                continue;
            }
            //get hóa đơn chưa thanh toán trước
            if (x.getNgayThanhToan() == null) {
                listAll.add(new HoaDonViewModel(x.getId(),
                        sdf.format(x.getNgayTao()),
                        x.getNgayThanhToan() == null ? null : sdf.format(x.getNgayThanhToan()),
                        x.getTaiKhoanDN().getNhanVien().getId(),
                        x.getThanhVien() == null ? null : x.getThanhVien().getId(),
                        x.getTinhTrang()));
            } else {
                listDaTT.add(new HoaDonViewModel(x.getId(),
                        sdf.format(x.getNgayTao()),
                        sdf.format(x.getNgayThanhToan()),
                        x.getTaiKhoanDN().getNhanVien().getId(),
                        x.getThanhVien() == null ? null : x.getThanhVien().getId(),
                        x.getTinhTrang()));
            }
        }
        //Sắp xếp
        Comparator<HoaDonViewModel> compare = new Comparator<HoaDonViewModel>() {
            @Override
            public int compare(HoaDonViewModel o1, HoaDonViewModel o2) {
                try {
                    return sdf.parse(o1.getNgayThanhToan()).compareTo(sdf.parse(o2.getNgayThanhToan()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                return 0;
            }
        };
        Collections.sort(listDaTT, compare);
        for (HoaDonViewModel x : listDaTT) {
            listAll.add(x);
        }
        return listAll;
    }

    public ArrayList<HoaDonViewModel> getAllHoaDonBySDT(String sdt) {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        String idThanhVien = null;
        if (sdt.trim().length() == 0) {
            return this.getAllAndSortHoaDon();
        }
        for (KhachHangDomainModel x : KhachHangRepository.getAll()) {
            if (x.getsDT().equals(sdt)) {
                idThanhVien = x.getThanhVien().getId();
            }
        }
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getThanhVien() != null) {
                if (x.getThanhVien().getId().equals(idThanhVien)) {
                    list.add(new HoaDonViewModel(x.getId(),
                            sdf.format(x.getNgayTao()),
                            sdf.format(x.getNgayThanhToan()),
                            x.getTaiKhoanDN().getNhanVien().getId(),
                            x.getThanhVien().getId(),
                            x.getTinhTrang()));
                }
            }
        }
        return list;
    }

    public String xoaHoaDon(String idHoaDon) {
        for (HoaDonChiTietDomainModel x : HoaDonChiTietRepository.getAllByIDHoaDon(idHoaDon)) {
            HoaDonChiTietRepository.delete(x.getId());
        }
        return HoaDonRepository.delete(idHoaDon) > 0 ? "Xóa thành công" : "Xóa thất bại";
    }

    public String thanhToanHoaDon(String idHoaDon) {
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getId().equals(idHoaDon)) {
                x.setNgayThanhToan(new Date());
                x.setTinhTrang("Đã thanh toán");
                return HoaDonRepository.update(x) > 0 ? "Thanh toán thành công" : "Thanh toán thất bại";
            }
        }
        return null;
    }
}
