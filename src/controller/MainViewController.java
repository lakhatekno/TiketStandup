/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOImplements.*;
import model.*;
import view.MainView;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

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
                
//        dd.addItem("kontol");
        js = new JadwalShowDAOImpl();
        String[] items = js.getJadwal();
        dd.setModel(new DefaultComboBoxModel<>(items));
        System.out.println(items);
    }
}