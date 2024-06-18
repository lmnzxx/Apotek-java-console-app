package apotek.controller;

import java.util.Date;
import java.util.HashMap;

public class Pembelian {
    private int idPembelian;
    private Customer pembeli;
    private Apoteker apotekerPembelian;
    private Date tanggalPembelian;
    private double totalHarga;
    private HashMap<Obat, Integer> daftarObat; 
    private static int idCounter = 1;

    public Pembelian(Customer pembeli, Apoteker apotekerPembelian) {
        this.idPembelian = idCounter++;
        this.pembeli = pembeli;
        this.apotekerPembelian = apotekerPembelian;
        this.tanggalPembelian = new Date();
        this.totalHarga = 0.0;
        this.daftarObat = new HashMap<>();
    }

    public int getIdPembelian() {
        return idPembelian;
    }

    public Customer getPembeli() {
        return pembeli;
    }

    public Apoteker getApotekerPembelian() {
        return apotekerPembelian;
    }

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void tambahObat(Obat obat, int jumlah) {
        if (daftarObat.containsKey(obat)) {
            daftarObat.put(obat, daftarObat.get(obat) + jumlah);
        } else {
            daftarObat.put(obat, jumlah);
        }
        totalHarga += obat.getHarga() * jumlah;
    }

    public HashMap<Obat, Integer> getDaftarObat() {
        return daftarObat;
    }
}
