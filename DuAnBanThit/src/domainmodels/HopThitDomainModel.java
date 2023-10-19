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
public class HopThitDomainModel {
    private String id;
    private String ma;
    private LoaiThitDomainModel loaiThit;
    private double khoiLuong;
    private DonViTinhDomainModel donViTinh;
    private Date NSX;
    private Date HSD;

    public HopThitDomainModel() {
    }

    public HopThitDomainModel(String id, String ma, LoaiThitDomainModel loaiThit, double khoiLuong, DonViTinhDomainModel donViTinh, Date NSX, Date HSD) {
        this.id = id;
        this.ma = ma;
        this.loaiThit = loaiThit;
        this.khoiLuong = khoiLuong;
        this.donViTinh = donViTinh;
        this.NSX = NSX;
        this.HSD = HSD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public LoaiThitDomainModel getLoaiThit() {
        return loaiThit;
    }

    public void setLoaiThit(LoaiThitDomainModel loaiThit) {
        this.loaiThit = loaiThit;
    }

    public double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public DonViTinhDomainModel getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(DonViTinhDomainModel donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Date getNSX() {
        return NSX;
    }

    public void setNSX(Date NSX) {
        this.NSX = NSX;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }
    
}
