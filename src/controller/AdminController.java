package controller;

import entity.AdminEntity;
import model.AdminModel;

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


