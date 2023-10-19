/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class GiamGiaTheoHSDDomainModel {
    private String id;
    private double phanTramHSDConLai;
    private double phanTramGiamGia;

    public GiamGiaTheoHSDDomainModel() {
    }

    public GiamGiaTheoHSDDomainModel(String id, double phanTramHSDConLai, double phanTramGiamGia) {
        this.id = id;
        this.phanTramHSDConLai = phanTramHSDConLai;
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPhanTramHSDConLai() {
        return phanTramHSDConLai;
    }

    public void setPhanTramHSDConLai(double phanTramHSDConLai) {
        this.phanTramHSDConLai = phanTramHSDConLai;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(double phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }
    
}
