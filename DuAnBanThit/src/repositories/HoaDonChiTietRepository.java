/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.HoaDonChiTietDomainModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietRepository {
    public static ArrayList<HoaDonChiTietDomainModel> getAll(){
        ArrayList<HoaDonChiTietDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from HoaDonChiTiet";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while(rs.next()){
                list.add(new HoaDonChiTietDomainModel(
                        rs.getString("ID"),
                        HopThitRepository.selectByID(rs.getString("IDHopThit")),
                        rs.getString("IDGiamGiaTheoHSD") == null ? null : GiamGiaTheoHSDRepository.selectByID(rs.getString("IDGiamGiaTheoHSD")),
                        HoaDonRepository.selectByID(rs.getString("IDHoaDon"))));               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Integer add(HoaDonChiTietDomainModel hoaDonCT) {
        Integer row = -1;
        try {
            String sql = "Insert into HoaDonChiTiet values (NEWID(),?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    hoaDonCT.getHopThit().getId(),
                    hoaDonCT.getGiamGiaTheoHSD() == null ? null : hoaDonCT.getGiamGiaTheoHSD().getId(),
                    hoaDonCT.getHoaDon().getId()                    
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(HoaDonChiTietDomainModel hoaDonCT) {
        Integer row = -1;
        try {
            String sql = "Update HoaDonChiTiet "
                    + "set IDHopThit = ?, IDGiamGiaTheoHSD = ?, IDHoaDon = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    hoaDonCT.getHopThit().getId(),
                    hoaDonCT.getGiamGiaTheoHSD() == null ? null : hoaDonCT.getGiamGiaTheoHSD().getId(),
                    hoaDonCT.getHoaDon().getId()  ,
                    hoaDonCT.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from HoaDonChiTiet where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static HoaDonChiTietDomainModel selectByID(String id) {
        HoaDonChiTietDomainModel selected = null;
        try {
            String sql = "Select * from HoaDonChiTiet where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new HoaDonChiTietDomainModel(
                        id,
                        HopThitRepository.selectByID(rs.getString("IDHopThit")),
                        rs.getString("IDGiamGiaTheoHSD") == null ? null : GiamGiaTheoHSDRepository.selectByID(rs.getString("IDGiamGiaTheoHSD")),
                        HoaDonRepository.selectByID(rs.getString("IDHoaDon")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
    public static ArrayList<HoaDonChiTietDomainModel> getAllByIDHoaDon(String idHoaDon){
        ArrayList<HoaDonChiTietDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from HoaDonChiTiet where IDHoaDon = ? ";
            ResultSet rs = JDBCHelper.excuteQuery(sql,idHoaDon);
            while(rs.next()){
                list.add(new HoaDonChiTietDomainModel(
                        rs.getString("ID"),
                        HopThitRepository.selectByID(rs.getString("IDHopThit")),
                        rs.getString("IDGiamGiaTheoHSD") == null ? null : GiamGiaTheoHSDRepository.selectByID(rs.getString("IDGiamGiaTheoHSD")),
                        HoaDonRepository.selectByID(rs.getString("IDHoaDon"))                        
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
