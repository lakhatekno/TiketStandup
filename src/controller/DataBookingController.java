/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import model.*;
import view.TabelBooking;
import DAOImplements.DataBookingDAOImpl;
/**
 *
 * @author msi-modern
 */
public class DataBookingController {
    TabelBooking tabel;
    DataBookingDAOImpl dataImpl;
    List<DataBooking> d_b;
    
    public DataBookingController(TabelBooking tabel) {
        this.tabel = tabel;
        dataImpl = new DataBookingDAOImpl();
        d_b = dataImpl.getAll();
    }
    
    public void isiTabel() {
        d_b = dataImpl.getAll();
        ModelTabelBooking mb = new ModelTabelBooking(d_b);
        tabel.getTableBooking().setModel(mb);
    }
    
    public void insert() {
        DataBooking db = new DataBooking();
        db.setNama(tabel.getTxtNama().getText());
        db.setEmail(tabel.getTxtEmail().getText());
        db.setNoHp(tabel.getTxtNoHp().getText());
        db.setIdJadwalShow(Integer.parseInt(tabel.getTxtShow().getText()));
        db.setIdTipeKursi(Integer.parseInt(tabel.getTxtKursi().getText()));
        dataImpl.insert(db);
    }
}
