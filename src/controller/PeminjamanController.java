package controller;
import entity.BukuEntity;
import entity.Orang;
import entity.PeminjamanEntity;
import entity.PengunjungEntity;
import model.PeminjamanModel;
import model.PerpustakaanModel;

import java.util.ArrayList;

public class PeminjamanController {
    private PeminjamanModel peminjamanModel;


    public PeminjamanController() {
        this.peminjamanModel = new PeminjamanModel();
    }

    public void tambahPeminjaman(PeminjamanEntity peminjaman) {
        peminjamanModel.tambahPeminjaman(peminjaman);
        peminjamanModel.commitData();
    }
    public void viewDataPeminjam(String peminjam) {
        peminjamanModel.viewDataPeminjam();
        for (PeminjamanEntity peminjaman : peminjamanModel.allArrayPeminjaman()) {
            if (peminjaman.getPengunjungEntity().equals(peminjam)) {
                System.out.println(peminjaman);
            }
        }
    }

    public int totalHarga(String jdl,int jml){
        int total;
        PerpustakaanModel perpustakaanModel = new PerpustakaanModel();
        BukuEntity buku = perpustakaanModel.cariBuku(jdl);

        return buku.getHarga() * jml;
    }

    public ArrayList<PeminjamanEntity> allArrayPeminjaman() {
        return peminjamanModel.allArrayPeminjaman();
    }

}
