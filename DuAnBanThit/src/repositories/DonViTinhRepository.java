/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.DonViTinhDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author vietv
 */
public class DonViTinhRepository {
    public static ArrayList<DonViTinhDomainModel> getAll(){
        ArrayList<DonViTinhDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from DonViTinh";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new DonViTinhDomainModel(rs.getString("ID"),
                        rs.getString("TenDonVi"), rs.getDouble("QuyDoi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(DonViTinhDomainModel donViTinh){
        Integer row = -1;
        try {
            String sql = "Insert into DonViTinh values (NEWID(),?,?)";
            row = JDBCHelper.excuteUpdate(sql, donViTinh.getTenDonVi(), donViTinh.getQuyDoi());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static DonViTinhDomainModel selectByID(String id){
        DonViTinhDomainModel selected = null;
        try {
            String sql = "Select * from DonViTinh where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql,id);
            rs.next();
            selected = new DonViTinhDomainModel(id, rs.getString("TenDonVi"), rs.getDouble("QuyDoi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
