package model;

import com.google.gson.reflect.TypeToken;
import entity.AdminEntity;
import modelgson.GsonModel;

import java.util.ArrayList;

public class AdminModel {
    private ArrayList<AdminEntity> arrayAdmin;
    private GsonModel<AdminEntity> modelGSONAdmin;
    private ArrayList<AdminEntity> listAdmin;
    public AdminModel() {
        arrayAdmin = new ArrayList<>();
        modelGSONAdmin = new GsonModel<>("src/database/admin.json");
        loadData();
    }
    public  void dataAdmin(AdminEntity adminEntity){
        arrayAdmin.add(adminEntity);
        commitData();
    }
    private void loadData(){
        arrayAdmin = modelGSONAdmin.readFromFile(new TypeToken<ArrayList<AdminEntity>>()
        {}.getType());
    }

    public void commitData(){
        modelGSONAdmin.WriteToFile(arrayAdmin);
    }
}
