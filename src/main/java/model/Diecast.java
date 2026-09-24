/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Diecast {
    protected String idKoleksi;
    protected String namaModel;
    protected int tahunRilis;

    public Diecast(String idKoleksi, String namaModel, int tahunRilis) {
        this.idKoleksi = idKoleksi;
        setNamaModel(namaModel); 
        setTahunRilis(tahunRilis);
    }

    public String getIdKoleksi() { return idKoleksi; }
    public void setIdKoleksi(String idKoleksi) { this.idKoleksi = idKoleksi; }

    public String getNamaModel() { return namaModel; }
    public void setNamaModel(String namaModel) {
        if (namaModel != null && !namaModel.trim().isEmpty()) {
            this.namaModel = namaModel;
        } else {
            this.namaModel = "Tanpa Nama";
        }
    }

    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) {
        if (tahunRilis >= 1950 && tahunRilis <= 2026) {
            this.tahunRilis = tahunRilis;
        } else {
            this.tahunRilis = 2026;
        }
    }
    public String getTipe() { return "Diecast Standar"; }
    public String getInfoEkstra() { return "-"; }
}
