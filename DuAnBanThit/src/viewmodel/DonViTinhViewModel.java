/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class DonViTinhViewModel {
    private String id;
    private String tenDonVi;
    private String quyUoc;

    public DonViTinhViewModel() {
    }

    public DonViTinhViewModel(String id, String tenDonVi, String quyUoc) {
        this.id = id;
        this.tenDonVi = tenDonVi;
        this.quyUoc = quyUoc;
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

    public String getQuyUoc() {
        return quyUoc;
    }

    public void setQuyUoc(String quyUoc) {
        this.quyUoc = quyUoc;
    }
    
}
