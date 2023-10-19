/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.GiaSucDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vietv
 */
public class GiaSucRepository {

    public static ArrayList<GiaSucDomainModel> getAll() {
        ArrayList<GiaSucDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from GiaSuc";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new GiaSucDomainModel(
                        rs.getString("ID"),
                        rs.getString("Ma"),
                        rs.getString("ten")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer add(GiaSucDomainModel giaSuc) {
        Integer row = -1;
        try {
            String sql = "Insert into GiaSuc values (NEWID(),?,?)";
            row = JDBCHelper.excuteUpdate(sql, giaSuc.getMa(), giaSuc.getTen());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static GiaSucDomainModel selectByID(String id) {
        GiaSucDomainModel selected = null;
        try {
            String sql = "Select * from GiaSuc where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new GiaSucDomainModel(
                    id,
                    rs.getString("Ma"),
                    rs.getString("Ten"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
