/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class ThanhVienDomainModel {
    private String id;
    private String ma;
    private HangThanhVienDomainModel hangThanhVien;

    public ThanhVienDomainModel() {
    }

    public ThanhVienDomainModel(String id, String ma, HangThanhVienDomainModel hangThanhVien) {
        this.id = id;
        this.ma = ma;
        this.hangThanhVien = hangThanhVien;
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

    public HangThanhVienDomainModel getHangThanhVien() {
        return hangThanhVien;
    }

    public void setHangThanhVien(HangThanhVienDomainModel hangThanhVien) {
        this.hangThanhVien = hangThanhVien;
    }
    
}
