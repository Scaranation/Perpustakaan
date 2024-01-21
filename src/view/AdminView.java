package view;

import controller.PerpustakaanController;
import entity.BukuEntity;

import java.util.Scanner;

public class AdminView {
    Scanner input = new Scanner(System.in);
    PeminjamanView peminjamanView = new PeminjamanView();
    PerpustakaanController objPerpustakaan = new PerpustakaanController();
    public void menuAdmin(){
        String pilih;
        do {
            System.out.println("""
                    ====================================
                                 Panel Admin
                    ====================================
                    1. List Data Buku
                    2. Tambah Buku
                    3. Hapus Data Buku
                    4. Edit Data Buku
                    5. Peminjaman Buku
                    6. Exit
                    ====================================
                    """);
            System.out.println("Pilih Menu : "); pilih = input.nextLine();
            switch (pilih){
                case "1" -> dataBuku();
                case "2" -> tambahBuku();
                case "3" -> hapusBuku();
                case "4" -> editBuku();
                case "5" -> peminjamanView.peminjamanBuku();
                case "6" -> System.out.println("Terima kasih");
                default -> System.out.println("Menu Tidak Ada");
            }
        }while (!pilih.equals("6"));
    }
    public void tambahBuku(){
        try {
            input.nextLine();
            System.out.println("Masukkan ID Rak : ");
            String rak= input.nextLine();
            System.out.println("Masukkan Judul Buku : ");
            String judul = input.nextLine();
            System.out.println("Masukkan Pengarang : ");
            String pengarang = input.nextLine();
            System.out.println("Masukkan Penerbit : ");
            String penerbit = input.nextLine();
            System.out.println("Masukkan Jumlah Halaman :");
            int halaman = input.nextInt();
            System.out.println("Masukkan Stok Buku : ");
            int stok = input.nextInt();
            System.out.println("Masukkan Harga : ");
            int harga = input.nextInt();
            objPerpustakaan.tambahBuku(new BukuEntity(judul,pengarang,penerbit,halaman,stok,harga));
        }catch (Exception e){
            input.nextLine();
        }
    }
    public void dataBuku(){
        for (BukuEntity buku : objPerpustakaan.allArrayBuku()){
            if (buku != null){
                System.out.println("Judul : "+buku.getJudul());
                System.out.println("Pengarang : "+buku.getPengarang());
                System.out.println("Penerbit : "+buku.getPenerbit());
                System.out.println("Jumlah Halaman: "+buku.getJumlahHalaman());
                System.out.println("Stok :"+buku.getStok());
                System.out.println("Harga :"+buku.getHarga());
                System.out.println("Rak :"+buku.getRak());
            }else {
                System.out.println("Buku Tidak Ada");
            }
        }
    }
    public void hapusBuku(){
        try {
            System.out.println("Masukkan Judul Buku : ");
            String judul = input.nextLine();
            objPerpustakaan.hapusBuku(judul);
        }catch (Exception e){
            input.nextLine();
        }
    }
    public void editBuku(){
        try {
            System.out.println("Masukkan Judul Buku yg ingin diedit :");
            String judul = input.nextLine();
            if (objPerpustakaan.cariBuku(judul) == null){
                System.out.println("Buku Tidak Ada");
                return;
            }else {
                System.out.println("Masukkan Judul Baru :");
                String judulBaru = input.nextLine();
                System.out.println("Masukkan Pengarang Baru :");
                String pengarangBaru = input.nextLine();
                System.out.println("Masukkan Penerbit Baru :");
                String penerbitBaru = input.nextLine();
                System.out.println("Masukkan Jumlah Halaman Baru :");
                int jumlahHalamanBaru = input.nextInt();
                System.out.println("Masukkan Stok Baru :");
                int stokBaru = input.nextInt();
                System.out.println("Masukkan Harga Baru :");
                int hargaBaru = input.nextInt();
                input.nextLine();
                System.out.println("Masukkan Rak Baru :");
                String rakBaru = input.nextLine();
                objPerpustakaan.editBuku(judul, judulBaru, pengarangBaru, penerbitBaru, jumlahHalamanBaru, stokBaru, hargaBaru, rakBaru);
            }
        }catch (Exception e){
            input.nextLine();
        }
    }
}
