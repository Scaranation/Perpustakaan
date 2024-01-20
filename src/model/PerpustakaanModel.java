package model;

import com.google.gson.reflect.TypeToken;
import entity.AdminEntity;
import entity.BukuEntity;
import entity.PeminjamanEntity;
import modelgson.GsonModel;
import utils.DateString;

import java.util.ArrayList;

public class PerpustakaanModel {
    ArrayList<BukuEntity> arrayBuku;
    BukuEntity buku;
    GsonModel<BukuEntity> modelGSONBuku;
    public PerpustakaanModel() {
        arrayBuku = new ArrayList<BukuEntity>();
        modelGSONBuku = new GsonModel<>("src//database//buku.json");
        loadData();
    }

    public void tambahBuku(BukuEntity buku) {
        arrayBuku.add(buku);
        commitData();
    }
    public void updateStokBuku(String judul, int stok) {
        for (BukuEntity buku : arrayBuku) {
            if (buku.getJudul().equals(judul)) {
                buku.setStok(buku.getStok() -1);
                commitData();
            }
        }
    }
    public void hapusBuku(String judul){
        for (BukuEntity buku : arrayBuku) {
            if (buku.getJudul().equals(judul)) {
                arrayBuku.remove(buku);
            }
        }
    }
    public BukuEntity cariBuku(String judul) {
        for (BukuEntity buku : arrayBuku) {
            if (buku.getJudul().equals(judul)) {
                return buku;
            }
        }
        return null;
    }
    public void loadData(){
        arrayBuku = modelGSONBuku.readFromFile(new TypeToken<ArrayList<BukuEntity>>()
        {}.getType());
    }

    public void commitData(){
        modelGSONBuku.WriteToFile(arrayBuku);
    }
}
