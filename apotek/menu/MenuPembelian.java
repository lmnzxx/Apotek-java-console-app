package apotek.menu;

import java.util.ArrayList;

import apotek.controller.Obat;
import apotek.controller.Menu;
import apotek.controller.Customer;
import apotek.controller.Pembelian;
import apotek.controller.Apoteker;
import apotek.utility.ScreenHelper;

public class MenuPembelian extends Menu {
    private ArrayList<Pembelian> data;
    private ArrayList<Customer> dataCustomer;
    private ArrayList<Obat> dataObat;
    private MenuCustomer menuCustomer;
    private Apoteker apotekerAktif;

    public MenuPembelian(
            ArrayList<Pembelian> data,
            ArrayList<Obat> dataObat,
            ArrayList<Customer> dataCustomer,
            MenuCustomer mCustomer,
            MenuObat mObat,
            Apoteker apoteker) {
        this.data = data;
        this.dataObat = dataObat;
        this.dataCustomer = dataCustomer;
        this.menuCustomer = mCustomer;
        this.apotekerAktif = apoteker;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                DATA PEMBELIAN               |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Pembelian                        |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Pembelian                        |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Detail Pembelian                        |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Pembelian                         |");
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
                    detail();
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
            System.out.println("|              TAMPIL DATA PEMBELIAN          |");
            System.out.println("+=============================================+");
            for (Pembelian tempPembelian : data) {
                System.out.println("ID Pembelian       : " + tempPembelian.getIdPembelian());
                System.out.println("Nama Pembeli       : " + (tempPembelian.getPembeli() != null ? tempPembelian.getPembeli().getNama() : "Tidak Ada"));
                System.out.println("Apoteker           : " + tempPembelian.getApotekerPembelian().getNama());
                System.out.println("Tanggal Pembelian  : " + tempPembelian.getTanggalPembelian());
                System.out.println("Total Harga        : Rp " + tempPembelian.getTotalHarga());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Pembelian kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    @Override
    public void tambah() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH DATA PEMBELIAN           |");
        System.out.println("+=============================================+");

        Customer pembeli = null;
        System.out.println("Apakah Anda ingin menggunakan data customer yang sudah ada? (y | t)");
        String pilihan = input.nextLine();
        if (pilihan.equalsIgnoreCase("y")) {
            System.out.println("Silahkan pilih customer yang akan membeli!");
            int indexCustomer = menuCustomer.pilih();
            pembeli = dataCustomer.get(indexCustomer);
        } else {
            System.out.println("Apakah Anda ingin menambahkan data customer baru? (y | t)");
            pilihan = input.nextLine();
            if (pilihan.equalsIgnoreCase("y")) {
                pembeli = tambahCustomerBaru();
            }
        }

        Pembelian tempPembelian = new Pembelian(pembeli, apotekerAktif);

        System.out.println("Daftar Obat yang Tersedia:");
        for (int i = 0; i < dataObat.size(); i++) {
            Obat obat = dataObat.get(i);
            System.out.println(i + ". " + obat.getNama() + " - Rp " + obat.getHarga() + " - Stok: " + obat.getStok());
        }

        double totalHarga = 0.0;
        boolean selesai = false;
        do {
            System.out.print("Masukkan indeks obat yang ingin dibeli (atau -1 untuk selesai): ");
            int indexObat = input.nextInt();
            input.nextLine();
            if (indexObat >= 0 && indexObat < dataObat.size()) {
                Obat obatDipilih = dataObat.get(indexObat);
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlah = input.nextInt();
                input.nextLine();
                if (jumlah <= obatDipilih.getStok()) {
                    tempPembelian.tambahObat(obatDipilih, jumlah);
                    obatDipilih.beli(jumlah); 
                    totalHarga += obatDipilih.getHarga() * jumlah;
                } else {
                    System.out.println("Stok obat tidak mencukupi. Pembelian dibatalkan.");
                }
            } else if (indexObat == -1) {
                selesai = true;
            } else {
                System.out.println("Indeks obat tidak valid. Pembelian dibatalkan.");
                selesai = true;
            }
        } while (!selesai);

        System.out.println("+=============================================+");
        System.out.println("|        TOTAL HARGA PEMBELIAN: Rp " + totalHarga + "       |");
        System.out.println("+=============================================+");
        System.out.print("Tekan Enter untuk menyelesaikan pembelian atau ketik 'batalkan' untuk membatalkan...");
        String konfirmasi = input.nextLine();
        if (konfirmasi.equalsIgnoreCase("batalkan")) {
            System.out.println("Pembelian dibatalkan.");
            return;
        }

        if (totalHarga > 0.0) {
            tempPembelian.setTotalHarga(totalHarga);
            data.add(tempPembelian);
            System.out.println("+=============================================+");
            System.out.println("|            DATA PEMBELIAN TERSIMPAN         |");
            System.out.println("+=============================================+");
        } else {
            System.out.println("Pembelian dibatalkan.");
        }
        input.nextLine();
    }

    private Customer tambahCustomerBaru() {
        String nama, alamat, email, hp;
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH DATA CUSTOMER           |");
        System.out.println("+=============================================+");

        System.out.print("Nama Customer  : ");
        nama = input.nextLine();
        System.out.print("Alamat Customer: ");
        alamat = input.nextLine();
        System.out.print("Email Customer : ");
        email = input.nextLine();
        System.out.print("No. HP          : ");
        hp = input.nextLine();

        Customer tempCustomer = new Customer(nama, alamat, email, hp);
        return tempCustomer;
    }

    @Override
    public void hapus() {
        int indexPembelian = pilih();
        if (indexPembelian != -1) {
            data.remove(indexPembelian);
            System.out.println("+=============================================+");
            System.out.println("|             DATA PEMBELIAN DIHAPUS          |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    @Override
    public int pilih() {
        ScreenHelper.clearConsole();
        int pembelianDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                PILIH PEMBELIAN              |");
                System.out.println("+=============================================+");
                for (int index = 0; index < data.size(); index++) {
                    Pembelian tempPembelian = data.get(index);
                    System.out.println("INDEX               : " + index);
                    System.out.println("ID Pembelian        : " + tempPembelian.getIdPembelian());
                    System.out.println("Nama Pembeli        : " + (tempPembelian.getPembeli() != null ? tempPembelian.getPembeli().getNama() : "Tidak Ada"));
                    System.out.println("Apoteker            : " + tempPembelian.getApotekerPembelian().getNama());
                    System.out.println("Tanggal Pembelian   : " + tempPembelian.getTanggalPembelian());
                    System.out.println("Total Harga         : Rp " + tempPembelian.getTotalHarga());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih INDEX Pembelian : ");
                pembelianDipilih = input.nextInt();
                input.nextLine();
            } while (pembelianDipilih == -1);
        } else {
            System.out.println("Data Pembelian kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return pembelianDipilih;
    }

    public void detail() {
        int indexPembelian = pilih();
        if (indexPembelian != -1) {
            Pembelian pembelian = data.get(indexPembelian);
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|              DETAIL PEMBELIAN               |");
            System.out.println("+=============================================+");
            System.out.println("ID Pembelian       : " + pembelian.getIdPembelian());
            System.out.println("Nama Pembeli       : " + (pembelian.getPembeli() != null ? pembelian.getPembeli().getNama() : "Tidak Ada"));
            System.out.println("Apoteker           : " + pembelian.getApotekerPembelian().getNama());
            System.out.println("Tanggal Pembelian  : " + pembelian.getTanggalPembelian());
            System.out.println("Total Harga        : Rp " + pembelian.getTotalHarga());
            System.out.println("+=============================================+");
            System.out.println("Detail Obat yang Dibeli:");
            for (Obat obat : pembelian.getDaftarObat().keySet()) {
                int jumlah = pembelian.getDaftarObat().get(obat);
                System.out.println("- " + obat.getNama() + " x " + jumlah + " = Rp " + (obat.getHarga() * jumlah));
            }
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Unimplemented method 'edit'");
    }
}
