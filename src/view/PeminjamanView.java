package view;

import controller.PerpustakaanController;
import entity.BukuEntity;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PeminjamanView {
    Scanner input = new Scanner(System.in);
    PerpustakaanController objPerpustakaan = new PerpustakaanController();

    public void peminjamanBuku() {
        try{
            System.out.println("Masukkan Nama Peminjam : ");
            String nama = input.nextLine();
            for (BukuEntity buku : objPerpustakaan.allArrayBuku()){
                if (buku != null){
                    System.out.println("Judul : "+buku.getJudul());
                    System.out.println("Stok : "+buku.getStok());
                    System.out.println("Harga : "+buku.getHarga());
                }
            }
            System.out.println("Masukkan Judul Buku Peminjaman: ");
            String judul = input.nextLine();
            if (objPerpustakaan.cariBuku(judul) != null){
                if (objPerpustakaan.cariBuku(judul).getStok() > 0){
                    objPerpustakaan.CariBuku(judul);
                    objPerpustakaan.updateStokBuku(judul, objPerpustakaan.cariBuku(judul).getStok()-1);
                    System.out.println("Detail Peminjaman");
                    System.out.println("Judul : "+objPerpustakaan.cariBuku(judul).getJudul());
                    System.out.println("Pengarang : "+objPerpustakaan.cariBuku(judul).getPengarang());
                    System.out.println("Penerbit : "+objPerpustakaan.cariBuku(judul).getPenerbit());
                    System.out.println("Jumlah Halaman : "+objPerpustakaan.cariBuku(judul).getJumlahHalaman());
                    System.out.println("Harga : "+objPerpustakaan.cariBuku(judul).getHarga());
                    System.out.println("Peminjaman Berhasil");
                }else{
                    System.out.println("Stok buku habis");
                }
            }else{
                System.out.println("Buku Tidak Ditemukan");
            }
        }catch (Exception e){
            input.nextLine();
        }
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
//            input.nextLine();
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
