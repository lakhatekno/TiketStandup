/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author msi-modern
 */
public class ModelAdminJadwal extends AbstractTableModel {
    List<JadwalShow> j_s;

    public ModelAdminJadwal(List<JadwalShow>j_s) {
        this.j_s = j_s;
    }
    
    @Override
    public int getRowCount() {
        return j_s.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "id_jadwal_show";
            case 1:
                return "tanggal_show";
            case 2:
                return "lokasi";
            case 3:
                return "kuota_reguler";
            case 4:
                return "kuota_vip";
            case 5:
                return "harga_reguler";
            case 6:
                return "harga_vip";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return j_s.get(row).getIdJadwalShow();
            case 1:
                return j_s.get(row).getTanggalShow();
            case 2:
                return j_s.get(row).getLokasi();
            case 3:
                return j_s.get(row).getKuotaReguler();
            case 4:
                return j_s.get(row).getKuotaVip();
            case 5:
                return j_s.get(row).getHargaReguler();
            case 6:
                return j_s.get(row).getHargaVip();
            default:
                return null;
        }
    }
    
}
