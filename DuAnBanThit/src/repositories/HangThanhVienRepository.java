/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.HangThanhVienDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author vietv
 */
public class HangThanhVienRepository {

    public static ArrayList<HangThanhVienDomainModel> getAll() {
        ArrayList<HangThanhVienDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from HangThanhVien";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new HangThanhVienDomainModel(
                        rs.getString("Id"),
                        rs.getString("Ten"),
                        rs.getDouble("SoTienDatHang"),
                        rs.getDouble("PhamTramGiamGiaHD")));                
            }
            Comparator<HangThanhVienDomainModel> compare = new Comparator<HangThanhVienDomainModel>() {
                @Override
                public int compare(HangThanhVienDomainModel t, HangThanhVienDomainModel t1) {
                    if(t.getSoTienDatHang()>t1.getSoTienDatHang())return 1;
                    else if(t.getSoTienDatHang()<t1.getSoTienDatHang())return -1;
                    else return 0;
                }
            };
            Collections.sort(list,compare);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer add(HangThanhVienDomainModel hangTV) {
        Integer row = -1;
        try {
            String sql = "Insert into HangThanhVien values (NEWID(),?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    hangTV.getTen(),
                    hangTV.getSoTienDatHang(),
                    hangTV.getPhamTramGiamGiaHD()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(HangThanhVienDomainModel hangTV) {
        Integer row = -1;
        try {
            String sql = "Update HangThanhVien "
                    + "set Ten = ?, SoTienDatHang = ?, PhamTramGiamGia = ? "
                    + "where ID = ? ";
            row = JDBCHelper.excuteUpdate(sql,
                    hangTV.getTen(),
                    hangTV.getSoTienDatHang(),
                    hangTV.getPhamTramGiamGiaHD(),
                    hangTV.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from HangThanhVien where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static HangThanhVienDomainModel selectByID(String id) {
        HangThanhVienDomainModel selected = null;
        try {
            String sql = "Select * from HangThanhVien where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new HangThanhVienDomainModel(
                    id,
                    rs.getString("Ten"),
                    rs.getDouble("SoTienDatHang"),
                    rs.getDouble("PhamTramGiamGiaHD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
