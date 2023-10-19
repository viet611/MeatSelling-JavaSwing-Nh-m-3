/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class HoaDonChiTietViewModel {
    private String id;
    private String maHopThit;
    private String giaBan;
    private String idHoaDon;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(String id, String maHopThit, String giaBan, String idHoaDon) {
        this.id = id;
        this.maHopThit = maHopThit;
        this.giaBan = giaBan;
        this.idHoaDon = idHoaDon;
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

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    
}
