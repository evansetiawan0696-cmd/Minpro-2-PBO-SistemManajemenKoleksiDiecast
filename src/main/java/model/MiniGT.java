/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class MiniGT extends Diecast {
    private int nomorSeriBox;

    public MiniGT(String idKoleksi, String namaModel, int tahunRilis, int nomorSeriBox) {
        super(idKoleksi, namaModel, tahunRilis);
        setNomorSeriBox(nomorSeriBox);
    }

    public int getNomorSeriBox() { return nomorSeriBox; }
    public void setNomorSeriBox(int nomorSeriBox) {
        this.nomorSeriBox = (nomorSeriBox > 0) ? nomorSeriBox : 1;
    }
    @Override
    public String getTipe() { return "Mini GT"; }
    
    @Override
    public String getInfoEkstra() { 
        return "No Seri Box: #" + nomorSeriBox; 
    }
}
