# Minpro-2-PBO-SistemManajemenKoleksiDiecast

## Deskripsi Singkat Program
Program ini adalah aplikasi Java berbasis CLI (*Command Line Interface*) untuk mengelola koleksi diecast (mainan miniatur kendaraan). Pada versi Mini Project 2 ini, program dikembangkan lebih spesifik untuk mengelola merek **Hot Wheels** dan **Mini GT**. Dengan program ini, kita bisa menambah, melihat, mencari, mengubah, dan menghapus data diecast. Program ini juga telah ditingkatkan menggunakan struktur arsitektur **MVC**, pewarisan kelas (*Inheritance*), dan *Polymorphism*.


## Penjelasan Perubahan Struktur (Dari Minpro 1 ke Minpro 2)
Pada pengembangan dari Mini Project 1, terdapat saran yang beberapa saya terapkan pada perubahan struktur utama:
1. **Penghapusan Class Kategori:** Class `Kategori` pada program sebelumnya dihapus dan digantikan oleh penerapan **Inheritance** (Pewarisan), di mana jenis diecast langsung dibedakan menjadi subclass `HotWheels` dan `MiniGT`.
2. **Penerapan Dummy Data:** Program kini otomatis mengisi data awal (1 data Hot Wheels dan 1 data Mini GT) ke dalam `ArrayList` saat pertama kali dijalankan, sehingga fitur "Lihat Koleksi" bisa langsung diuji tanpa perlu menginput data terlebih dahulu.
3. **Pemisahan File (MVC):** Kode yang sebelumnya menumpuk di file `Main` kini dipisah rapi ke dalam 4 *package* berbeda (`main`, `model`, `view`, dan `controller`).

## Penjelasan Alur Program

<img width="337" height="162" alt="image" src="https://github.com/user-attachments/assets/66325a50-4a9a-412a-9ba8-e6a1e18ca00d" />


Saat program dijalankan, sistem akan otomatis memuat *dummy data* ke dalam memori. Kemudian, kamu akan melihat menu utama. Kamu tinggal pilih angka sesuai menu yang diinginkan lalu masukkan angka sesuai instruksi.

**1. Tampilkan Semua Koleksi**

<img width="682" height="83" alt="image" src="https://github.com/user-attachments/assets/3bf23f92-8753-450c-bc98-d501d4849ad3" />


Program akan menampilkan daftar tabel berisi semua diecast yang sudah kita tambahkan (lengkap dengan tipe dan atribut khususnya). Kalau belum ada data di `ArrayList`, program kasih tau lewat pesan bahwa rak koleksi kosong.

**2. Cari Data Koleksi**

<img width="649" height="109" alt="image" src="https://github.com/user-attachments/assets/7e2bfc86-c18e-4f75-8628-b2853e23aff9" />


Masukkan ID Koleksi atau kata kunci nama model diecast yang mau dicari. Sistem akan mencari kecocokan data di dalam `ArrayList` dan menampilkan data yang cocok. Kalau kata kunci tidak ketemu, program kasih tahu lewat pesan error.

**3. Tambah Koleksi (Hot Wheels) & 4. Tambah Koleksi (Mini GT)**

<img width="292" height="134" alt="image" src="https://github.com/user-attachments/assets/1983098b-02aa-48be-822f-c7b14c33f63b" />


Kita bisa memasukkan ID, Nama Model, dan Tahun Rilis. 
* Jika memilih Hot Wheels (Menu 3), program akan meminta input tambahan: apakah diecast tersebut tipe *Treasure Hunt* (true/false). 
* Jika memilih Mini GT (Menu 4), program akan meminta input tambahan: *Nomor Seri Box* (angka).
Setelah diisi, data otomatis disimpan ke dalam `ArrayList`.

**5. Update Data Dasar Koleksi**

<img width="690" height="161" alt="image" src="https://github.com/user-attachments/assets/0322f1af-35bd-4dde-81f5-8e34d60a8b0b" />


Sistem akan menampilkan daftar koleksi dulu. Lalu, masukkan ID diecast yang mau diubah. Setelah itu, masukkan data baru yang diinginkan (Nama Model dan Tahun Rilis baru). Data di `ArrayList` akan ter-update.

**6. Hapus Koleksi**

<img width="683" height="129" alt="image" src="https://github.com/user-attachments/assets/0c501c61-362f-4472-abd9-e85f5b93e837" />


Sistem akan menampilkan daftar koleksi. Masukkan ID diecast yang mau dihapus. Sistem akan menghapusnya dari `ArrayList`. Kalau ID tidak ketemu, program kasih tahu lewat pesan error.

**7. Keluar Program**

<img width="294" height="37" alt="image" src="https://github.com/user-attachments/assets/ee8ef150-4404-498f-9628-7ef77b55f2d5" />


Pilih angka 7 di menu utama, program akan berhenti dan bilang "Menyimpan data... Program selesai."


## Penjelasan Penerapan Encapsulation dan Inheritance

**A. Encapsulation (Pembungkusan Data):**
Semua atribut di dalam class `Diecast.java`, `HotWheels.java`, dan `MiniGT.java` diatur menggunakan *access modifier* `protected` dan `private` agar tidak bisa dimanipulasi sembarangan dari luar. Data hanya bisa dibaca dan diubah lewat method *Getter* dan *Setter*. Di dalam *Setter* juga diterapkan logika validasi (contoh: tahun rilis tidak boleh sembarang angka, dibatasi antara 1950 - 2026). Saat objek dibuat, *constructor* akan memanggil *setter* ini agar validasi langsung berjalan.

**B. Inheritance (Pewarisan):**
Program ini memiliki 1 Superclass dan 2 Subclass:
* **Superclass (`Diecast`):** Menyimpan atribut dasar yang pasti dimiliki semua diecast (ID Koleksi, Nama Model, Tahun Rilis).
* **Subclass (`HotWheels` & `MiniGT`):** Menggunakan keyword `extends Diecast` untuk mewarisi sifat induknya, lalu menambahkan atribut spesifik mereka sendiri (`isTreasureHunt` untuk Hot Wheels, dan `nomorSeriBox` untuk Mini GT). Di dalam *constructor* subclass, wajib memanggil `super()` untuk mengirim data ke kelas induk.


## Penjelasan Letak Penerapan Nilai Tambah

**A. Menerapkan Struktur MVC (Model-View-Controller)**

<img width="357" height="219" alt="image" src="https://github.com/user-attachments/assets/c2432563-f92a-404e-b647-1e479404a63f" />

Program ini memisahkan logika dan tampilan ke dalam struktur *packages* agar rapi dan standar:
* **`package main`:** Berisi `MainApp.java` yang hanya bertugas sebagai menjalankan aplikasi.
* **`package model`:** Berisi `Diecast.java`, `HotWheels.java`, dan `MiniGT.java`. package ini khusus menangani struktur data, aturan bisnis, dan validasi data (tanpa mempedulikan tampilan antarmuka).
* **`package view`:** Berisi `KoleksiView.java`. package ini murni bertugas mencetak menu, *layout*, dan pesan peringatan ke layar konsol (*System.out.println*).
* **`package controller`:** Berisi `KoleksiController.java`. Ini adalah wadah yang memegang `ArrayList`, memproses input dari pengguna, memperbarui data di `model`, dan menyuruh `view` untuk menampilkannya.

**B. Polymorphism**

<img width="610" height="141" alt="image" src="https://github.com/user-attachments/assets/99c2efc6-c442-4419-887d-f5b84c999abb" />


* **Method Overriding:** Diterapkan pada method `getTipe()` dan `getInfoEkstra()`. Method ini dideklarasikan bentuk standarnya di superclass `Diecast`, lalu ditimpa (`@Override`) di subclass `HotWheels` dan `MiniGT` agar saat datanya dicetak, masing-masing objek memunculkan tipe dan informasi tambahan yang berbeda-beda secara otomatis.
* **Polymorphic Collection:** `ArrayList` yang dibuat di dalam Controller menggunakan tipe induk `ArrayList<Diecast>`, tetapi wadah ini mampu menampung bermacam-macam bentuk objek turunannya (objek `HotWheels` dan objek `MiniGT`) secara fleksibel dalam satu *list* yang sama.
