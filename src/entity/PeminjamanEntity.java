package entity;

import utils.DateString;

public class PeminjamanEntity {
    private PengunjungEntity pengunjungEntity;
    private BukuEntity bukuEntity;
    private String tglPinjam;
    private String lamaPeminjaman;
    private String tglKembali;

    public PeminjamanEntity(PengunjungEntity pengunjungEntity, BukuEntity bukuEntity, String lamaPeminjaman) {
        this.pengunjungEntity = pengunjungEntity;
        this.bukuEntity = bukuEntity;
        this.tglPinjam = DateString.now();
        this.lamaPeminjaman = lamaPeminjaman;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
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

    public String getLamaPeminjaman() {
        return lamaPeminjaman;
    }

    public void setLamaPeminjaman(String lamaPeminjaman) {
        this.lamaPeminjaman = lamaPeminjaman;
    }
    public int getTotalHarga() {
        return this.bukuEntity.getHarga() * Integer.parseInt(this.lamaPeminjaman);
    }
}
