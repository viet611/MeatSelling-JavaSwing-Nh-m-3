/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.HopThitDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author vietv
 */
public class HopThitRepository {
    public static ArrayList<HopThitDomainModel> getAll(){
        ArrayList<HopThitDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from HopThit";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new HopThitDomainModel(
                        rs.getString("ID"),
                        rs.getString("Ma"), 
                        LoaiThitRepository.selectByID(rs.getString("IDLoaiThit")),
                        rs.getDouble("KhoiLuong"),
                        DonViTinhRepository.selectByID(rs.getString("IDDonViTinh")),
                        rs.getDate("NSX"),
                        rs.getDate("HSD")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(HopThitDomainModel hopThit){
        Integer row = -1;
        try {
            String sql = "Insert into HopThit values (NEWID(),?,?,?,?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    hopThit.getMa(),
                    hopThit.getLoaiThit().getId(),
                    hopThit.getKhoiLuong(),
                    hopThit.getDonViTinh().getId(),
                    hopThit.getNSX(),
                    hopThit.getHSD());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static Integer update(HopThitDomainModel hopThit){
        Integer row = -1;
        try {
            String sql = "Update HopThit "
                    + "set Ma = ?, IDLoaiThit = ?, KhoiLuong = ?, IDDonViTinh = ?, NSX = ?, HSD = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    hopThit.getMa(),
                    hopThit.getLoaiThit().getId(),
                    hopThit.getKhoiLuong(),
                    hopThit.getDonViTinh().getId(),
                    hopThit.getNSX(),
                    hopThit.getHSD(),
                    hopThit.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static Integer delete(String id){
        Integer row = -1;
        try {
            String sql = "Delete from HopThit where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static HopThitDomainModel selectByID(String id){
        HopThitDomainModel selected = null;
        try {
            String sql = "Select * from HopThit where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new HopThitDomainModel(id,
                        rs.getString("Ma"), 
                        LoaiThitRepository.selectByID(rs.getString("IDLoaiThit")),
                        rs.getDouble("KhoiLuong"),
                        DonViTinhRepository.selectByID(rs.getString("IDDonViTinh")),
                        rs.getDate("NSX"),
                        rs.getDate("HSD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
