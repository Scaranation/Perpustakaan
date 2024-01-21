package entity;

public class PengunjungEntity extends Orang {
    private String nama;
    private String alamat;

    public PengunjungEntity(String id, String nama, String alamat) {
        super(nama, id);
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getUsername() {
        return nama;
    }

    public void setUsername(String username) {
        this.nama = username;
    }

}
