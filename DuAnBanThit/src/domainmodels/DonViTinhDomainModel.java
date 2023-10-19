/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodels;

/**
 *
 * @author vietv
 */
public class DonViTinhDomainModel {
    private String id;
    private String tenDonVi;
    private double quyDoi;

    public DonViTinhDomainModel() {
    }

    public DonViTinhDomainModel(String id, String tenDonVi, double quyDoi) {
        this.id = id;
        this.tenDonVi = tenDonVi;
        this.quyDoi = quyDoi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public double getQuyDoi() {
        return quyDoi;
    }

    public void setQuyDoi(double quyDoi) {
        this.quyDoi = quyDoi;
    }

}
