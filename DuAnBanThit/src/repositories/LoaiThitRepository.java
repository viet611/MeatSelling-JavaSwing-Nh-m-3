/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.LoaiThitDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author vietv
 */
public class LoaiThitRepository {
    public static ArrayList<LoaiThitDomainModel> getAll(){
        ArrayList<LoaiThitDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from LoaiThit";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new LoaiThitDomainModel(
                        rs.getString("Id"),
                        rs.getString("Ma"),
                        GiaSucRepository.selectByID(rs.getString("IDGiaSuc")),
                        BoPhanThitRepository.selectByID(rs.getString("IDBoPhanThit")),
                        DonViTinhRepository.selectByID(rs.getString("IDDonViTinh")),
                        rs.getDouble("GiaTien")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(LoaiThitDomainModel loaiThit){
        Integer row = -1;
        try {
            String sql = "Insert into LoaiThit values (NEWID(),?,?,?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    loaiThit.getMa(),
                    loaiThit.getGiaSuc().getId(),
                    loaiThit.getViTriThit().getId(),
                    loaiThit.getDonViTinh().getId(),
                    loaiThit.getGiaTien());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static Integer update(LoaiThitDomainModel loaiThit){
        Integer row = -1;
        try {
            String sql = "Update LoaiThit "
                    + "set Ma = ?, IDGiaSuc = ?, IDBoPhanThit = ?, IDDonViTinh = ?, GiaTien = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    loaiThit.getMa(),
                    loaiThit.getGiaSuc().getId(),
                    loaiThit.getViTriThit().getId(),
                    loaiThit.getDonViTinh().getId(),
                    loaiThit.getGiaTien(),
                    loaiThit.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static Integer delete(String id){
        Integer row = -1;
        try {
            String sql = "Delete from LoaiThit where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    public static LoaiThitDomainModel selectByID(String id){
        LoaiThitDomainModel selected = null;
        try {
            String sql = "Select * from LoaiThit where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new LoaiThitDomainModel(id,
                        rs.getString("Ma"),
                        GiaSucRepository.selectByID(rs.getString("IDGiaSuc")),
                        BoPhanThitRepository.selectByID(rs.getString("IDBoPhanThit")),
                        DonViTinhRepository.selectByID(rs.getString("IDDonViTinh")),
                        rs.getDouble("GiaTien"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
