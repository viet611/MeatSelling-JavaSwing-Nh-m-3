/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import ultilities.JDBCHelper;
import domainmodels.BoPhanThitDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vietv
 */
public class BoPhanThitRepository {

    public static ArrayList<BoPhanThitDomainModel> getAll() {
        ArrayList<BoPhanThitDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from BoPhanThit";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new BoPhanThitDomainModel(
                        rs.getString("ID"),
                        rs.getString("Ma"),
                        rs.getString("Ten"))
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(BoPhanThitDomainModel viTriThit){
        Integer row = -1;
        try {
            String sql = "Insert into BoPhanThit values (NEWID(),?,?)";
            row = JDBCHelper.excuteUpdate(sql,viTriThit.getTen(), viTriThit.getMa());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static BoPhanThitDomainModel selectByID(String id){
        BoPhanThitDomainModel selected = null;
        try {
            String sql = "Select * from BoPhanThit where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql,id);
            rs.next();
            selected = new BoPhanThitDomainModel(id, rs.getString("Ma"), rs.getString("Ten"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
