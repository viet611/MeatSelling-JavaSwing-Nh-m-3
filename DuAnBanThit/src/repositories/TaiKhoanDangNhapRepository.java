/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import ultilities.JDBCHelper;
import domainmodels.TaiKhoanDangNhapDomainModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vietv
 */
public class TaiKhoanDangNhapRepository {
    public static ArrayList<TaiKhoanDangNhapDomainModel> getAll(){
        ArrayList<TaiKhoanDangNhapDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from TaiKhoanDangNhap";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new TaiKhoanDangNhapDomainModel(
                        rs.getString("ID"),
                        rs.getString("TenTK"),
                        rs.getString("MatKhau"),
                        ChucVuRepository.selectByID(rs.getString("IDChucVu")),
                        NhanVienRepository.selectByID(rs.getString("IDNhanVien"))
                ));               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(TaiKhoanDangNhapDomainModel taiKhoanDN) {
        Integer row = -1;
        try {
            String sql = "Insert into TaiKhoanDangNhap values (NEWID(),?,?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    taiKhoanDN.getTenTK(),
                    taiKhoanDN.getMatKhau(),
                    taiKhoanDN.getChucVu().getId(),
                    taiKhoanDN.getNhanVien() == null ? null : taiKhoanDN.getNhanVien().getId() 
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(TaiKhoanDangNhapDomainModel taiKhoanDN) {
        Integer row = -1;
        try {
            String sql = "Update TaiKhoanDangNhap "
                    + "set TenTK = ?, MatKhau = ?, IDChucVu = ?, IDNhanVien = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    taiKhoanDN.getTenTK(),
                    taiKhoanDN.getMatKhau(),
                    taiKhoanDN.getChucVu().getId(),
                    taiKhoanDN.getNhanVien() == null ? null : taiKhoanDN.getNhanVien().getId(),
                    taiKhoanDN.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from TaiKhoanDangNhap where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static TaiKhoanDangNhapDomainModel selectByID(String id) {
        TaiKhoanDangNhapDomainModel selected = null;
        try {
            String sql = "Select * from TaiKhoanDangNhap where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new TaiKhoanDangNhapDomainModel(
                        id,
                        rs.getString("TenTK"),
                        rs.getString("MatKhau"),
                        ChucVuRepository.selectByID(rs.getString("IDChucVu")),
                        NhanVienRepository.selectByID(rs.getString("IDNhanVien"))
                );  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
