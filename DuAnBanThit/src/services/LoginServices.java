/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.NhanVienDomainModel;
import domainmodels.TaiKhoanDangNhapDomainModel;
import repositories.NhanVienRepository;
import repositories.TaiKhoanDangNhapRepository;
import viewmodel.TaiKhoanViewModel;

/**
 *
 * @author vietv
 */
public class LoginServices {

    public String[] checkAccount(TaiKhoanViewModel taiKhoan) {
        String[] check = {"noti", null};
        for (TaiKhoanDangNhapDomainModel x : TaiKhoanDangNhapRepository.getAll()) {
            if (x.getTenTK().equals(taiKhoan.getTenTK())) {
                if (x.getMatKhau().equals(taiKhoan.getMatKhau())) {
                    if (x.getNhanVien() == null) {
                        check[0] = "Tài khoản chưa có người được phân quyền";
                        return check;
                    } else {
                        check[0] = x.getNhanVien().getId();
                        check[1] = x.getChucVu().getMa();
                        return check;
                    }
                } else {
                    check[0] = "Sai mật khẩu";
                    return check;
                }
            }
        }
        check[0] = "Không tìm thấy tài khoản";
                   return check;
    }

}
