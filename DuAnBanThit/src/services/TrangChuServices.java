/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import domainmodels.NhanVienDomainModel;
import repositories.NhanVienRepository;

/**
 *
 * @author vietv
 */
public class TrangChuServices {
    public String getTenNhanVien(String idNV){
        for(NhanVienDomainModel x:NhanVienRepository.getAll()){
            if(idNV.equals(x.getId())){
                return x.getHoTen();
            }
        }
        return null;
    }
}
