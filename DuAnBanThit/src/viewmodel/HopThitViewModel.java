/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class HopThitViewModel {
    private String id;
    private String maHopThit;
    private String tenLoaiThit;
    private String khoiLuong;
    private String tenDonVi;
    private String giaGoc;
    private String giaBan;
    private String NSX;
    private String HSD;
    private String tinhTrang;

    public HopThitViewModel() {
    }

    public HopThitViewModel(String id, String maHopThit, String tenLoaiThit, String khoiLuong, String tenDonVi, String giaGoc, String giaBan, String NSX, String HSD, String tinhTrang) {
        this.id = id;
        this.maHopThit = maHopThit;
        this.tenLoaiThit = tenLoaiThit;
        this.khoiLuong = khoiLuong;
        this.tenDonVi = tenDonVi;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.NSX = NSX;
        this.HSD = HSD;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHopThit() {
        return maHopThit;
    }

    public void setMaHopThit(String maHopThit) {
        this.maHopThit = maHopThit;
    }

    public String getTenLoaiThit() {
        return tenLoaiThit;
    }

    public void setTenLoaiThit(String tenLoaiThit) {
        this.tenLoaiThit = tenLoaiThit;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public String getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(String giaGoc) {
        this.giaGoc = giaGoc;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getHSD() {
        return HSD;
    }

    public void setHSD(String HSD) {
        this.HSD = HSD;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
