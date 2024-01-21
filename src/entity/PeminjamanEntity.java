package entity;

import utils.DateString;

public class PeminjamanEntity {
    public PengunjungEntity pengunjungEntity;
    private BukuEntity bukuEntity;
    private String tglPinjam;
    private int lamaPeminjaman;
    private int totalHarga;
    public PeminjamanEntity(PengunjungEntity pengunjungEntity, BukuEntity bukuEntity,int lamaPeminjaman,int totalHarga) {
        this.pengunjungEntity = pengunjungEntity;
        this.bukuEntity = bukuEntity;
        this.tglPinjam = DateString.now();
        this.lamaPeminjaman = lamaPeminjaman;
        this.totalHarga = totalHarga;
    }
    public PengunjungEntity getPengunjungEntity() {
        return pengunjungEntity;
    }

    public void setPengunjungEntity(PengunjungEntity pengunjungEntity) {
        this.pengunjungEntity = pengunjungEntity;
    }

    public BukuEntity getBukuEntity() {
        return bukuEntity;
    }

    public void setBukuEntity(BukuEntity bukuEntity) {
        this.bukuEntity = bukuEntity;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public int getLamaPeminjaman() {
        return lamaPeminjaman;
    }

    public void setLamaPeminjaman(int lamaPeminjaman) {
        this.lamaPeminjaman = lamaPeminjaman;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}
