package apotek.controller;

import java.util.UUID;

public class User {
    private String id, nama, alamat, email, hp;
    
    public User(String nama, String alamat, String email, String hp) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.hp = hp;
    }

    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHp() {
        return hp;
    }
    public void setHp(String hp) {
        this.hp = hp;
    }
}