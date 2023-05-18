/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;
import java.sql.SQLException;
import java.util.List;
import model.DataBooking;
/**
 *
 * @author msi-modern
 */
public interface DataBookingDAO extends DAO<DataBooking> {
    public void insert(DataBooking d_b);
    public void update(DataBooking d_b);
    public void delete(int id);
    List<DataBooking> getAll();
}
