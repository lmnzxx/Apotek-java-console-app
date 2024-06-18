package apotek.controller;

public class Obat {
    private String kode, nama, kategori;
    private int stok, harga;

    public Obat(){};
    
    public Obat(String kode, String nama, String kategori, int harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public boolean beli(int jumlah){
        if(this.stok-jumlah>=0){
            this.stok -= jumlah;
            return true;
        } else {
            return false;
        }
    }
}
