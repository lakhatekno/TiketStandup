/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.ConfirmWindow;
import model.BookingConfirmation;
/**
 *
 * @author msi-modern
 */
public class ConfirmWindowController {
    String tanggal, nama, email, noHp;
    int reg, vip, total, tax, gtot;
    BookingConfirmation bc = new BookingConfirmation();
    ConfirmWindow cf;

    public ConfirmWindowController(BookingConfirmation bc, ConfirmWindow cf) {
        this.cf = cf;
        this.bc = bc;
        this.tanggal = bc.getTanggal();
        this.nama = bc.getNama();
        this.email = bc.getEmail();
        this.noHp = bc.getNoHp();
        this.reg = bc.getJmlReguler();
        this.vip = bc.getJmlVip();
        this.total = bc.getTotal();
        this.tax = bc.getTax();
        this.gtot = bc.getGtot();
    }
    
    public void isiData() {
        nama = bc.getNama();
        email = bc.getEmail();
        noHp = bc.getNoHp();
        tanggal = bc.getTanggal();
        reg = bc.getJmlReguler();
        vip = bc.getJmlVip();
        total = bc.getTotal();
        tax = bc.getTax();
        gtot = bc.getGtot();
        System.out.println(tax);
        cf.getCfNama().setText(nama);
        cf.getCfEmail().setText(email);
        cf.getCfNoHp().setText(noHp);
        cf.getCfShow().setText(tanggal);
        cf.getCfReg().setText(Integer.toString(reg));
        cf.getCfVip().setText(Integer.toString(vip));
        cf.getCfTotal().setText(Integer.toString(total));
        cf.getCfTax().setText(Integer.toString(tax));
        cf.getCfGTot().setText(Integer.toString(gtot));        
    }
}
