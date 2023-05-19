/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import model.*;
import view.AdminJadwal;
import DAOImplements.JadwalShowDAOImpl;
/**
 *
 * @author msi-modern
 */
public class JadwalShowController {
    AdminJadwal jadwal;
    JadwalShowDAOImpl dataImpl;
    List<JadwalShow> j_s;
    
    public JadwalShowController(AdminJadwal jadwal) {
        this.jadwal = jadwal;
        dataImpl = new JadwalShowDAOImpl();
        j_s = dataImpl.getAll();
    }
    
    public void isiTabel() {
        j_s = dataImpl.getAll();
        ModelAdminJadwal mb = new ModelAdminJadwal(j_s);
        jadwal.getTableJadwal().setModel(mb);
    }
    
    public void insert() {
        JadwalShow js = new JadwalShow();
        js.setTanggalShow(jadwal.getAdminTanggal().getText());
        js.setLokasi(jadwal.getAdminLokasi().getText());
        js.setKuotaReguler(Integer.parseInt(jadwal.getAdminKuotaReg().getText()));
        js.setKuotaVip(Integer.parseInt(jadwal.getAdminKuotaVip().getText()));
       js.setHargaReguler(Integer.parseInt(jadwal.getAdminHargaReg().getText()));
       js.setHargaVip(Integer.parseInt(jadwal.getAdminHargaVip().getText()));
        dataImpl.insert(js);
    }
}
