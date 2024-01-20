package view;

import controller.AdminController;
import controller.PerpustakaanController;
import entity.BukuEntity;
import entity.PeminjamanEntity;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    PerpustakaanController perpustakaanController = new PerpustakaanController();
    AdminController adminController = new AdminController();
    PeminjamanView peminjamanView = new PeminjamanView();


//    public void menu(){
//        String pilih;
//        do{
//            System.out.println("""
//                    ====================================
//                    |   Selamat Datang di Perpustakaan   |
//                    ====================================
//                    |                                    |
//                    |   1. Login Admin                     |
//                    |   2. Menu Pengunjung                |
//                    |   3. Exit                            |
//                    |                                    |
//                    ====================================
//                    """);
//            System.out.print("Pilih Menu : "); pilih = input.nextLine();
//            switch (pilih){
//                case "1" -> {
//                    System.out.println("Masukkan Username :");
//                    String username = input.nextLine();
//                    System.out.println("Masukkan Password :");
//                    String password = input.nextLine();
//                    adminController.loginAdmin(username, password);
//                }
//                case "2" -> menuPengunjung();
//                case "3" -> System.out.println("Terima kasih");
//                default -> System.out.println("Menu Tidak Ada");
//            }
//        }while (!pilih.equals("3"));
//    }
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
                case "1" -> peminjamanView.dataBuku();
                case "2" -> peminjamanView.tambahBuku();
                case "3" -> peminjamanView.hapusBuku();
                case "4" -> peminjamanView.editBuku();
                case "5" -> peminjamanView.peminjamanBuku();
                case "6" -> System.out.println("Terima kasih");
                default -> System.out.println("Menu Tidak Ada");
            }
        }while (!pilih.equals("6"));
    }
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
                        System.out.println("Masukkan Judul Buku : ");
                        String judul = input.nextLine();
                        perpustakaanController.CariBuku(judul);
                    }
                    case "2" -> {
                        System.out.println("Masukkan Pengarang : ");
                        String pengarang = input.nextLine();
                        perpustakaanController.CariBuku(pengarang);
                    }
                    case "3" -> {
                        System.out.println("Masukkan Penerbit : ");
                        String penerbit = input.nextLine();
                        perpustakaanController.CariBuku(penerbit);
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
