/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.BoPhanThitDomainModel;
import domainmodels.DonViTinhDomainModel;
import domainmodels.GiaSucDomainModel;
import domainmodels.LoaiThitDomainModel;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;
import repositories.BoPhanThitRepository;
import repositories.DonViTinhRepository;
import repositories.GiaSucRepository;
import repositories.LoaiThitRepository;
import viewmodel.BoPhanThitViewModel;
import viewmodel.DonViTinhViewModel;
import viewmodel.GiaSucViewModel;
import viewmodel.LoaiThitViewModel;

/**
 *
 * @author vietv
 */
public class SanPhamServices {

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }

    public String addGiaSuc(GiaSucViewModel giaSuc) {
        if (giaSuc.getMaGiaSuc().trim().length() == 0) {
            return "Bạn chưa nhập mã gia súc";
        }
        if (giaSuc.getTenGiaSuc().trim().length() == 0) {
            return "Bạn chưa nhập tên gia súc";
        }
        for (GiaSucDomainModel x : GiaSucRepository.getAll()) {
            if (removeAccent(giaSuc.getTenGiaSuc()).equalsIgnoreCase(x.getTen())) {
                return "Đã tồn tại tên gia súc";
            }
            if (x.getMa().equals(giaSuc.getMaGiaSuc())) {
                return "Vui lòng thử mã gia súc khác";
            }
        }
        return GiaSucRepository.add(new GiaSucDomainModel(null, giaSuc.getMaGiaSuc(), giaSuc.getTenGiaSuc())) > 0 ? "Thêm thành công" : "Thêm thất bại";
    }

    public String addBoPhanThit(BoPhanThitViewModel boPhanThitVM) {
        if (boPhanThitVM.getMa().trim().length() == 0) {
            return "Bạn chưa nhập mã bộ phận";
        }
        if (boPhanThitVM.getTen().trim().length() == 0) {
            return "Bạn chưa nhập tên bộ phận";
        }
        for (BoPhanThitDomainModel x : BoPhanThitRepository.getAll()) {
            if (removeAccent(boPhanThitVM.getTen()).equalsIgnoreCase(x.getTen())) {
                return "Đã tồn tại tên bộ phận";
            }
            if (x.getMa().equals(boPhanThitVM.getMa())) {
                return "Vui lòng thử mã khác";
            }
        }
        return BoPhanThitRepository.add(new BoPhanThitDomainModel(null, boPhanThitVM.getMa(), boPhanThitVM.getTen())) > 0 ? "Thêm thành công" : "Thêm thất bại";
    }

    public String addDonViTinh(DonViTinhViewModel donViTinhVM) {
        DonViTinhDomainModel donViTinhDM = new DonViTinhDomainModel();
        if (donViTinhVM.getTenDonVi().trim().length() == 0) {
            return "Bạn chưa nhập tên đơn vị";
        }
        if (donViTinhVM.getQuyUoc().trim().length() == 0) {
            return "Bạn chưa nhập quy ước";
        }

        donViTinhDM.setTenDonVi(donViTinhVM.getTenDonVi());
        try {
            donViTinhDM.setQuyDoi(Double.valueOf(donViTinhVM.getQuyUoc()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Quy ước đơn vị tính phải ở dạng số";
        }
        for (DonViTinhDomainModel x : DonViTinhRepository.getAll()) {
            if (x.getQuyDoi() == donViTinhDM.getQuyDoi()) {
                return "Đã tồn tại đơn vị tính " + x.getTenDonVi() + " với chung quy ước";
            }
        }
        return DonViTinhRepository.add(donViTinhDM) > 0 ? "Thêm thành công" : "Thêm thất bại";
    }

    public ArrayList<LoaiThitViewModel> getAllLoaiThit() {
        ArrayList<LoaiThitViewModel> list = new ArrayList<>();
        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            list.add(new LoaiThitViewModel(
                    x.getId(),
                    x.getMa(),
                    x.getGiaSuc().getTen(),
                    x.getViTriThit().getTen(),
                    String.valueOf(x.getDonViTinh().getTenDonVi()),
                    String.valueOf(x.getGiaTien())
            ));
        }
        return list;
    }

    public ArrayList<DonViTinhViewModel> getAllDonViTinh() {
        ArrayList<DonViTinhViewModel> list = new ArrayList<>();
        for (DonViTinhDomainModel x : DonViTinhRepository.getAll()) {
            list.add(new DonViTinhViewModel(
                    x.getId(),
                    x.getTenDonVi(),
                    String.valueOf(x.getQuyDoi())
            ));
        }
        return list;
    }

    public ArrayList<GiaSucViewModel> getAllGiaSuc() {
        ArrayList<GiaSucViewModel> list = new ArrayList<>();
        for (GiaSucDomainModel x : GiaSucRepository.getAll()) {
            list.add(new GiaSucViewModel(
                    x.getId(),
                    x.getMa(),
                    x.getTen()
            ));
        }
        return list;
    }

    public ArrayList<BoPhanThitViewModel> getAllBoPhan() {
        ArrayList<BoPhanThitViewModel> list = new ArrayList<>();
        for (BoPhanThitDomainModel x : BoPhanThitRepository.getAll()) {
            list.add(new BoPhanThitViewModel(x.getId(), x.getMa(), x.getTen()));
        }
        return list;
    }

    public String checkNull(LoaiThitViewModel loaiThitVM) {
        if (loaiThitVM.getMaLoaiThit().trim().length() == 0) {
            return "Bạn chưa nhập mã loại thịt";
        }
        if (loaiThitVM.getGiaTien().trim().length() == 0) {
            return "Bạn chưa nhập giá tiền";
        }
        return null;
    }

    public String addLoaiThit(LoaiThitViewModel loaiThitVM) {
        if (checkNull(loaiThitVM) != null) {
            return checkNull(loaiThitVM);
        }
        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            if (x.getMa().equals(loaiThitVM.getMaLoaiThit())) {
                return "Mã loại thịt trùng";
            }
            if (x.getGiaSuc().getTen().equals(loaiThitVM.getTenGiaSuc())) {
                if (x.getViTriThit().getTen().equals(loaiThitVM.getTenBoPhan())) {
                    return "Loại thịt đã tồn tại";
                }
            }
        }

        LoaiThitDomainModel loaiThitDM = new LoaiThitDomainModel();
        loaiThitDM.setMa(loaiThitVM.getMaLoaiThit());
        for (GiaSucDomainModel x : GiaSucRepository.getAll()) {
            if (x.getTen().equals(loaiThitVM.getTenGiaSuc())) {
                loaiThitDM.setGiaSuc(x);
                break;
            }
        }
        for (BoPhanThitDomainModel x : BoPhanThitRepository.getAll()) {
            if (x.getTen().equals(loaiThitVM.getTenBoPhan())) {
                loaiThitDM.setViTriThit(x);
                break;
            }
        }
        for (DonViTinhDomainModel x : DonViTinhRepository.getAll()) {
            if (x.getTenDonVi().equals(loaiThitVM.getTenDonViTinh())) {
                loaiThitDM.setDonViTinh(x);
                break;
            }
        }
        loaiThitDM.setGiaTien(Double.parseDouble(loaiThitVM.getGiaTien()));
        return LoaiThitRepository.add(loaiThitDM) > 0 ? "Thêm thành công" : "Thêm thất bại";
    }

    public String updateLoaiThit(LoaiThitViewModel loaiThitVM) {
        if (checkNull(loaiThitVM) != null) {
            return checkNull(loaiThitVM);
        }
        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            if (x.getMa().equals(loaiThitVM.getMaLoaiThit())) {
                if (x.getId().equals(loaiThitVM.getId())) {
                    continue;
                }
                return "Mã loại thịt trùng";
            }
            if (x.getGiaSuc().getTen().equals(loaiThitVM.getTenGiaSuc())) {
                if (x.getId().equals(loaiThitVM.getId())) {
                    continue;
                }
                if (x.getViTriThit().getTen().equals(loaiThitVM.getTenBoPhan())) {
                    return "Loại thịt đã tồn tại";
                }
            }
        }

        LoaiThitDomainModel loaiThitDM = new LoaiThitDomainModel();
        loaiThitDM.setId(loaiThitVM.getId());
        loaiThitDM.setMa(loaiThitVM.getMaLoaiThit());
        for (GiaSucDomainModel x : GiaSucRepository.getAll()) {
            if (x.getTen().equals(loaiThitVM.getTenGiaSuc())) {
                loaiThitDM.setGiaSuc(x);
                break;
            }
        }
        for (BoPhanThitDomainModel x : BoPhanThitRepository.getAll()) {
            if (x.getTen().equals(loaiThitVM.getTenBoPhan())) {
                loaiThitDM.setViTriThit(x);
                break;
            }
        }
        for (DonViTinhDomainModel x : DonViTinhRepository.getAll()) {
            if (x.getTenDonVi().equals(loaiThitVM.getTenDonViTinh())) {
                loaiThitDM.setDonViTinh(x);
                break;
            }
        }
        loaiThitDM.setGiaTien(Double.parseDouble(loaiThitVM.getGiaTien()));
        return LoaiThitRepository.update(loaiThitDM) > 0 ? "Sửa thành công" : "Sửa thất bại";
    }

    public String deleteLoaiThit(String id) {
        return LoaiThitRepository.delete(id) > 0 ? "Xóa thành công" : "Xóa thất bại";
    }

    public ArrayList<LoaiThitViewModel> selectPromotedLoaiThit(LoaiThitViewModel loaiThitVM) {
        String markID = null;
        ArrayList<LoaiThitViewModel> list = new ArrayList<>();
        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            if (x.getViTriThit().getTen().equals(loaiThitVM.getTenBoPhan())) {
                if (x.getGiaSuc().getTen().equals(loaiThitVM.getTenGiaSuc())) {
                    list.add(new LoaiThitViewModel(x.getId(),
                            x.getMa(),
                            x.getGiaSuc().getTen(),
                            x.getViTriThit().getTen(),
                            String.valueOf(x.getDonViTinh().getTenDonVi()),
                            String.valueOf(x.getGiaTien())));
                    markID = x.getId();
                    break;
                }
            }
        }

        for (LoaiThitDomainModel x : LoaiThitRepository.getAll()) {
            if (x.getId().equals(markID)) {
                continue;
            }
            list.add(new LoaiThitViewModel(
                    x.getId(),
                    x.getMa(),
                    x.getGiaSuc().getTen(),
                    x.getViTriThit().getTen(),
                    String.valueOf(x.getDonViTinh().getTenDonVi()),
                    String.valueOf(x.getGiaTien())
            ));

        }
        return list;
    }
}
