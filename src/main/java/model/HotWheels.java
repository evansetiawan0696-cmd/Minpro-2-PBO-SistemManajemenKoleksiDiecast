/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class HotWheels extends Diecast {
    private boolean isTreasureHunt; 
    public HotWheels(String idKoleksi, String namaModel, int tahunRilis, boolean isTreasureHunt) {
        super(idKoleksi, namaModel, tahunRilis); 
        this.isTreasureHunt = isTreasureHunt;
    }

    public boolean getIsTreasureHunt() { return isTreasureHunt; }
    public void setIsTreasureHunt(boolean isTreasureHunt) { this.isTreasureHunt = isTreasureHunt; }

    @Override
    public String getTipe() { return "Hot Wheels"; }
    
    @Override
    public String getInfoEkstra() { 
        return "Treasure Hunt: " + (isTreasureHunt ? "Ya" : "Tidak"); 
    }
}
