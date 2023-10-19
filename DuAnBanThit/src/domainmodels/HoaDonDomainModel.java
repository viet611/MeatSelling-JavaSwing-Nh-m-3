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
public class HoaDonDomainModel {
    private String id;
    private Date ngayTao;
    private Date ngayThanhToan;
    private TaiKhoanDangNhapDomainModel taiKhoanDN;
    private ThanhVienDomainModel thanhVien;
    private String tinhTrang;

    public HoaDonDomainModel() {
    }

    public HoaDonDomainModel(String id, Date ngayTao, Date ngayThanhToan, TaiKhoanDangNhapDomainModel taiKhoanDN, ThanhVienDomainModel thanhVien, String tinhTrang) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.taiKhoanDN = taiKhoanDN;
        this.thanhVien = thanhVien;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public TaiKhoanDangNhapDomainModel getTaiKhoanDN() {
        return taiKhoanDN;
    }

    public void setTaiKhoanDN(TaiKhoanDangNhapDomainModel taiKhoanDN) {
        this.taiKhoanDN = taiKhoanDN;
    }

    public ThanhVienDomainModel getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ThanhVienDomainModel thanhVien) {
        this.thanhVien = thanhVien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
