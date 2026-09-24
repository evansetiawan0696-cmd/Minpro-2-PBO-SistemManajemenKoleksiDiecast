/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Diecast;
import model.HotWheels;
import model.MiniGT;
import view.KoleksiView;


public class KoleksiController {
    private ArrayList<Diecast> daftarKoleksi;
    private KoleksiView view;
    private Scanner input;

    public KoleksiController(KoleksiView view) {
        this.daftarKoleksi = new ArrayList<>();
        this.view = view;
        this.input = new Scanner(System.in);
        
        // Dummy data awal
        daftarKoleksi.add(new HotWheels("HW-01", "Nissan Skyline R34", 2023, true));
        daftarKoleksi.add(new MiniGT("MG-01", "Porsche 911 GT3 RS", 2024, 601));
    }

    public void mulaiAplikasi() {
        boolean berjalan = true;
        while (berjalan) {
            view.cetakMenuUtama();
            int pilihan = validasiAngka();

            switch (pilihan) {
                case 1:
                    tampilkanSemua();
                    break;
                case 2:
                    cariKoleksi();
                    break;
                case 3:
                    tambahHotWheels();
                    break;
                case 4:
                    tambahMiniGT();
                    break;
                case 5:
                    updateKoleksi();
                    break;
                case 6:
                    hapusKoleksi();
                    break;
                case 7:
                    berjalan = false;
                    view.cetakPesan("Menyimpan data... Program selesai.");
                    break;
                default:
                    view.cetakPesan("Pilihan tidak valid!");
            }
        }
    }

    private void tampilkanSemua() {
        view.cetakPesan("DAFTAR KOLEKSI SAAT INI:");
        if (daftarKoleksi.isEmpty()) {
            view.cetakPesan("Rak koleksi kosong.");
        } else {
            for (int i = 0; i < daftarKoleksi.size(); i++) {
                Diecast d = daftarKoleksi.get(i);
                view.cetakDetailKoleksi((i + 1), d.getIdKoleksi(), d.getNamaModel(), d.getTahunRilis(), d.getTipe(), d.getInfoEkstra());
            }
        }
    }

    private void cariKoleksi() {
        if (daftarKoleksi.isEmpty()) {
            view.cetakPesan("Rak koleksi kosong, tidak ada data untuk dicari.");
            return;
        }

        view.cetakPesan("CARIKAN DATA KOLEKSI");
        System.out.print("Masukkan ID atau Kata Kunci Nama Model: ");
        String keyword = input.nextLine().toLowerCase();

        boolean ditemukan = false;
        int nomor = 1;

        for (Diecast d : daftarKoleksi) {
            if (d.getIdKoleksi().toLowerCase().contains(keyword) || 
                d.getNamaModel().toLowerCase().contains(keyword)) {
                
                if (!ditemukan) {
                    view.cetakPesan("HASIL PENCARIAN:");
                    ditemukan = true;
                }
                view.cetakDetailKoleksi(nomor++, d.getIdKoleksi(), d.getNamaModel(), d.getTahunRilis(), d.getTipe(), d.getInfoEkstra());
            }
        }

        if (!ditemukan) {
            view.cetakPesan("Data koleksi dengan kata kunci '" + keyword + "' tidak ditemukan.");
        }
    }

    private void tambahHotWheels() {
        view.cetakPesan("TAMBAH DATA HOT WHEELS");
        System.out.print("ID: "); String id = input.nextLine();
        System.out.print("Model: "); String nama = input.nextLine();
        System.out.print("Tahun: "); int tahun = validasiAngka();
        System.out.print("Treasure Hunt? (true/false): "); boolean isTh = validasiBoolean();
        
        daftarKoleksi.add(new HotWheels(id, nama, tahun, isTh));
        view.cetakPesan("Hot Wheels berhasil ditambah!");
    }

    private void tambahMiniGT() {
        view.cetakPesan("TAMBAH DATA MINI GT");
        System.out.print("ID: "); String id = input.nextLine();
        System.out.print("Model: "); String nama = input.nextLine();
        System.out.print("Tahun: "); int tahun = validasiAngka();
        System.out.print("Nomor Box: "); int noBox = validasiAngka();
        
        daftarKoleksi.add(new MiniGT(id, nama, tahun, noBox));
        view.cetakPesan("Mini GT berhasil ditambah!");
    }

    private void updateKoleksi() {
        tampilkanSemua();
        if (daftarKoleksi.isEmpty()) return;
        
        System.out.print("Masukkan ID yang akan di-update: ");
        String idCari = input.nextLine();
        
        for (Diecast d : daftarKoleksi) {
            if (d.getIdKoleksi().equalsIgnoreCase(idCari)) {
                System.out.print("Nama Model Baru: "); d.setNamaModel(input.nextLine());
                System.out.print("Tahun Rilis Baru: "); d.setTahunRilis(validasiAngka());
                view.cetakPesan("Data berhasil diperbarui!");
                return;
            }
        }
        view.cetakPesan("ID Koleksi tidak ditemukan.");
    }

    private void hapusKoleksi() {
        tampilkanSemua();
        if (daftarKoleksi.isEmpty()) return;
        
        System.out.print("Masukkan ID yang akan dihapus: ");
        String idHapus = input.nextLine();
        
        for (int i = 0; i < daftarKoleksi.size(); i++) {
            if (daftarKoleksi.get(i).getIdKoleksi().equalsIgnoreCase(idHapus)) {
                daftarKoleksi.remove(i);
                view.cetakPesan("Koleksi berhasil dihapus!");
                return;
            }
        }
        view.cetakPesan("ID Koleksi tidak ditemukan.");
    }

    private int validasiAngka() {
        while (true) {
            try {
                int angka = input.nextInt(); 
                input.nextLine();
                return angka;
            } catch (InputMismatchException e) {
                view.cetakPesan("Input wajib angka! Silakan coba lagi: "); 
                input.nextLine();
            }
        }
    }
    
    private boolean validasiBoolean() {
        while (true) {
            String teks = input.nextLine().toLowerCase();
            if (teks.equals("true")) return true;
            if (teks.equals("false")) return false;
            view.cetakPesan("Ketik 'true' atau 'false'! Coba lagi: ");
        }
    }
}
