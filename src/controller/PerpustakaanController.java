package controller;

import entity.AdminEntity;
import entity.BukuEntity;
import entity.PeminjamanEntity;
import model.PerpustakaanModel;

import java.util.ArrayList;

public class PerpustakaanController {

    PerpustakaanModel perpustakaanModel;

    public PerpustakaanController(){
        this.perpustakaanModel = new PerpustakaanModel();
    }
    public ArrayList<BukuEntity> allArrayBuku() {
        return null;
    }
    public BukuEntity cariBuku(String judul) {
        return perpustakaanModel.cariBuku(judul);
    }
    public void CariBuku (String judul){
        for (BukuEntity buku : allArrayBuku()){
            if (buku != null){
                System.out.println("Judul : "+buku.getJudul());
                System.out.println("Pengarang :"+buku.getPengarang());
                System.out.println("Penerbit :"+buku.getPenerbit());
                System.out.println("Rak :"+buku.getRak());
            }else{
                System.out.println("Buku Tidak DItemukan");
            }
        }
    }
    public void tambahBuku(BukuEntity buku){
        perpustakaanModel.tambahBuku(buku);
    }
    public void updateStokBuku(String judul, int stok) {
        perpustakaanModel.updateStokBuku(judul, stok);
    }
    public void hapusBuku(String judul){
        perpustakaanModel.hapusBuku(judul);
    }
    public void editBuku(String judul ,String newJudul, String pengarang, String penerbit, int jumlahHalaman, int stok, int harga, String rak) {
        BukuEntity buku = perpustakaanModel.cariBuku(judul);
        if (buku != null) {
            buku.setJudul(newJudul);
            buku.setPengarang(pengarang);
            buku.setPenerbit(penerbit);
            buku.setJumlahHalaman(jumlahHalaman);
            buku.setStok(stok);
            buku.setHarga(harga);
            buku.setRak(rak);
        }else {
            System.out.println("Buku Tidak Ada");
        }
    }
}
