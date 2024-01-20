package controller;

import com.google.gson.reflect.TypeToken;
import entity.AdminEntity;
import model.AdminModel;
import modelgson.GsonModel;
import view.Menu;

import java.util.ArrayList;

public class AdminController {
    AdminModel adminModel;
    Menu menu;

    public AdminController() {
        adminModel = new AdminModel();
        menu = new Menu();
    }


    public void addAdmin(String username, String password) {
        adminModel.dataAdmin(new AdminEntity(username, password));
    }
}


