/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class HangThanhVienDomainModel {
    private String id;
    private String ten;
    private Double soTienDatHang;
    private Double phamTramGiamGiaHD;

    public HangThanhVienDomainModel() {
    }

    public HangThanhVienDomainModel(String id, String ten, Double soTienDatHang, Double phamTramGiamGiaHD) {
        this.id = id;
        this.ten = ten;
        this.soTienDatHang = soTienDatHang;
        this.phamTramGiamGiaHD = phamTramGiamGiaHD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getSoTienDatHang() {
        return soTienDatHang;
    }

    public void setSoTienDatHang(Double soTienDatHang) {
        this.soTienDatHang = soTienDatHang;
    }

    public Double getPhamTramGiamGiaHD() {
        return phamTramGiamGiaHD;
    }

    public void setPhamTramGiamGiaHD(Double phamTramGiamGiaHD) {
        this.phamTramGiamGiaHD = phamTramGiamGiaHD;
    }
    
}
