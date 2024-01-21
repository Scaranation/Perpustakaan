package controller;
import entity.PeminjamanEntity;
import entity.PengunjungEntity;
import model.PeminjamanModel;

import java.util.ArrayList;

public class PeminjamanController {
    private PeminjamanModel peminjamanModel;


    public PeminjamanController() {
        this.peminjamanModel = new PeminjamanModel();
    }

    public void tambahPeminjaman(PeminjamanEntity peminjaman) {
        peminjamanModel.tambahPeminjaman(peminjaman);
    }
}
