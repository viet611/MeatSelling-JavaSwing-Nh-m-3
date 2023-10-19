/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.ChucVuDomainModel;
import domainmodels.NhanVienDomainModel;
import domainmodels.TaiKhoanDangNhapDomainModel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import repositories.ChucVuRepository;
import repositories.NhanVienRepository;
import repositories.TaiKhoanDangNhapRepository;
import view.NhanVienView;
import viewmodel.ChucVuViewModel;
import viewmodel.NhanVienViewModel;
import viewmodel.TaiKhoanViewModel;

/**
 *
 * @author Toan
 */
public class NhanVienServices {

    public ArrayList<NhanVienViewModel> getAll() {
        ArrayList<NhanVienViewModel> listVm = new ArrayList<>();
        for (NhanVienDomainModel x : NhanVienRepository.getAll()) {
            NhanVienViewModel nhanVien = new NhanVienViewModel(
                    x.getId(),
                    x.getMaNV(),
                    x.getHoTen(),
                    x.getsDT(),
                    x.isGioiTinh(),
                    x.getNgaySinh(),
                    x.getDiaChi(),
                    x.getTrangThai(),
                    null,
                    null,
                    null);
            for (TaiKhoanDangNhapDomainModel y : TaiKhoanDangNhapRepository.getAll()) {
                if (y.getNhanVien() == null) {
                    continue;
                }
                if (y.getNhanVien().getId().equals(x.getId())) {
                    nhanVien.setChucVu(y.getChucVu().getTen());
                    nhanVien.setTaiKhoan(y.getTenTK());
                    nhanVien.setMatKhau(y.getMatKhau());
                }
            }
            listVm.add(nhanVien);
        }

        return listVm;
    }

    public ArrayList<TaiKhoanViewModel> getAllTaiKhoan() {
        ArrayList<TaiKhoanViewModel> listTK = new ArrayList<>();
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            TaiKhoanViewModel taiKhoan = new TaiKhoanViewModel(
                    x.getTenTK(),
                    x.getMatKhau());
            listTK.add(taiKhoan);
        }
        return listTK;
    }

    public ArrayList<ChucVuViewModel> getAllChuVu() {
        ArrayList<ChucVuViewModel> listCV = new ArrayList<>();
        for (ChucVuDomainModel x : ChucVuRepository.getAll()) {
            ChucVuViewModel chucVu = new ChucVuViewModel(x.getMa(), x.getTen());
            listCV.add(chucVu);
        }
        return listCV;
    }

    public ArrayList<TaiKhoanViewModel> getAllTaiKhoanByChucVu(String tenChucVu) {
        ArrayList<TaiKhoanViewModel> listTK = new ArrayList<>();
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (x.getChucVu().getTen().equals(tenChucVu)) {
                TaiKhoanViewModel taiKhoan = new TaiKhoanViewModel(
                        x.getTenTK(),
                        x.getMatKhau());
                listTK.add(taiKhoan);
            }
        }
        return listTK;
    }

    public Integer addTaiKhoan(TaiKhoanViewModel taiKhoanVm, String chucVu) {
        TaiKhoanDangNhapDomainModel taiKhoan = new TaiKhoanDangNhapDomainModel();
        if (taiKhoanVm.getTenTK().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tài khoản");
            return null;
        }
        if (taiKhoanVm.getMatKhau().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu");
            return null;
        }
        taiKhoan.setTenTK(taiKhoanVm.getTenTK());
        taiKhoan.setMatKhau(taiKhoanVm.getMatKhau());
        for (ChucVuDomainModel x : ChucVuRepository.getAll()) {
            if (chucVu.equalsIgnoreCase(x.getTen())) {
                taiKhoan.setChucVu(x);
                break;
            }
        }
        return TaiKhoanDangNhapRepository.add(taiKhoan);

    }

    public Integer add(NhanVienViewModel nhanVienVM) {
        TaiKhoanDangNhapDomainModel taiKhoan = new TaiKhoanDangNhapDomainModel();
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (nhanVienVM.getTaiKhoan().equals(x.getTenTK())) {
                if (x.getNhanVien() != null) {
                    int confirm = JOptionPane.showConfirmDialog(new NhanVienView(), "Tài khoản đang có người sử dụng. Bạn chắc chưa ?");
                    if (confirm != JOptionPane.YES_OPTION) {
                        return -1;
                    }
                }
                taiKhoan = x;
                break;
            }
        }

        NhanVienDomainModel nhanVien = new NhanVienDomainModel();
        nhanVien.setId(nhanVienVM.getIdNhanVien());
        nhanVien.setMaNV(nhanVienVM.getMaNhanVien());
        nhanVien.setHoTen(nhanVienVM.getHoTen());
        nhanVien.setsDT(nhanVienVM.getSdt());
        nhanVien.setGioiTinh(nhanVienVM.isGioiTinh());
        nhanVien.setNgaySinh(nhanVienVM.getNgaySinh());
        nhanVien.setDiaChi(nhanVienVM.getDiaChi());
        nhanVien.setTrangThai(nhanVienVM.getTrangThai());
        NhanVienRepository.add(nhanVien);

        for (NhanVienDomainModel x : NhanVienRepository.getAll()) {
            if (x.getMaNV().equals(nhanVien.getMaNV())) {
                taiKhoan.setNhanVien(x);
                if (nhanVienVM.getMatKhau().trim().length() != 0) {
                    taiKhoan.setMatKhau(nhanVienVM.getMatKhau());
                }
                break;
            }
        }
        return TaiKhoanDangNhapRepository.update(taiKhoan);
    }

    public Integer update(NhanVienViewModel nhanVienVM) {
        NhanVienDomainModel nhanVien = new NhanVienDomainModel();
        nhanVien.setId(nhanVienVM.getIdNhanVien());
        nhanVien.setMaNV(nhanVienVM.getMaNhanVien());
        nhanVien.setHoTen(nhanVienVM.getHoTen());
        nhanVien.setsDT(nhanVienVM.getSdt());
        nhanVien.setGioiTinh(nhanVienVM.isGioiTinh());
        nhanVien.setNgaySinh(nhanVienVM.getNgaySinh());
        nhanVien.setDiaChi(nhanVienVM.getDiaChi());
        nhanVien.setTrangThai(nhanVienVM.getTrangThai());
        NhanVienRepository.update(nhanVien);
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (x.getNhanVien() != null) {
                if (x.getNhanVien().getId().equals(nhanVienVM.getIdNhanVien())) {
                    x.setNhanVien(null);
                    TaiKhoanDangNhapRepository.update(x);
                    break;
                }
            }
        }
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (nhanVienVM.getTaiKhoan().equals(x.getTenTK())) {
                if (x.getNhanVien() != null) {
                    int confirm = JOptionPane.showConfirmDialog(new NhanVienView(), "Tài khoản đang có người sử dụng. Bạn chắc chưa ?");
                    if (confirm != JOptionPane.YES_OPTION) {
                        return -1;
                    }
                }
                x.setMatKhau(nhanVienVM.getMatKhau());
                x.setNhanVien(nhanVien);
                TaiKhoanDangNhapRepository.update(x);
                break;
            }
        }
        return 1;
    }

    public Integer delete(NhanVienViewModel nhanVienVM) {

        if (nhanVienVM.getTaiKhoan() != null) {
            for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
                if (x.getNhanVien() != null) {
                    if (nhanVienVM.getIdNhanVien().equals(x.getNhanVien().getId())) {
                        x.setNhanVien(null);
                        TaiKhoanDangNhapRepository.update(x);
                    }
                }
            }
        }
        return NhanVienRepository.delete(nhanVienVM.getIdNhanVien());
    }

//    public boolean checkNull(){
//        ArrayList<NhanVienDomainModel> list = new ArrayList<>();
//    }
}
