/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOImplements.*;
import java.util.Arrays;
import model.*;
import view.MainView;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import kalkulator.Kalkulator;

/**
 *
 * @author msi-modern
 */
public class MainViewController {
        
    MainView v;
    JadwalShowDAOImpl js;

    public MainViewController(MainView v) {
        this.v = v;
    }

    public void isiDropdown() {
        JComboBox<String> dd = v.getMenuJadwal();
        js = new JadwalShowDAOImpl();
        List<JadwalShow> jw = js.getAll();
        
        String[] j_show = {};
        for(JadwalShow j : jw) {
            System.out.println(j.getTanggalShow());
            String nilai = j.getTanggalShow();
            j_show = Arrays.copyOf(j_show, j_show.length + 1);
            j_show[j_show.length-1] = nilai;
        }
        dd.setModel(new DefaultComboBoxModel<>(j_show));
    }
    
    public void isiKuota(int id) {
        JLabel sisaReguler = v.getSisaReguler();
        JLabel sisaVip = v.getSisaVip();
        JLabel fixReg = v.getSisaRegInv();
        JLabel fixVip = v.getSisaVipInv();
        JadwalShow j = getSingleData(id);
        sisaReguler.setText(Integer.toString(j.getKuotaReguler()));
        sisaVip.setText(Integer.toString(j.getKuotaVip()));
        fixReg.setText(Integer.toString(j.getKuotaReguler()));
        fixVip.setText(Integer.toString(j.getKuotaVip()));
    }
    
    public void ubahKuota(JLabel fix, JLabel sisa, JSpinner spin) {
        int sisaKursi = Integer.parseInt(fix.getText()) - Integer.parseInt(spin.getValue().toString());
        sisa.setText(Integer.toString(sisaKursi));
    }
    
    public void isiHarga(int id) {
        JLabel hargaReguler = v.getHargaReguler();
        JLabel regFix = v.getHargaReg();
        JLabel hargaVip = v.getHargaVip();
        JLabel vipFix = v.getHargaVipStatic();
        JadwalShow j = getSingleData(id);
        hargaReguler.setText("Rp" + Integer.toString(j.getHargaReguler()));
        regFix.setText(Integer.toString(j.getHargaReguler()));
        hargaVip.setText("Rp" + Integer.toString(j.getHargaVip()));
        vipFix.setText(Integer.toString(j.getHargaVip()));
    }
    
    public void updateBayar() {
        int qtyReg = Integer.parseInt(v.getSpinReguler().getValue().toString());
        int qtyVip = Integer.parseInt(v.getSpinVip().getValue().toString());
        int hargaReg = Integer.parseInt(v.getHargaReg().getText());
        int hargaVip = Integer.parseInt(v.getHargaVipStatic().getText());
        
        Kalkulator k = new Kalkulator();
        
        int jml = k.hitungJumlah(hargaReg, qtyReg) + k.hitungJumlah(hargaVip, qtyVip);
        double tax = k.hitungPajak(jml);
        double total = k.hitungTotal(jml);
        
        v.getTxtTotal().setText(Integer.toString(jml));        
        v.getTxtTax().setText(Integer.toString((int) tax));
        v.getTxtTot().setText(Integer.toString((int) total));
    }
    
    private JadwalShow getSingleData(int id) {
        js = new JadwalShowDAOImpl();
        List<JadwalShow> jw = js.getAll();
        JadwalShow j = jw.get(id);
        return j;
    }
}