package view;

import controller.PerpustakaanController;
import entity.BukuEntity;
import model.PerpustakaanModel;

import java.util.Scanner;

public class AdminView {
    Scanner input = new Scanner(System.in);
    PeminjamanView peminjamanView = new PeminjamanView();
    PerpustakaanController objPerpustakaan = new PerpustakaanController();
    PerpustakaanModel objPerpustakaanModel = new PerpustakaanModel();
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
            System.out.print("Pilih Menu : "); pilih = input.nextLine();
            switch (pilih){
                case "1" -> dataBuku();
                case "2" -> tambahBuku();
                case "3" -> hapusBuku();
                case "4" -> editBuku();
                case "5" -> peminjamanView.pinjamBukuView();
                case "6" -> System.out.println("Terima kasih");
                default -> System.out.println("Menu Tidak Ada");
            }
        }while (!pilih.equals("6"));
    }
    public void tambahBuku(){
        try {
            System.out.print("Masukkan ID Rak : ");
            String rak= input.nextLine();
            System.out.print("Masukkan Judul Buku : ");
            String judul = input.nextLine();
            System.out.print("Masukkan Pengarang : ");
            String pengarang = input.nextLine();
            System.out.print("Masukkan Penerbit : ");
            String penerbit = input.nextLine();
            System.out.print("Masukkan Jumlah Halaman :");
            int halaman = input.nextInt();
            System.out.print("Masukkan Stok Buku : ");
            int stok = input.nextInt();
            System.out.print("Masukkan Harga : ");
            int harga = input.nextInt();
            input.nextLine();
            objPerpustakaan.tambahBuku(new BukuEntity(judul,pengarang,penerbit,halaman,stok,harga,rak));
        }catch (Exception e){
            input.nextLine();
        }
    }
    public void dataBuku(){
        if (objPerpustakaanModel.allArrayBuku() != null){
            for (BukuEntity buku : objPerpustakaanModel.allArrayBuku()){
                System.out.println("============================");
                System.out.println("Rak :"+buku.getRak());
                System.out.println("Judul         : "+buku.getJudul());
                System.out.println("Pengarang     : "+buku.getPengarang());
                System.out.println("Penerbit      : "+buku.getPenerbit());
                System.out.println("Jumlah Halaman: "+buku.getJumlahHalaman());
                System.out.println("Stok Buku     : "+buku.getStok());
                System.out.println("Harga Buku    : "+buku.getHarga());
                System.out.println("\n============================");
            }
        }else {
            System.out.println("Buku Tidak Ada");
        }
    }
    public void hapusBuku(){
        try {
            if (objPerpustakaan.allArrayBuku().size() == 0){
                System.out.println("Buku Tidak Ada");
                return;
            }
            System.out.print("Masukkan judul Buku yang ingin dihapus : ");
            String judul = input.nextLine();
            objPerpustakaan.hapusBuku(judul);
            System.out.println();
        }catch (Exception e){
            input.nextLine();
        }
    }
    public void editBuku(){
        try {
            System.out.print("Masukkan judul Buku yang ingin diedit :");
            String judul = input.nextLine();
            if (objPerpustakaan.cariBuku(judul) == null){
                System.out.println("Buku Tidak Ada");
                return;
            }else {
                System.out.print("Masukkan Judul Baru : ");
                String judulBaru = input.nextLine();
                System.out.print("Masukkan Pengarang Baru : ");
                String pengarangBaru = input.nextLine();
                System.out.print("Masukkan Penerbit Baru : ");
                String penerbitBaru = input.nextLine();
                System.out.print("Masukkan Jumlah Halaman Baru : ");
                int jumlahHalamanBaru = input.nextInt();
                System.out.print("Masukkan Stok Baru : ");
                int stokBaru = input.nextInt();
                System.out.print("Masukkan Harga Baru : ");
                int hargaBaru = input.nextInt();
                input.nextLine();
                System.out.print("Masukkan Rak Baru : ");
                String rakBaru = input.nextLine();
                objPerpustakaanModel.editBuku(judul, judulBaru, pengarangBaru, penerbitBaru, jumlahHalamanBaru, stokBaru, hargaBaru, rakBaru);
            }
        }catch (Exception e){
            input.nextLine();
        }
    }
}
