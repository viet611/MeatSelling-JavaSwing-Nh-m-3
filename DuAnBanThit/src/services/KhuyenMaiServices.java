/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.GiamGiaTheoHSDDomainModel;
import java.util.ArrayList;
import repositories.GiamGiaTheoHSDRepository;
import viewmodel.GiamGiaTheoHSDViewModel;

/**
 *
 * @author vietv
 */
public class KhuyenMaiServices {

    public ArrayList<GiamGiaTheoHSDViewModel> getAll() {
        ArrayList<GiamGiaTheoHSDViewModel> list = new ArrayList<>();
        for (GiamGiaTheoHSDDomainModel x : GiamGiaTheoHSDRepository.getAll()) {
            GiamGiaTheoHSDViewModel giamGia = new GiamGiaTheoHSDViewModel(
                    x.getId(),
                    String.valueOf(x.getPhanTramHSDConLai()),
                    String.valueOf(x.getPhanTramGiamGia()));
            list.add(giamGia);
        }
        return list;
    }

    public String checkNull(GiamGiaTheoHSDViewModel giamGiaVM) {
        if (giamGiaVM.getHsdConLai().trim().length() == 0) {
            return "Bạn chưa nhập mục phần trăm HSD còn lại";
        }
        if (giamGiaVM.getHsdConLai().trim().length() == 0) {
            return "Bạn chưa nhập mục phần trăm HSD còn lại";
        }
        return null;
    }

    public String add(GiamGiaTheoHSDViewModel giamGiaVM) {
        if (checkNull(giamGiaVM) != null) {
            return checkNull(giamGiaVM);
        }
        GiamGiaTheoHSDDomainModel giamGiaDM = new GiamGiaTheoHSDDomainModel();
        try {
            giamGiaDM.setPhanTramHSDConLai(Double.parseDouble(giamGiaVM.getHsdConLai()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Phần trăm HSD Còn lại phải ở dạng số";
        }
        try {
            giamGiaDM.setPhanTramGiamGia(Double.parseDouble(giamGiaVM.getGiamGia()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Phần trăm giảm giá phải ở dạng số";
        }
        return GiamGiaTheoHSDRepository.add(giamGiaDM) > 0 ? "Thêm thành công" : "Thêm thất bại";
    }
    public String update(GiamGiaTheoHSDViewModel giamGiaVM) {
        if (checkNull(giamGiaVM) != null) {
            return checkNull(giamGiaVM);
        }
        GiamGiaTheoHSDDomainModel giamGiaDM = new GiamGiaTheoHSDDomainModel();
        giamGiaDM.setId(giamGiaVM.getId());
        try {
            giamGiaDM.setPhanTramHSDConLai(Double.parseDouble(giamGiaVM.getHsdConLai()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Phần trăm HSD Còn lại phải ở dạng số";
        }
        try {
            giamGiaDM.setPhanTramGiamGia(Double.parseDouble(giamGiaVM.getGiamGia()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Phần trăm giảm giá phải ở dạng số";
        }
        return GiamGiaTheoHSDRepository.update(giamGiaDM) > 0 ? "Sửa thành công" : "Sửa thất bại";
    }
    public String delete(String id) {
        return GiamGiaTheoHSDRepository.delete(id) > 0 ? "Xóa thành công" : "Xóa thất bại";
    }
}
