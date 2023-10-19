/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.ChucVuDomainModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vietv
 */
public class ChucVuRepository {

    public static ArrayList<ChucVuDomainModel> getAll() {
        ArrayList<ChucVuDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from ChucVu";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new ChucVuDomainModel(
                        rs.getString("Id"),
                        rs.getString("Ma"),
                        rs.getString("Ten")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer add(ChucVuDomainModel chucVu) {
        Integer row = -1;
        try {
            String sql = "Insert into ChucVu values (NEWID(),?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    chucVu.getTen(),
                    chucVu.getMa()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(ChucVuDomainModel chucVu) {
        Integer row = -1;
        try {
            String sql = "Update ChucVu "
                    + "set Ten = ?, Ma = ? "
                    + "where ID = ? ";
            row = JDBCHelper.excuteUpdate(sql,
                    chucVu.getTen(),
                    chucVu.getMa(),
                    chucVu.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from ChucVu where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static ChucVuDomainModel selectByID(String id) {
        ChucVuDomainModel selected = null;
        try {
            String sql = "Select * from ChucVu where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new ChucVuDomainModel(
                    id,
                    rs.getString("Ma"),
                    rs.getString("Ten")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
