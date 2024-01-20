package controller;
import entity.PeminjamanEntity;
import model.PeminjamanModel;
public class PeminjamanController {
    private PeminjamanModel peminjamanModel;
    public PeminjamanController() {
        this.peminjamanModel = new PeminjamanModel();
    }

    public void tambahPeminjaman(PeminjamanEntity peminjaman) {
        peminjamanModel.tambahPeminjaman(peminjaman);
    }
}
