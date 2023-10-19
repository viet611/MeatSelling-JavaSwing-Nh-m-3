/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import ultilities.JDBCHelper;
import domainmodels.GiamGiaTheoHSDDomainModel;
import domainmodels.HangThanhVienDomainModel;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author vietv
 */
public class GiamGiaTheoHSDRepository {
    
    public static ArrayList<GiamGiaTheoHSDDomainModel> getAll() {
        ArrayList<GiamGiaTheoHSDDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from GiamGiaTheoHSD";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new GiamGiaTheoHSDDomainModel(
                        rs.getString("Id"),
                        rs.getDouble("PhanTramHSDConLai"),
                        rs.getDouble("PhanTramGiamGia")));
            }
            Comparator<GiamGiaTheoHSDDomainModel> comp = new Comparator<GiamGiaTheoHSDDomainModel>() {
                @Override
                public int compare(GiamGiaTheoHSDDomainModel o1, GiamGiaTheoHSDDomainModel o2) {
                    if(o1.getPhanTramHSDConLai()>o2.getPhanTramHSDConLai()) return -1;
                    else if(o1.getPhanTramHSDConLai()<o2.getPhanTramHSDConLai()) return 1;
                    else return 0;
                }
            };            
            Collections.sort(list,comp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer add(GiamGiaTheoHSDDomainModel giamGia) {
        Integer row = -1;
        try {
            String sql = "Insert into GiamGiaTheoHSD values (NEWID(),?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    giamGia.getPhanTramHSDConLai(),
                    giamGia.getPhanTramGiamGia()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(GiamGiaTheoHSDDomainModel giamGia) {
        Integer row = -1;
        try {
            String sql = "Update GiamGiaTheoHSD set PhanTramHSDConLai = ?, PhanTramGiamGia = ? where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    giamGia.getPhanTramHSDConLai(),
                    giamGia.getPhanTramGiamGia(),
                    giamGia.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from GiamGiaTheoHSD where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static GiamGiaTheoHSDDomainModel selectByID(String id) {
        GiamGiaTheoHSDDomainModel selected = null;
        try {
            String sql = "Select * from GiamGiaTheoHSD where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new GiamGiaTheoHSDDomainModel(id,
                    rs.getDouble("PhanTramHSDConLai"),
                    rs.getDouble("PhanTramGiamGia"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
