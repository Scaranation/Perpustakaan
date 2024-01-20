package controller;

import com.google.gson.reflect.TypeToken;
import entity.AdminEntity;
import model.AdminModel;
import modelgson.GsonModel;

import java.util.ArrayList;

public class LoginController {
    private AdminModel adminModel;
    public LoginController() {
        adminModel = new AdminModel();
    }
    public static void loginAdmin(String username, String password) {
        ArrayList<AdminEntity> listAdmin = new GsonModel<AdminEntity>("database/admin.json").readFromFile(new TypeToken<ArrayList<AdminEntity>>(){}.getType());
        if (listAdmin != null) {
            for (AdminEntity admin : listAdmin) {
                if (admin.getUsername().equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)) {
                    return;
                }
            }
        }
        System.out.println("Login Gagal");
    }
}