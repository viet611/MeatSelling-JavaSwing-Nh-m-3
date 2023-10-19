/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class LoaiThitDomainModel {
    private String id;
    private String ma;
    private GiaSucDomainModel giaSuc;
    private BoPhanThitDomainModel viTriThit;
    private DonViTinhDomainModel donViTinh;
    private double giaTien;

    public LoaiThitDomainModel() {
    }

    public LoaiThitDomainModel(String id, String ma, GiaSucDomainModel giaSuc, BoPhanThitDomainModel viTriThit, DonViTinhDomainModel donViTinh, double giaTien) {
        this.id = id;
        this.ma = ma;
        this.giaSuc = giaSuc;
        this.viTriThit = viTriThit;
        this.donViTinh = donViTinh;
        this.giaTien = giaTien;
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

    public GiaSucDomainModel getGiaSuc() {
        return giaSuc;
    }

    public void setGiaSuc(GiaSucDomainModel giaSuc) {
        this.giaSuc = giaSuc;
    }

    public BoPhanThitDomainModel getViTriThit() {
        return viTriThit;
    }

    public void setViTriThit(BoPhanThitDomainModel viTriThit) {
        this.viTriThit = viTriThit;
    }

    public DonViTinhDomainModel getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(DonViTinhDomainModel donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    
}
