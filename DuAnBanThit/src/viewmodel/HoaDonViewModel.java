/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class HoaDonViewModel {
    private String id;
    private String ngayTao;
    private String ngayThanhToan;
    private String idNV;
    private String idThanhVien;
    private String tinhTrang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String id, String ngayTao, String ngayThanhToan, String idNV, String idThanhVien, String tinhTrang) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.idNV = idNV;
        this.idThanhVien = idThanhVien;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdThanhVien() {
        return idThanhVien;
    }

    public void setIdThanhVien(String idThanhVien) {
        this.idThanhVien = idThanhVien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
}
