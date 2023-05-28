/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplements;
import DAOs.JadwalShowDAO;
import java.sql.SQLException;
import java.util.List;
import model.JadwalShow;
import koneksi.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BookingConfirmation;

/**
 *
 * @author msi-modern
 */
public class JadwalShowDAOImpl implements JadwalShowDAO{
    Connection con;
    private static String select = "SELECT * FROM `jadwal_show`";
    private static String insert = "INSERT INTO jadwal_show (id_jadwal_show, tanggal_show, lokasi, kuota_reguler, kuota_vip, harga_reguler, harga_vip) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
   private static String update = "UPDATE jadwal_show SET tanggal_show=?, lokasi=?, kuota_reguler=?, kuota_vip=?, harga_reguler=?, harga_vip=? WHERE id_jadwal_show=?";
   private static String delete = "DELETE from jadwal_show WHERE id_jadwal_show=?";
    public JadwalShowDAOImpl() {
        con = Connector.connection();
    }

    @Override
    public void insert(JadwalShow j_s) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, j_s.getTanggalShow());
            statement.setString(2, j_s.getLokasi());
            statement.setInt(3, j_s.getKuotaReguler());
            statement.setInt(4, j_s.getKuotaVip());
            statement.setInt(5,j_s.getHargaReguler());
            statement.setInt(6,j_s.getHargaVip());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                j_s.setIdJadwalShow();
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
    public void update(JadwalShow j_s) {
       PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(update);
            statement.setString(1, j_s.getTanggalShow());
            statement.setString(2, j_s.getLokasi());
            statement.setInt(3, j_s.getKuotaReguler());
            statement.setInt(4, j_s.getKuotaVip());
            statement.setInt(5,j_s.getHargaReguler());
            statement.setInt(6,j_s.getHargaVip());
            statement.setInt(7,j_s.getIdJadwalShow());
            statement.executeUpdate();
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
    
    public void update (BookingConfirmation bc) {
        update = "UPDATE `jadwal_show` SET `kuota_reguler` = kuota_reguler-?, `kuota_vip` = kuota_vip-? WHERE `jadwal_show`.`id_jadwal_show` = ?";
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(update);
            statement.setInt(1, bc.getJmlReguler());
            statement.setInt(2, bc.getJmlVip());
            statement.setInt(3, bc.getIdJadwalShow());
            statement.executeUpdate();
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
    
    public void update (int id, int reg, int vip) {
        update = "UPDATE `jadwal_show` SET `kuota_reguler` = kuota_reguler+?, `kuota_vip` = kuota_vip+? WHERE `jadwal_show`.`id_jadwal_show` = ?";
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(update);
            statement.setInt(1, reg);
            statement.setInt(2, vip);
            statement.setInt(3, id);
            statement.executeUpdate();
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
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(delete);
            statement.setInt(1, id);
          
            statement.executeUpdate();
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
    public List<JadwalShow> getAll() {
        List<JadwalShow> j_s = null;
        try{
            j_s = new ArrayList<JadwalShow>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                JadwalShow js = new JadwalShow();
                js.setIdJadwalShow(rs.getInt("id_jadwal_show"));
                js.setTanggalShow(rs.getString("tanggal_show"));
                js.setLokasi(rs.getString("lokasi"));
                js.setKuotaReguler(rs.getInt("kuota_reguler"));
                js.setKuotaVip(rs.getInt("kuota_vip"));
                js.setHargaReguler(rs.getInt("harga_reguler"));
                js.setHargaVip(rs.getInt("harga_vip"));
                j_s.add(js);
            }
        } catch(SQLException ex) {
            Logger.getLogger(JadwalShowDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return j_s;
    }
    
    public String[] getJadwal() {
        String[] js = {};
        String arrNew[] = null;
    
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
//                int id = rs.getInt("id_jadwal_show");
                String nilai = rs.getString("tanggal_show");
                arrNew = Arrays.copyOf(js, js.length + 1);
                arrNew[js.length]= nilai;
            }
            } catch(SQLException ex) {
                Logger.getLogger(JadwalShowDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return arrNew;
        }
    }