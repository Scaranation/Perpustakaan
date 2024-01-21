package model;

import com.google.gson.reflect.TypeToken;
import entity.PeminjamanEntity;
import entity.PengunjungEntity;
import modelgson.GsonModel;
import view.PeminjamanView;

import java.util.ArrayList;

public class PeminjamanModel {
    ArrayList<PeminjamanEntity> arrayPeminjaman;
    GsonModel<PeminjamanEntity> modelGSONPeminjaman;
    public PeminjamanModel() {
        arrayPeminjaman = new ArrayList<>();
        modelGSONPeminjaman = new GsonModel<>("src/database/datapeminjaman.json");
        loadData();
    }
    public ArrayList<PeminjamanEntity> allArrayPeminjaman() {
        loadData();
        return arrayPeminjaman;
    }
    public void tambahPeminjaman(PeminjamanEntity peminjaman) {
        arrayPeminjaman.add(peminjaman);
        commitData();
    }

    public void viewDataPeminjam() {
        loadData();
        for (PeminjamanEntity peminjaman : arrayPeminjaman) {
            System.out.println(peminjaman);
        }
    }
    public void loadData() {
        arrayPeminjaman = modelGSONPeminjaman.readFromFile(new TypeToken<ArrayList<PeminjamanEntity>>(){}.getType());
    }
    public void commitData() {
        modelGSONPeminjaman.WriteToFile(arrayPeminjaman);
    }
}
