package controller;

import entity.AdminEntity;
import model.AdminModel;

public class AdminController {
    AdminModel adminModel;

    public AdminController() {
        adminModel = new AdminModel();
    }


    public void addAdmin(String username, String password) {
        adminModel.dataAdmin(new AdminEntity(username, password));
    }
}


