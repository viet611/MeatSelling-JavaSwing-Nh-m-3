/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import ultilities.JDBCHelper;
import domainmodels.HoaDonDomainModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vietv
 */
public class HoaDonRepository {

    public static ArrayList<HoaDonDomainModel> getAll() {
        ArrayList<HoaDonDomainModel> list = new ArrayList<>();
        try {
            String sql = "Select * from HoaDon";
            ResultSet rs = JDBCHelper.excuteQuery(sql);
            while (rs.next()) {
                list.add(new HoaDonDomainModel(
                        rs.getString("ID"),
                        rs.getDate("NgayTao"),
                        rs.getDate("NgayThanhToan"),
                        TaiKhoanDangNhapRepository.selectByID(rs.getString("IDTaiKhoanDN")),
                        rs.getString("IDThanhVien") == null ? null : ThanhVienRepository.selectByID(rs.getString("IDThanhVien")),
                        rs.getString("TinhTrang")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer add(HoaDonDomainModel hoaDon) {
        Integer row = -1;
        try {
            String sql = "Insert into HoaDon values (NEWID(),?,?,?,?,?)";
            row = JDBCHelper.excuteUpdate(sql,
                    hoaDon.getNgayTao(),
                    hoaDon.getNgayThanhToan(),
                    hoaDon.getTaiKhoanDN().getId(),
                    hoaDon.getThanhVien() == null ? null : hoaDon.getThanhVien().getId(),
                    hoaDon.getTinhTrang()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer update(HoaDonDomainModel hoaDon) {
        Integer row = -1;
        try {
            String sql = "Update HoaDon "
                    + "set NgayThanhToan = ?, IDTaiKhoanDN = ?, IDThanhVien = ?, TinhTrang = ? "
                    + "where ID = ?";
            row = JDBCHelper.excuteUpdate(sql,
                    hoaDon.getNgayThanhToan(),
                    hoaDon.getTaiKhoanDN().getId(),
                    hoaDon.getThanhVien() == null ? null : hoaDon.getThanhVien().getId(),
                    hoaDon.getTinhTrang(),
                    hoaDon.getId()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static Integer delete(String id) {
        Integer row = -1;
        try {
            String sql = "Delete from HoaDon where ID = ?";
            row = JDBCHelper.excuteUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static HoaDonDomainModel selectByID(String id) {
        
        HoaDonDomainModel selected = null;
        try {
            String sql = "Select * from HoaDon where ID = ?";
            ResultSet rs = JDBCHelper.excuteQuery(sql, id);
            rs.next();
            selected = new HoaDonDomainModel(
                    id,
                    rs.getDate("NgayTao"),
                    rs.getDate("NgayThanhToan"),
                    TaiKhoanDangNhapRepository.selectByID(rs.getString("IDTaiKhoanDN")),
                    rs.getString("IDThanhVien") == null ? null : ThanhVienRepository.selectByID(rs.getString("IDThanhVien")),
                    rs.getString("TinhTrang")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }
}
