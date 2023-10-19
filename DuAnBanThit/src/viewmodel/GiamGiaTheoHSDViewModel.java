/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class GiamGiaTheoHSDViewModel {
    private String id;
    private String hsdConLai;
    private String giamGia;

    public GiamGiaTheoHSDViewModel() {
    }

    public GiamGiaTheoHSDViewModel(String id, String hsdConLai, String giamGia) {
        this.id = id;
        this.hsdConLai = hsdConLai;
        this.giamGia = giamGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHsdConLai() {
        return hsdConLai;
    }

    public void setHsdConLai(String hsdConLai) {
        this.hsdConLai = hsdConLai;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }
    
}
