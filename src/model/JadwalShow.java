/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author msi-modern
 */
public class JadwalShow {
    private String tanggalShow, lokasi;
    private int idJadwalShow, kuotaReguler, kuotaVip, hargaReguler, hargaVip;

    public String getTanggalShow() {
        return tanggalShow;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setTanggalShow(String tanggalShow) {
        this.tanggalShow = tanggalShow;
    }

    public int getIdJadwalShow() {
        return idJadwalShow;
    }

    public void setIdJadwalShow() {
        this.idJadwalShow = idJadwalShow;
    }
    
    public void setIdJadwalShow(int idJadwalShow) {
        this.idJadwalShow = idJadwalShow;
    }

    public int getKuotaReguler() {
        return kuotaReguler;
    }

    public void setKuotaReguler(int kuotaReguler) {
        this.kuotaReguler = kuotaReguler;
    }

    public int getKuotaVip() {
        return kuotaVip;
    }

    public void setKuotaVip(int kuotaVip) {
        this.kuotaVip = kuotaVip;
    }

    public int getHargaReguler() {
        return hargaReguler;
    }

    public void setHargaReguler(int hargaReguler) {
        this.hargaReguler = hargaReguler;
    }

    public int getHargaVip() {
        return hargaVip;
    }

    public void setHargaVip(int hargaVip) {
        this.hargaVip = hargaVip;
    }


}
