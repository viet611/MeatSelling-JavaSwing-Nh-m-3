/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.NhanVienDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author vietv
 */
public class NhanVienRepository {
    public static ArrayList<NhanVienDomainModel> getAll(){
        ArrayList<NhanVienDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from NhanVien";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new NhanVienDomainModel(
                        rs.getString("ID"),
                        rs.getString("MaNV"),
                        rs.getString("HoTen"),
                        rs.getString("SDT"),
                        rs.getInt("GioiTinh")==1,
                        rs.getString("DiaChi"),
                        rs.getDate("NgaySinh"),
                        rs.getString("TrangThai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(NhanVienDomainModel nhanVien) {
        Integer row = -1;
        try {
            String sql = "Insert into NhanVien values (NEWID(),?,?,?,?,?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    nhanVien.getMaNV(),
                    nhanVien.getHoTen(),
                    nhanVien.getsDT(),
                    nhanVien.isGioiTinh() ? 1 : 0,
                    nhanVien.getDiaChi(),
                    nhanVien.getNgaySinh(),
                    nhanVien.getTrangThai()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(NhanVienDomainModel nhanVien) {
        Integer row = -1;
        try {
            String sql = "Update NhanVien "
                    + "set MaNV = ?, HoTen = ?, SDT = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ?, TrangThai = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    nhanVien.getMaNV(),
                    nhanVien.getHoTen(),
                    nhanVien.getsDT(),
                    nhanVien.isGioiTinh() ? 1 : 0,
                    nhanVien.getDiaChi(),
                    nhanVien.getNgaySinh(),
                    nhanVien.getTrangThai(),
                    nhanVien.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from NhanVien where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static NhanVienDomainModel selectByID(String id) {
        NhanVienDomainModel selected = null;
        try {
            if(id == null)return selected;
            String sql = "Select * from NhanVien where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new NhanVienDomainModel(
                        rs.getString("ID"),
                        rs.getString("MaNV"),
                        rs.getString("HoTen"),
                        rs.getString("SDT"),
                        rs.getInt("GioiTinh")==1,
                        rs.getString("DiaChi"),
                        rs.getDate("NgaySinh"),
                        rs.getString("TrangThai")
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
