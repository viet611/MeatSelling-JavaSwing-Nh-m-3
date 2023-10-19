/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietDomainModel {
    private String id;
    private HopThitDomainModel hopThit;
    private GiamGiaTheoHSDDomainModel giamGiaTheoHSD;
    private HoaDonDomainModel hoaDon;

    public HoaDonChiTietDomainModel() {
    }

    public HoaDonChiTietDomainModel(String id, HopThitDomainModel hopThit, GiamGiaTheoHSDDomainModel giamGiaTheoHSD, HoaDonDomainModel hoaDon) {
        this.id = id;
        this.hopThit = hopThit;
        this.giamGiaTheoHSD = giamGiaTheoHSD;
        this.hoaDon = hoaDon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HopThitDomainModel getHopThit() {
        return hopThit;
    }

    public void setHopThit(HopThitDomainModel hopThit) {
        this.hopThit = hopThit;
    }

    public GiamGiaTheoHSDDomainModel getGiamGiaTheoHSD() {
        return giamGiaTheoHSD;
    }

    public void setGiamGiaTheoHSD(GiamGiaTheoHSDDomainModel giamGiaTheoHSD) {
        this.giamGiaTheoHSD = giamGiaTheoHSD;
    }

    public HoaDonDomainModel getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDonDomainModel hoaDon) {
        this.hoaDon = hoaDon;
    }
    
}
