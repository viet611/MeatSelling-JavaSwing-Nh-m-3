/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import ultilities.JDBCHelper;
import domainmodels.ThanhVienDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author vietv
 */
public class ThanhVienRepository {
    public static ArrayList<ThanhVienDomainModel> getAll(){
        ArrayList<ThanhVienDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from ThanhVien";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new ThanhVienDomainModel(
                        rs.getString("ID"),
                        rs.getString("MaTV"),
                        rs.getString("IDHangThanhVien") == null ? null : HangThanhVienRepository.selectByID(rs.getString("IDHangThanhVien"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(ThanhVienDomainModel thanhVien) {
        Integer row = -1;
        try {
            String sql = "Insert into ThanhVien values (NEWID(),?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    thanhVien.getMa(),
                    thanhVien.getHangThanhVien() == null ? null : thanhVien.getHangThanhVien().getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(ThanhVienDomainModel thanhVien) {
        Integer row = -1;
        try {
            String sql = "Update ThanhVien "
                    + "set MaTV = ?, IDHangThanhVien = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    thanhVien.getMa(),
                    thanhVien.getHangThanhVien() == null ? null : thanhVien.getHangThanhVien().getId(),
                    thanhVien.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from ThanhVien where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static ThanhVienDomainModel selectByID(String id) {
        ThanhVienDomainModel selected = null;
        try {
            String sql = "Select * from ThanhVien where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new ThanhVienDomainModel(
                        id,
                        rs.getString("MaTV"),
                        rs.getString("IDHangThanhVien") == null ? null : HangThanhVienRepository.selectByID(rs.getString("IDHangThanhVien"))                );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
