/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;
import java.sql.SQLException;
import java.util.List;
import model.JadwalShow;
/**
 *
 * @author msi-modern
 */
public interface JadwalShowDAO extends DAO<JadwalShow> {
    public void insert(JadwalShow js);
    public void update(JadwalShow js);
    public void delete(int id);
    List<JadwalShow> getAll();
}
