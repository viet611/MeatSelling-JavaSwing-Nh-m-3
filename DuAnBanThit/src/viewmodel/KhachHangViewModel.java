/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

/**
 *
 * @author pc
 */
public class KhachHangViewModel {
    private String id;
    private String MaKH;
    private String HoTen;   
    private String SDT;
    private String GioiTinh;
    private String DiaChi;
    private String NgaySinh;
    private String MaTV;
    private String HangTV;
    private String IDThanhVien;
    private String SoDiemTichLuy;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String id, String MaKH, String HoTen, String SDT, String GioiTinh, String DiaChi, String NgaySinh, String MaTV, String HangTV, String IDThanhVien, String SoDiemTichLuy) {
        this.id = id;
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.MaTV = MaTV;
        this.HangTV = HangTV;
        this.IDThanhVien = IDThanhVien;
        this.SoDiemTichLuy = SoDiemTichLuy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getMaTV() {
        return MaTV;
    }

    public void setMaTV(String MaTV) {
        this.MaTV = MaTV;
    }

    public String getHangTV() {
        return HangTV;
    }

    public void setHangTV(String HangTV) {
        this.HangTV = HangTV;
    }

    public String getIDThanhVien() {
        return IDThanhVien;
    }

    public void setIDThanhVien(String IDThanhVien) {
        this.IDThanhVien = IDThanhVien;
    }

    public String getSoDiemTichLuy() {
        return SoDiemTichLuy;
    }

    public void setSoDiemTichLuy(String SoDiemTichLuy) {
        this.SoDiemTichLuy = SoDiemTichLuy;
    }
    
}
