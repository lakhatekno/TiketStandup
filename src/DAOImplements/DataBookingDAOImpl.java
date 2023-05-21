/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplements;
import DAOs.DataBookingDAO;
import java.sql.SQLException;
import java.util.List;
import model.DataBooking;
import koneksi.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import model.BookingConfirmation;

/**
 *
 * @author msi-modern
 */
public class DataBookingDAOImpl implements DataBookingDAO{
    Connection con;
    private static String select = "SELECT * FROM `booking_data`";
    private static String insert = "INSERT INTO `booking_data` (`id_booking_data`, `nama`, `no_hp`, `email`, `id_jadwal_show`, `kursi_reguler`, `kursi_vip`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public DataBookingDAOImpl() {
        con = Connector.connection();
    }

    @Override
    public void insert(DataBooking d_b) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.getDate());
            statement.setString(2, d_b.getNama());
            statement.setString(3, d_b.getNoHp());
            statement.setString(4, d_b.getEmail());
            statement.setInt(5,d_b.getIdJadwalShow());
            statement.setInt(6,d_b.getJmlReguler());
            statement.setInt(7, d_b.getJmlVip());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                d_b.setIdBookingData(rs.getString(1));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void insert(BookingConfirmation d_b) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.getDate());
            statement.setString(2, d_b.getNama());
            statement.setString(3, d_b.getNoHp());
            statement.setString(4, d_b.getEmail());
            statement.setInt(5,d_b.getIdJadwalShow());
            statement.setInt(6,d_b.getJmlReguler());
            statement.setInt(7, d_b.getJmlVip());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                d_b.setIdBookingData(rs.getString(1));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataBooking d_b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DataBooking> getAll() {
        List<DataBooking> d_b = null;
        try{
            d_b = new ArrayList<DataBooking>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataBooking db = new DataBooking();
                db.setIdBookingData(rs.getString("id_booking_data"));
                db.setNama(rs.getString("nama"));
                db.setEmail(rs.getString("email"));
                db.setNoHp(rs.getString("no_hp"));
                db.setIdJadwalShow(rs.getInt("id_jadwal_show"));
                db.setJmlReguler(rs.getInt("kursi_reguler"));
                db.setJmlVip(rs.getInt("kursi_vip"));
                d_b.add(db);
            }
        } catch(SQLException ex) {
            Logger.getLogger(DataBookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return d_b;
    }
    
    private String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date(); 
        return formatter.format(date);
    }
}
