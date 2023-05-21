/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author msi-modern
 */
public class BookingConfirmation extends DataBooking {
    String tanggal, nama, email, noHp;
    int reg, vip, total, tax, gtot, id;
    
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getGtot() {
        return gtot;
    }

    public void setGtot(int gtot) {
        this.gtot = gtot;
    }
    
    
}
