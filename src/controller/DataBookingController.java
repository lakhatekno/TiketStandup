/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import model.*;
import DAOImplements.DataBookingDAOImpl;
import DAOImplements.JadwalShowDAOImpl;
import javax.swing.JTable;
import view.AdminJadwal;
/**
 *
 * @author msi-modern
 */
public class DataBookingController {
    AdminJadwal tabel;
    DataBookingDAOImpl dataImpl;
    JadwalShowDAOImpl js;
    List<DataBooking> d_b;
    
    public DataBookingController(AdminJadwal tabel) {
        this.tabel = tabel;
        dataImpl = new DataBookingDAOImpl();
        d_b = dataImpl.getAll();
    }
    
    public void isiTabel() {
        d_b = dataImpl.getAll();
        ModelTabelBooking mb = new ModelTabelBooking(d_b);
        tabel.getTabelBooking().setModel(mb);
    }
    
   public void delete() {
        JTable selected = tabel.getTabelBooking();
        js = new JadwalShowDAOImpl();
       int row = selected.getSelectedRow();
       String id = selected.getValueAt(row, 0).toString();
       dataImpl.delete(id);
       int idShow = Integer.parseInt(selected.getValueAt(row, 4).toString());
       int reg = Integer.parseInt(selected.getValueAt(row, 5).toString());
       int vip = Integer.parseInt(selected.getValueAt(row, 6).toString());
       js.update(idShow, reg, vip);
    }
}
