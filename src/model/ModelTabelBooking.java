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
public class ModelTabelBooking extends AbstractTableModel {
    List<DataBooking> d_b;

    public ModelTabelBooking(List<DataBooking>d_b) {
        this.d_b = d_b;
    }
    
    @Override
    public int getRowCount() {
        return d_b.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "id_booking_data";
            case 1:
                return "nama";
            case 2:
                return "no_hp";
            case 3:
                return "email";
            case 4:
                return "id_jadwal_show";
            case 5:
                return "kursi_reguler";
            case 6:
                return "kursi_vip";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return d_b.get(row).getIdBookingData();
            case 1:
                return d_b.get(row).getNama();
            case 2:
                return d_b.get(row).getNoHp();
            case 3:
                return d_b.get(row).getEmail();
            case 4:
                return d_b.get(row).getIdJadwalShow();
            case 5:
                return d_b.get(row).getJmlReguler();
            case 6:
                return d_b.get(row).getJmlVip();
            default:
                return null;
        }
    }
    
}
