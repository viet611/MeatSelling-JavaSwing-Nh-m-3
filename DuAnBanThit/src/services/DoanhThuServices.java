/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.HoaDonChiTietDomainModel;
import domainmodels.HoaDonDomainModel;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import repositories.HoaDonChiTietRepository;
import repositories.HoaDonRepository;
import viewmodel.DoanhThuViewModel;
import viewmodel.HoaDonChiTietViewModel;
import viewmodel.HoaDonViewModel;

/**
 *
 * @author vietv
 */
public class DoanhThuServices {

    private SimpleDateFormat sdf;

    public ArrayList<String> getAllYears() {
        ArrayList<String> allYears = new ArrayList<>();
        sdf = new SimpleDateFormat("yyyy");
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getTinhTrang().equals("Chưa thanh toán")) {
                continue;
            }
            String ngayTTStr = sdf.format(x.getNgayThanhToan());
            if (!allYears.contains(ngayTTStr)) {
                allYears.add(ngayTTStr);
            }
        }
        return allYears;
    }

    public ArrayList<String> getAllMonthsByYear(String year) {
        ArrayList<String> allMonths = new ArrayList<>();
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getTinhTrang().equals("Chưa thanh toán")) {
                continue;
            }
            sdf = new SimpleDateFormat("yyyy");
            String namTTStr = sdf.format(x.getNgayThanhToan());
            if (namTTStr.equals(year)) {
                sdf.applyPattern("MM");
                String monthTTStr = sdf.format(x.getNgayThanhToan());
                if (!allMonths.contains(monthTTStr)) {
                    allMonths.add(monthTTStr);
                }
            }
        }
        return allMonths;
    }

    public ArrayList<String> getAllDaysByMonthAndYear(String month, String year) {
        ArrayList<String> allDays = new ArrayList<>();
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getTinhTrang().equals("Chưa thanh toán")) {
                continue;
            }
            sdf = new SimpleDateFormat("MM");
            String monthTTStr = sdf.format(x.getNgayThanhToan());
            if (monthTTStr.equals(month)) {
                sdf.applyPattern("yyyy");
                String yearTTStr = sdf.format(x.getNgayThanhToan());
                if (yearTTStr.equals(year)) {
                    sdf.applyPattern("dd");
                    String dayTTStr = sdf.format(x.getNgayThanhToan());
                    if (!allDays.contains(dayTTStr)) {
                        allDays.add(dayTTStr);
                    }
                }
            }
        }
        return allDays;
    }
private double tinhGiaHopThit(HoaDonChiTietDomainModel hoaDonCTDM) {
        double giaTienMoi1g = hoaDonCTDM.getHopThit().getLoaiThit().getGiaTien() / hoaDonCTDM.getHopThit().getLoaiThit().getDonViTinh().getQuyDoi();
        double canNang = hoaDonCTDM.getHopThit().getKhoiLuong() * hoaDonCTDM.getHopThit().getDonViTinh().getQuyDoi();
        if (hoaDonCTDM.getGiamGiaTheoHSD() == null) {
            return canNang * giaTienMoi1g;
        } else {
            return canNang * giaTienMoi1g * hoaDonCTDM.getGiamGiaTheoHSD().getPhanTramGiamGia() / 100;
        }
    }

    private ArrayList<HoaDonChiTietViewModel> getAllHoaDonCTByID(String id) {
        ArrayList<HoaDonChiTietViewModel> list = new ArrayList<>();
        for (HoaDonChiTietDomainModel x : HoaDonChiTietRepository.getAllByIDHoaDon(id)) {
            HoaDonChiTietViewModel hoaDonCTVM = new HoaDonChiTietViewModel(
                    x.getId(),
                    x.getHopThit().getMa(),
                    String.valueOf(tinhGiaHopThit(x)),
                    id);
            list.add(hoaDonCTVM);
        }
        return list;
    }

    private double getTongTien(String idHoaDon) {
        double tongTien = 0;
        for (HoaDonChiTietViewModel x : getAllHoaDonCTByID(idHoaDon)) {
            tongTien += Double.parseDouble(x.getGiaBan());
        }
        return tongTien;
    }

    public ArrayList<DoanhThuViewModel> getAllDoanhThuTheoThang(String year) {
        ArrayList<DoanhThuViewModel> list = new ArrayList<>();
        for(String x:this.getAllMonthsByYear(year)){
            TinhTien: for(HoaDonViewModel y:this.getAllHoaDonTheoThang(x, year)){
                for(DoanhThuViewModel z:list){
                    if(z.getDate().equals(y.getNgayThanhToan())){
                        z.setTotal(z.getTotal()+getTongTien(y.getId()));
                        z.setNumberOfHoaDon(z.getNumberOfHoaDon()+1);
                        continue TinhTien;
                    }
                }
                list.add(new DoanhThuViewModel(x,1,getTongTien(y.getId())));
            }
        }
        Comparator<DoanhThuViewModel> compare = new Comparator<DoanhThuViewModel>() {
            @Override
            public int compare(DoanhThuViewModel o1, DoanhThuViewModel o2) {
                if(Integer.parseInt(o1.getDate()) > Integer.parseInt(o2.getDate()))return 1;
                else return -1;
            }
        };
        Collections.sort(list, compare);
        return list;
    }

    private ArrayList<HoaDonViewModel> getAllHoaDonTheoThang(String month, String year) {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getTinhTrang().equals("Chưa thanh toán")) {
                continue;
            }
            sdf = new SimpleDateFormat("MM");
            String monthTTStr = sdf.format(x.getNgayThanhToan());
            if (monthTTStr.equals(month)) {
                sdf.applyPattern("yyyy");
String yearTTStr = sdf.format(x.getNgayThanhToan());
                if (yearTTStr.equals(year)) {
                    sdf.applyPattern("MM");
                    HoaDonViewModel hoaDonVM = new HoaDonViewModel();
                    hoaDonVM.setId(x.getId());
                    hoaDonVM.setNgayThanhToan(sdf.format(x.getNgayThanhToan()));
                    list.add(hoaDonVM);
                }
            }
        }
        return list;
    }

    private ArrayList<HoaDonViewModel> getAllHoaDonTheoNgay(String day, String month, String year) {
        ArrayList<HoaDonViewModel> list = new ArrayList<>();
        for (HoaDonDomainModel x : HoaDonRepository.getAll()) {
            if (x.getTinhTrang().equals("Chưa thanh toán")) {
                continue;
            }
            sdf = new SimpleDateFormat("MM");
            String monthTTStr = sdf.format(x.getNgayThanhToan());
            if (monthTTStr.equals(month)) {
                sdf.applyPattern("yyyy");
                String yearTTStr = sdf.format(x.getNgayThanhToan());
                if (yearTTStr.equals(year)) {
                    sdf.applyPattern("dd");
                    String dayTTStr = sdf.format(x.getNgayThanhToan());
                    if (dayTTStr.equals(day)) {
                        HoaDonViewModel hoaDonVM = new HoaDonViewModel();
                        hoaDonVM.setId(x.getId());
                        hoaDonVM.setNgayThanhToan(sdf.format(x.getNgayThanhToan()));
                        list.add(hoaDonVM);
                    }
                }
            }
        }
        return list;
    }
    public ArrayList<DoanhThuViewModel> getAllDoanhThuTheoNgay(String month, String year) {
        ArrayList<DoanhThuViewModel> list = new ArrayList<>();
       
        for(String x:getAllDaysByMonthAndYear(month, year)){
            TinhTien: for(HoaDonViewModel y: this.getAllHoaDonTheoNgay(x, month, year)){                
                for(DoanhThuViewModel z:list){
                    if(z.getDate().equals(y.getNgayThanhToan())){
                        z.setTotal(z.getTotal()+getTongTien(y.getId()));
                        z.setNumberOfHoaDon(z.getNumberOfHoaDon()+1);
                        continue TinhTien;
                    }
                }
                list.add(new DoanhThuViewModel(x,1,getTongTien(y.getId())));
            }
        }        
        Comparator<DoanhThuViewModel> compare = new Comparator<DoanhThuViewModel>() {
            @Override
            public int compare(DoanhThuViewModel o1, DoanhThuViewModel o2) {
                if(Integer.parseInt(o1.getDate()) > Integer.parseInt(o2.getDate()))return 1;
                else return -1;
            }
        };
        Collections.sort(list, compare);
        return list;
    }
}