package view;

import controller.PerpustakaanController;

import java.util.Scanner;

public class PengunjungView {
    Scanner input = new Scanner(System.in);
    PerpustakaanController objPerpustakaan = new PerpustakaanController();
    public void menuPengunjung(){
        String pilih;
        do {
            System.out.println("""
                    ====================================
                              Panel Pengunjung
                    ====================================
                    1. Cari Buku
                    2. Exit
                    ====================================
                    """);
            System.out.print("Pilih Menu : "); pilih = input.nextLine();
            switch (pilih){
                case "1" -> menuCari();
                case "2" -> System.out.println("Terima kasih");
                default -> System.out.println("Menu Tidak Ada");
            }
        }while (!pilih.equals("2"));
    }
    private void menuCari(){
        try{
            String pilih;
            do{
                System.out.println("""
                        ====================================
                                   Menu Cari Buku          
                        ====================================
                        1. Cari Buku Berdasarkan Judul
                        2. Cari Buku Berdasarkan Pengarang
                        3. Cari Buku Berdasarkan Penerbit
                        4. Exit
                        ====================================
                        """);
                System.out.print("Pilih Menu : "); pilih = input.nextLine();
                switch (pilih){
                    case "1" -> {
                        System.out.print("Masukkan Judul Buku : ");
                        String judul = input.nextLine();
                        objPerpustakaan.CariBuku(judul);
                    }
                    case "2" -> {
                        System.out.print("Masukkan Pengarang : ");
                        String pengarang = input.nextLine();
                        objPerpustakaan.CariBuku(pengarang);
                    }
                    case "3" -> {
                        System.out.print("Masukkan Penerbit : ");
                        String penerbit = input.nextLine();
                        objPerpustakaan.CariBuku(penerbit);
                    }
                    case "4" -> System.out.println("Terima kasih");
                    default -> System.out.println("Menu Tidak Ada");
                }
            }while (!pilih.equals("4"));
        }catch (Exception e){
            input.nextLine();
        }
    }
}

