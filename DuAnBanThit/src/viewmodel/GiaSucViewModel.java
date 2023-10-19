/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class GiaSucViewModel {
    private String id;
    private String maGiaSuc;
    private String tenGiaSuc;

    public GiaSucViewModel() {
    }

    public GiaSucViewModel(String id, String maGiaSuc, String tenGiaSuc) {
        this.id = id;
        this.maGiaSuc = maGiaSuc;
        this.tenGiaSuc = tenGiaSuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaGiaSuc() {
        return maGiaSuc;
    }

    public void setMaGiaSuc(String maGiaSuc) {
        this.maGiaSuc = maGiaSuc;
    }

    public String getTenGiaSuc() {
        return tenGiaSuc;
    }

    public void setTenGiaSuc(String tenGiaSuc) {
        this.tenGiaSuc = tenGiaSuc;
    }
    
}
