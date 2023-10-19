/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.HangThanhVienDomainModel;
import domainmodels.HoaDonChiTietDomainModel;
import domainmodels.HoaDonDomainModel;
import domainmodels.KhachHangDomainModel;
import domainmodels.ThanhVienDomainModel;
import repositories.HangThanhVienRepository;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonRepository;
import repositories.KhachHangRepository;
import repositories.ThanhVienRepository;
import viewmodel.KhachHangViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class KhachHangServices {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");

    public String getDiemHoaDon(String idThanhVien) {
        double diem = 0;
        double giaTienMoi1g = 0;
        double canNang = 0;

        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if(x.getThanhVien() == null){
                continue;
            }
            if (idThanhVien.equals(x.getThanhVien().getId())) {
                for (HoaDonChiTietDomainModel y : HoaDonChiTietRepository.getAllByIDHoaDon(x.getId())) {
                    giaTienMoi1g = y.getHopThit().getLoaiThit().getGiaTien() / y.getHopThit().getLoaiThit().getDonViTinh().getQuyDoi();
                    canNang = y.getHopThit().getKhoiLuong() * y.getHopThit().getDonViTinh().getQuyDoi();
                    if(y.getGiamGiaTheoHSD()==null){
                        diem+=canNang*giaTienMoi1g;
                    }else{
                        diem += canNang * giaTienMoi1g * y.getGiamGiaTheoHSD().getPhanTramGiamGia() / 100;
                    }
                }
            }
        }
        return String.valueOf(diem);
    }

    public HangThanhVienDomainModel getHangThanhVien(String idThanhVien) {
        double diem = Double.parseDouble(getDiemHoaDon(idThanhVien));
        HangThanhVienDomainModel hangThanhVien = null;
        for (HangThanhVienDomainModel x : HangThanhVienRepository.getAll()) {
            if (diem > x.getSoTienDatHang()) {
                hangThanhVien = x;
            } else {
                break;
            }
        }
        return hangThanhVien;
    }

    public ArrayList<KhachHangViewModel> getAll() {
        ArrayList<KhachHangViewModel> listKhachHangViewModel = new ArrayList<>();
        for (KhachHangDomainModel x : KhachHangRepository.getAll()) {
            KhachHangViewModel khachHangVM = new KhachHangViewModel(x.getId(),
                    x.getMaKH(),
                    x.getHoTen(),
                    x.getsDT(),
                    x.isGioiTinh() == true ? "Nam" : "Nữ",
                    x.getDiaChi(),
                    sdf.format(x.getNgaySinh()),
                    x.getThanhVien().getMa(),
                    getHangThanhVien(x.getThanhVien().getId()) == null ? "Không có hạng" : getHangThanhVien(x.getThanhVien().getId()).getTen(),
                    x.getThanhVien().getId(),
                    getDiemHoaDon(x.getThanhVien().getId())
            );
            ThanhVienDomainModel thanhVien = x.getThanhVien();
            thanhVien.setHangThanhVien(getHangThanhVien(x.getThanhVien().getId()) == null ? null : getHangThanhVien(x.getThanhVien().getId()));
            ThanhVienRepository.update(thanhVien);
            listKhachHangViewModel.add(khachHangVM);

        }
        return listKhachHangViewModel;
    }

    public String checkNull(KhachHangViewModel khachHangVM) {
        if (khachHangVM.getMaKH().trim().length() == 0) {
            return "Bạn chưa nhập mã khách hàng ";
        }
        if (khachHangVM.getHoTen().trim().length() == 0) {
            return "Bạn chưa nhập họ tên";
        }
        if (khachHangVM.getSDT().trim().length() == 0) {
            return "Bạn chưa nhập số điện thoại";
        }
        if (khachHangVM.getGioiTinh().trim().length() == 0) {
            return "Bạn chưa nhập giới tính";
        }
        if (khachHangVM.getDiaChi().trim().length() == 0) {
            return "Bạn chưa nhập địa chỉ";
        }
        if (khachHangVM.getNgaySinh().trim().length() == 0) {
            return "Bạn chưa nhập ngày sinh";
        }
//        if (khachHangVM.getMaTV().trim().length() == 0) {
//            return "Bạn chưa nhập mã thành viên";
//        }
//        if (khachHangVM.getHangTV().trim().length() == 0) {
//            return "Bạn chưa nhập hạng thành viên";
//        }
//        if (khachHangVM.getIDThanhVien().trim().length() == 0) {
//            return "Bạn chưa nhập id thành viên";
//        }
//        if (khachHangVM.getSoDiemTichLuy().trim().length() == 0) {
//            return "Bạn chưa nhập số điểm tích lũy";
//        }
        return null;

    }

    public String add(KhachHangViewModel khachHangVM) {
        if (checkNull(khachHangVM) != null) {
            return checkNull(khachHangVM);
        }
        KhachHangDomainModel khachHangDM = new KhachHangDomainModel();
        for (KhachHangViewModel x : getAll()) {
            if (khachHangVM.getSDT().equals(x.getSDT())) {
                return "SĐT Trùng lặp";
            }
        }
        try {
            khachHangDM.setNgaySinh(sdf.parse(khachHangVM.getNgaySinh()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Ngày sinh không đúng định dạng";
        }
        khachHangDM.setMaKH(khachHangVM.getMaKH());
        khachHangDM.setHoTen(khachHangVM.getHoTen());
        khachHangDM.setsDT(khachHangVM.getSDT());
        khachHangDM.setGioiTinh("Nam".equals(khachHangVM.getGioiTinh()));
        khachHangDM.setDiaChi(khachHangVM.getDiaChi());

        ThanhVienDomainModel thanhVien = new ThanhVienDomainModel();
        thanhVien.setMa(khachHangVM.getSDT().substring(0, 9));
        thanhVien.setHangThanhVien(null);
        ThanhVienRepository.add(thanhVien);
        for (ThanhVienDomainModel x : ThanhVienRepository.getAll()) {
            if (x.getMa().equals(thanhVien.getMa())) {
                khachHangDM.setThanhVien(x);
            }
        }
        return KhachHangRepository.add(khachHangDM) > 0 ? "Thêm thành công" : "Thêm thất bại";

    }

    public String delete(String id) {
        return KhachHangRepository.delete(id) > 0 ? "Xóa thành công" : "Xóa thất bại";
    }

    public String update(KhachHangViewModel khachHangVM) {
        if (checkNull(khachHangVM) != null) {
            return checkNull(khachHangVM);
        }
        KhachHangDomainModel khachHangDM = new KhachHangDomainModel();
        for (KhachHangViewModel x : getAll()) {
            if (khachHangVM.getSDT().equals(x.getSDT())) {
                return "SĐT Trùng lặp";
            }
        }
        try {
            khachHangDM.setNgaySinh(sdf.parse(khachHangVM.getNgaySinh()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Ngày sinh không đúng định dạng";
        }
        khachHangDM.setId(khachHangVM.getId());
        khachHangDM.setMaKH(khachHangVM.getMaKH());
        khachHangDM.setHoTen(khachHangVM.getHoTen());
        khachHangDM.setsDT(khachHangVM.getSDT());
        khachHangDM.setGioiTinh("Nam".equals(khachHangVM.getGioiTinh()));
        khachHangDM.setDiaChi(khachHangVM.getDiaChi());

        ThanhVienDomainModel thanhVien = new ThanhVienDomainModel();
        thanhVien.setId(khachHangVM.getIDThanhVien());

        khachHangDM.setThanhVien(thanhVien);
        return KhachHangRepository.update(khachHangDM) > 0 ? "Sửa thành công" : "Sửa thất bại";

    }

    public ArrayList<KhachHangViewModel> timKiem(String sdt) {
        ArrayList<KhachHangViewModel> listKhachHangViewModel = new ArrayList<>();
        for (KhachHangDomainModel x : KhachHangRepository.getAll()) {
            if (x.getsDT().contains(sdt)) {
                KhachHangViewModel khachHangVM = new KhachHangViewModel(x.getId(),
                        x.getMaKH(),
                        x.getHoTen(),
                        x.getsDT(),
                        x.isGioiTinh() == true ? "Nam" : "Nữ",
                        x.getDiaChi(),
                        sdf.format(x.getNgaySinh()),
                        x.getThanhVien().getMa(),
                        getHangThanhVien(x.getThanhVien().getId()) == null ? "Không có hạng" : getHangThanhVien(x.getThanhVien().getId()).getTen(),
                        x.getThanhVien().getId(),
                        getDiemHoaDon(x.getThanhVien().getId())
                );
                listKhachHangViewModel.add(khachHangVM);
            }
        }
        return listKhachHangViewModel;
    }

}
