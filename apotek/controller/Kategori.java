package apotek.controller;

public class Kategori {
    private String kode, kategori;

    public Kategori(){};
    
    public Kategori(String kode, String kategori) {
        this.kode = kode;
        this.kategori = kategori;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}