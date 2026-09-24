/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ACER
 */
public class KoleksiView {
    public void cetakMenuUtama() {
        System.out.println("\n===== SISTEM MANAJEMEN KOLEKSI DIECAST =====");
        System.out.println("1. Tampilkan Semua Koleksi");
        System.out.println("2. Cari Data Koleksi");
        System.out.println("3. Tambah Koleksi (Hot Wheels)");
        System.out.println("4. Tambah Koleksi (Mini GT)");
        System.out.println("5. Update Data Dasar Koleksi");
        System.out.println("6. Hapus Koleksi");
        System.out.println("7. Keluar");
        System.out.print("Pilih menu (1-7): ");
    }

    public void cetakPesan(String pesan) {
        System.out.println(">> " + pesan);
    }

    public void cetakDetailKoleksi(int no, String id, String nama, int tahun, String tipe, String ekstra) {
        System.out.printf("%d. [%-10s] ID: %-6s | Model: %-20s | Tahun: %d | %s\n", 
                no, tipe, id, nama, tahun, ekstra);
    }
}
