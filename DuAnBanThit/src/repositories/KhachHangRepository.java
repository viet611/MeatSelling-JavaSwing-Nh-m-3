/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import ultilities.JDBCHelper;
import domainmodels.KhachHangDomainModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vietv
 */
public class KhachHangRepository {
    public static ArrayList<KhachHangDomainModel> getAll(){
        ArrayList<KhachHangDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from KhachHang";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new KhachHangDomainModel(
                        rs.getString("ID"),
                        rs.getString("MaKH"),
                        rs.getString("HoTen"),
                        rs.getString("SDT"),
                        rs.getInt("GioiTinh")==1,
                        rs.getString("DiaChi"),
                        rs.getDate("NgaySinh"),
                        ThanhVienRepository.selectByID(rs.getString("IDThanhVien"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(KhachHangDomainModel khachHang) {
        Integer row = -1;
        try {
            String sql = "Insert into KhachHang values (NEWID(),?,?,?,?,?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    khachHang.getMaKH(),
                    khachHang.getHoTen(),
                    khachHang.getsDT(),
                    khachHang.isGioiTinh() ? 1 : 0,
                    khachHang.getDiaChi(),
                    khachHang.getNgaySinh(),
                    khachHang.getThanhVien().getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(KhachHangDomainModel khachHang) {
        Integer row = -1;
        try {
            String sql = "Update KhachHang "
                    + "set MaKH = ?, HoTen = ?, SDT = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ?, IDThanhVien = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    khachHang.getMaKH(),
                    khachHang.getHoTen(),
                    khachHang.getsDT(),
                    khachHang.isGioiTinh() ? 1 : 0,
                    khachHang.getDiaChi(),
                    khachHang.getNgaySinh(),
                    khachHang.getThanhVien().getId(),
                    khachHang.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from KhachHang where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static KhachHangDomainModel selectByID(String id) {
        KhachHangDomainModel selected = null;
        try {
            String sql = "Select * from KhachHang where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new KhachHangDomainModel(
                        rs.getString("ID"),
                        rs.getString("MaKH"),
                        rs.getString("HoTen"),
                        rs.getString("SDT"),
                        rs.getInt("GioiTinh")==1,
                        rs.getString("DiaChi"),
                        rs.getDate("NgaySinh"),
                        ThanhVienRepository.selectByID(rs.getString("ID"))
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
