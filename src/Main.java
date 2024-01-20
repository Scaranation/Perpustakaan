import controller.AdminController;
import controller.LoginController;
import model.AdminModel;
import model.PerpustakaanModel;
import view.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AdminController adminController = new AdminController();
        Menu menu = new Menu();
        String pilih;
        do{
            System.out.println("""
                    ====================================
                       Selamat Datang di Perpustakaan   
                    ====================================
                                                        
                       1. Login Admin                     
                       2. Menu Pengunjung                
                       3. Exit                            
                                                        
                    ====================================
                    """);
            System.out.print("Pilih Menu : "); pilih = input.nextLine();
            switch (pilih){
                case "1" -> {
                    System.out.println("Masukkan Username :");
                    String username = input.nextLine();
                    System.out.println("Masukkan Password :");
                    String password = input.nextLine();
                    LoginController.loginAdmin(username, password);
                }
                case "2" -> menu.menuPengunjung();
                case "3" -> System.out.println("Terima kasih");
                default -> System.out.println("Menu Tidak Ada");
            }
        }while (!pilih.equals("3"));
    }
}
