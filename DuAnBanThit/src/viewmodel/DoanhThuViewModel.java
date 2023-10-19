/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author vietv
 */
public class DoanhThuViewModel {
    private String date;
    private int numberOfHoaDon;
    private double total;

    public DoanhThuViewModel() {
    }

    public DoanhThuViewModel(String date, int numberOfHoaDon, double total) {
        this.date = date;
        this.numberOfHoaDon = numberOfHoaDon;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfHoaDon() {
        return numberOfHoaDon;
    }

    public void setNumberOfHoaDon(int numberOfHoaDon) {
        this.numberOfHoaDon = numberOfHoaDon;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
}
