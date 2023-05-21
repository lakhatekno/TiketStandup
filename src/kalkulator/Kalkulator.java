/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkulator;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import view.MainView;
/**
 *
 * @author msi-modern
 */
public class Kalkulator {

    public int hitungJumlah(int harga, int qty) {
        return harga*qty;
    }
    
    public double hitungPajak(int jumlah) {
        return 0.11*jumlah;
    }
    
    public double hitungTotal(int jumlah) {
        return 1.11*jumlah;
    }
}
