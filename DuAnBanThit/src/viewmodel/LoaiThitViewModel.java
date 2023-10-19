package viewmodel;

/**
 *
 * @author Toan
 */
public class LoaiThitViewModel {
    private String id;
    private String maLoaiThit;
    private String tenGiaSuc;
    private String tenBoPhan;
    private String tenDonViTinh;
    private String giaTien;

    public LoaiThitViewModel() {
    }

    public LoaiThitViewModel(String id, String maLoaiThit, String tenGiaSuc, String tenBoPhan, String tenDonViTinh, String giaTien) {
        this.id = id;
        this.maLoaiThit = maLoaiThit;
        this.tenGiaSuc = tenGiaSuc;
        this.tenBoPhan = tenBoPhan;
        this.tenDonViTinh = tenDonViTinh;
        this.giaTien = giaTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaLoaiThit() {
        return maLoaiThit;
    }

    public void setMaLoaiThit(String maLoaiThit) {
        this.maLoaiThit = maLoaiThit;
    }

    public String getTenGiaSuc() {
        return tenGiaSuc;
    }

    public void setTenGiaSuc(String tenGiaSuc) {
        this.tenGiaSuc = tenGiaSuc;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public String getTenDonViTinh() {
        return tenDonViTinh;
    }

    public void setTenDonViTinh(String tenDonViTinh) {
        this.tenDonViTinh = tenDonViTinh;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }
    
}
