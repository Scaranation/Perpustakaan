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
        modelGSONBuku = new GsonModel<>("src/database/buku.json");
        loadData();
    }
    public void editBuku(){
        for (BukuEntity buku : allArrayBuku()) {

        }
    }

    public void editBuku(String judul ,String newJudul, String pengarang, String penerbit, int jumlahHalaman, int stok, int harga, String rak) {
        BukuEntity buku = cariBuku(judul);
        if (buku != null) {
            buku.setJudul(newJudul);
            buku.setPengarang(pengarang);
            buku.setPenerbit(penerbit);
            buku.setJumlahHalaman(jumlahHalaman);
            buku.setStok(stok);
            buku.setHarga(harga);
            buku.setRak(rak);
            commitData();
        }else {
            System.out.println("Buku Tidak Ada");
        }
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
                commitData();
            }
        }
    }
    public BukuEntity cariBuku(String judul) {
        loadData();
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

    public ArrayList<BukuEntity> allArrayBuku(){
        loadData();
        return arrayBuku;
    }}
