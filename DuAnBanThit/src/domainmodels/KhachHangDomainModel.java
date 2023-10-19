/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

import java.util.Date;

/**
 *
 * @author vietv
 */
public class KhachHangDomainModel {
    private String id;
    private String maKH;
    private String hoTen;
    private String sDT;
    private boolean gioiTinh;
    private String diaChi;
    private Date ngaySinh;
    private ThanhVienDomainModel thanhVien;

    public KhachHangDomainModel() {
    }

    public KhachHangDomainModel(String id, String maKH, String hoTen, String sDT, boolean gioiTinh, String diaChi, Date ngaySinh, ThanhVienDomainModel thanhVien) {
        this.id = id;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.sDT = sDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.thanhVien = thanhVien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public ThanhVienDomainModel getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVienDomainModel thanhVien) {
        this.thanhVien = thanhVien;
    }
    
}
