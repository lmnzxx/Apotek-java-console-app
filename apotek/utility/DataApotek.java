package apotek.utility;

import java.util.ArrayList;

import apotek.controller.*;

public class DataApotek {
    private ArrayList<Kategori> dataKategori = new ArrayList<>();
    private ArrayList<Apoteker> dataApoteker = new ArrayList<>();
    private ArrayList<Obat> dataObat = new ArrayList<>();
    private ArrayList<Customer> dataCustomer = new ArrayList<>();
    
    public ArrayList<Kategori> initKategori(){
        Kategori tempKategori = new Kategori();
        tempKategori.setKode("KAT01");
        tempKategori.setKategori("Obat Keras");
        dataKategori.add(tempKategori);

        tempKategori = new Kategori();
        tempKategori.setKode("KAT02");
        tempKategori.setKategori("Obat Bebas");
        dataKategori.add(tempKategori);

        tempKategori = new Kategori();
        tempKategori.setKode("KAT03");
        tempKategori.setKategori("Obat Sakit Hati");
        dataKategori.add(tempKategori);

        return dataKategori;
    }

    public String getNamaKategori(String kodeKategori) {
        for (Kategori kategori : dataKategori) {
            if (kategori.getKode().equals(kodeKategori)) {
                return kategori.getKategori();
            }
        }
        return "Kategori tidak ditemukan";
    }

    public ArrayList<Obat> initObat(){
        Obat tempObat = new Obat();
        tempObat.setKode("OB01");
        tempObat.setNama("Paracetamol Forte 500mg");
        tempObat.setKategori("KAT01");
        tempObat.setHarga(100000);
        tempObat.setStok(10);
        dataObat.add(tempObat);

        tempObat = new Obat();
        tempObat.setKode("OB02");
        tempObat.setNama("Amoxicilin 250mg");
        tempObat.setKategori("KAT01");
        tempObat.setHarga(780000);
        tempObat.setStok(14);
        dataObat.add(tempObat);

        tempObat = new Obat();
        tempObat.setKode("OB03");
        tempObat.setNama("Tolak Angin Sachet");
        tempObat.setKategori("KAT02");
        tempObat.setHarga(80000);
        tempObat.setStok(34);
        dataObat.add(tempObat);

        tempObat = new Obat();
        tempObat.setKode("OB04");
        tempObat.setNama("JKT48 Flora Shafiqa Riyadi");
        tempObat.setKategori("KAT03");
        tempObat.setHarga(800000000);
        tempObat.setStok(1);
        dataObat.add(tempObat);

        return dataObat;
    }

    public ArrayList<Apoteker> initApoteker(){
        Apoteker tempApoteker = new Apoteker(
            "Admin",
            "Denpasar",
            "admin@admin.com",
            "0822764149979",
            "admin",
            "admin"
        );

        tempApoteker = new Apoteker(
            "Jepriana",
            "Vancouver",
            "jepriana@chat.openai.com",
            "085783492853",
            "jepri",
            "jepri"
        );
        dataApoteker.add(tempApoteker);

        return dataApoteker;
    }    

    public ArrayList<Customer> initCustomer(){
        Customer tempCustomer = new Customer(
            "Mangku",
            "Denpasar",
            "test1@test.com",
            "081298472193"
        );

        tempCustomer = new Customer(
            "Pastika",
            "Denpasar",
            "test1@test.com",
            "081298472194"
        );

        tempCustomer = new Customer(
            "Untuk Bali 1",
            "Denpasar",
            "test3@test.com",
            "081298472195"
        );

        tempCustomer = new Customer(
            "Heryandi Pradana",
            "Batubulan",
            "contactheryandi@gmail.com",
            "081298472234"
        );

        dataCustomer.add(tempCustomer);

        return dataCustomer;
    }
}
