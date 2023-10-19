/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class TaiKhoanDangNhapDomainModel {
    private String id;
    private String tenTK;
    private String matKhau;
    private ChucVuDomainModel chucVu;
    private NhanVienDomainModel nhanVien;

    public TaiKhoanDangNhapDomainModel() {
    }

    public TaiKhoanDangNhapDomainModel(String id, String tenTK, String matKhau, ChucVuDomainModel chucVu, NhanVienDomainModel nhanVien) {
        this.id = id;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.nhanVien = nhanVien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public ChucVuDomainModel getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVuDomainModel chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVienDomainModel getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVienDomainModel nhanVien) {
        this.nhanVien = nhanVien;
    }
    
}
