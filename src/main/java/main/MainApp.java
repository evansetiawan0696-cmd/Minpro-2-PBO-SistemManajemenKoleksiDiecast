/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ACER
 */
import controller.KoleksiController;
import view.KoleksiView;

public class MainApp {
    public static void main(String[] args) {
        KoleksiView view = new KoleksiView();
        KoleksiController controller = new KoleksiController(view);
        
        // Memulai alur program
        controller.mulaiAplikasi();
    }
}