package apotek.menu;

import java.util.ArrayList;

import apotek.controller.Obat;
import apotek.controller.Kategori;
import apotek.controller.Menu;
import apotek.utility.DataApotek;
import apotek.utility.ScreenHelper;


public class MenuObat extends Menu {
    ArrayList<Obat> data;
    DataApotek dataApotek;

    public MenuObat(ArrayList<Obat> data, DataApotek dataApotek) {
        this.data = data;
        this.dataApotek = dataApotek;
    }

    @Override
    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                  DATA OBAT                  |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Obat                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Obat                             |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Edit Obat                               |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Obat                              |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Kembali                                 |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...4) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    tampilData();
                    break;
                case 2:
                    tambah();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    hapus();
                    break;
                case 0:
                    System.out.println("+=============================================+");
                    System.out.println("|            KEMBALI KE MENU UTAMA            |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia, silakan ulangi kembali.");
                    input.next();
            }
        } while (pilihan != 0);
    }

    @Override
    public void tampilData() {
        ScreenHelper.clearConsole();
        if (data.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|               TAMPIL DATA OBAT              |");
            System.out.println("+=============================================+");
            for (Obat tempObat : data) {
                System.out.println("Kode Obat     : " + tempObat.getKode());
                System.out.println("Nama Obat     : " + tempObat.getNama());
                String namaKategori = dataApotek.getNamaKategori(tempObat.getKategori());
                System.out.println("Kategori Obat : " + namaKategori);
                System.out.println("Harga Obat    : " + tempObat.getHarga());
                System.out.println("Stok Obat     : " + tempObat.getStok());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Obat kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

        public void tampilDataKategori() {
        ScreenHelper.clearConsole();
        ArrayList<Kategori> dataKategori = dataApotek.initKategori();
        if (dataKategori.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|                 DATA KATEGORI               |");
            System.out.println("+=============================================+");
            for (Kategori tempKategori : dataKategori) {
                System.out.println("Kode Kategori : " + tempKategori.getKode());
                System.out.println("Nama Kategori : " + tempKategori.getKategori());
                System.out.println("+=============================================+");
            }
        } else {
            System.out.println("Data Kategori kosong, silakan tambahkan data.");
        }
    }

    @Override
    public int pilih() {
        ScreenHelper.clearConsole();
        String kodeObat = "";
        int ObatDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                  PILIH OBAT                 |");
                System.out.println("+=============================================+");
                for (Obat tempObat : data) {
                    System.out.println("Kode Obat     : " + tempObat.getKode());
                    System.out.println("Nama Obat     : " + tempObat.getNama());
                    String namaKategori = dataApotek.getNamaKategori(tempObat.getKategori());
                    System.out.println("Kategori Obat : " + namaKategori);
                    System.out.println("Harga Obat    : " + tempObat.getHarga());
                    System.out.println("Stok Obat     : " + tempObat.getStok());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih kode Obat : ");
                kodeObat = input.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getKode().equals(kodeObat)) {
                        ObatDipilih = i;
                        break;
                    }
                }
            } while (ObatDipilih == -1);
        } else {
            System.out.println("Data Obat kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return ObatDipilih;
    }

    @Override
    public void tambah() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|               TAMBAH DATA OBAT              |");
        System.out.println("+=============================================+");
        Obat tempObat = new Obat();
        System.out.print("Kode Obat     : ");
        tempObat.setKode(input.nextLine());
        System.out.print("Nama Obat     : ");
        tempObat.setNama(input.nextLine());
        tampilDataKategori();
        System.out.print("Kategori Obat : ");
        tempObat.setKategori(input.nextLine());
        System.out.print("Harga Obat    : ");
        tempObat.setHarga(input.nextInt());
        System.out.print("Stok Obat     : ");
        tempObat.setStok(input.nextInt());
        data.add(tempObat);
        System.out.println("+=============================================+");
        System.out.println("|              DATA OBAT TERSIMPAN            |");
        System.out.println("+=============================================+");
        input.nextLine();
        input.nextLine();
    }

    @Override
    public void edit() {
        ScreenHelper.clearConsole();
        int indexObat = pilih();
        if (indexObat != -1) {
            Obat editObat = data.get(indexObat);
            System.out.println("+=============================================+");
            System.out.println("|                EDIT DATA OBAT               |");
            System.out.println("+=============================================+");
            System.out.print("Kode Obat     : ");
            editObat.setKode(input.nextLine());
            System.out.print("Nama Obat     : ");
            editObat.setNama(input.nextLine());
            tampilDataKategori();
            System.out.print("Kategori Obat : ");
            editObat.setKategori(input.nextLine());
            System.out.print("Harga Obat    : ");
            editObat.setHarga(input.nextInt());
            System.out.print("Stok Obat     : ");
            editObat.setStok(input.nextInt());
            data.set(indexObat, editObat);
            System.out.println("+=============================================+");
            System.out.println("|              DATA OBAT TERSIMPAN            |");
            System.out.println("+=============================================+");
            input.nextLine();
            input.nextLine();
        }
    }

    public void hapus() {
        ScreenHelper.clearConsole();
        int indexObat = pilih();
        if (indexObat != -1) {
            data.remove(indexObat);
            System.out.println("+=============================================+");
            System.out.println("|               DATA OBAT DIHAPUS             |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

}
