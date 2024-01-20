package model;

import com.google.gson.reflect.TypeToken;
import entity.PeminjamanEntity;
import modelgson.GsonModel;

import java.util.ArrayList;

public class PeminjamanModel {
    ArrayList<PeminjamanEntity> arrayPeminjaman;
    GsonModel<PeminjamanEntity> modelGSONPeminjaman;
    public PeminjamanModel() {
        arrayPeminjaman = new ArrayList<>();
        modelGSONPeminjaman = new GsonModel<>("src//database//peminjaman.json");
        loadData();
    }

    public ArrayList<PeminjamanEntity> allArrayPeminjaman() {
        return arrayPeminjaman;
    }
    public void tambahPeminjaman(PeminjamanEntity peminjaman) {
        arrayPeminjaman.add(peminjaman);
        commitData();
    }
    public void loadData() {
        arrayPeminjaman = modelGSONPeminjaman.readFromFile(new TypeToken<ArrayList<PeminjamanEntity>>(){}.getType());
    }
    public void commitData() {
        modelGSONPeminjaman.WriteToFile(arrayPeminjaman);
    }
}
