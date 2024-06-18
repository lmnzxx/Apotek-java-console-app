package apotek.menu;

import java.util.ArrayList;

import apotek.controller.Kategori;
import apotek.controller.Obat;
import apotek.controller.Menu;
import apotek.utility.ScreenHelper;

public class MenuKategori extends Menu {
    private ArrayList<Kategori> data;
    private ArrayList<Obat> dataObat; // Menyimpan data obat

    public MenuKategori(ArrayList<Kategori> data, ArrayList<Obat> dataObat) {
        this.data = data;
        this.dataObat = dataObat; // Inisialisasi data obat
    }

    @Override
    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                DATA KATEGORI                |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Kategori                         |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Kategori                         |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Edit Kategori                           |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Kategori                          |");
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
            System.out.println("|             TAMPIL DATA KATEGORI            |");
            System.out.println("+=============================================+");
            for (Kategori tempKategori : data) {
                System.out.println("Kode Kategori     : " + tempKategori.getKode());
                System.out.println("Nama Kategori     : " + tempKategori.getKategori());
                System.out.println("+=============================================+");
            }

            // Pilih kategori untuk menampilkan obat
            System.out.print("Masukkan kode kategori untuk melihat obat atau tekan Enter untuk kembali: ");
            String kodeKategori = input.nextLine();
            if (!kodeKategori.isEmpty()) {
                tampilObatBerdasarkanKategori(kodeKategori);
            }
        } else {
            System.out.println("Data Kategori kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    private void tampilObatBerdasarkanKategori(String kodeKategori) {
        ScreenHelper.clearConsole();
        Kategori kategoriDipilih = null;
        for (Kategori kategori : data) {
            if (kategori.getKode().equalsIgnoreCase(kodeKategori)) {
                kategoriDipilih = kategori;
                break;
            }
        }

        if (kategoriDipilih != null) {
            System.out.println("+=============================================+");
            System.out.println("|        OBAT DENGAN KATEGORI: " + kategoriDipilih.getKategori().toUpperCase() + "         |");
            System.out.println("+=============================================+");
            boolean adaObat = false;
            for (Obat obat : dataObat) {
                if (obat.getKategori().equalsIgnoreCase(kodeKategori)) {
                    adaObat = true;
                    System.out.println("Nama Obat    : " + obat.getNama());
                    System.out.println("Harga Obat   : Rp " + obat.getHarga());
                    System.out.println("Stok Obat    : " + obat.getStok());
                    System.out.println("+---------------------------------------------+");
                }
            }

            if (!adaObat) {
                System.out.println("Tidak ada obat dalam kategori ini.");
            }

            input.nextLine();
        } else {
            System.out.println("Kode kategori tidak ditemukan.");
            input.nextLine();
        }
    }

    @Override
    public int pilih() {
        ScreenHelper.clearConsole();
        String kodeKategori = "";
        int kategoriDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                PILIH KATEGORI               |");
                System.out.println("+=============================================+");
                for (Kategori tempKategori : data) {
                    System.out.println("Kode Kategori     : " + tempKategori.getKode());
                    System.out.println("Nama Kategori     : " + tempKategori.getKategori());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih kode Kategori : ");
                kodeKategori = input.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getKode().equals(kodeKategori)) {
                        kategoriDipilih = i;
                        break;
                    }
                }
            } while (kategoriDipilih == -1);
        } else {
            System.out.println("Data Kategori kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return kategoriDipilih;
    }

    @Override
    public void tambah() {
        ScreenHelper.clearConsole();
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH DATA KATEGORI            |");
        System.out.println("+=============================================+");
        Kategori tempKategori = new Kategori();
        System.out.print("Kode Kategori     : ");
        tempKategori.setKode(input.nextLine());
        System.out.print("Nama Kategori     : ");
        tempKategori.setKategori(input.nextLine());
        data.add(tempKategori);
        System.out.println("+=============================================+");
        System.out.println("|            DATA KATEGORI TERSIMPAN          |");
        System.out.println("+=============================================+");
        input.nextLine();
    }

    @Override
    public void edit() {
        ScreenHelper.clearConsole();
        int indexKategori = pilih();
        if (indexKategori != -1) {
            Kategori editKategori = data.get(indexKategori);
            System.out.println("+=============================================+");
            System.out.println("|              EDIT DATA KATEGORI             |");
            System.out.println("+=============================================+");
            System.out.print("Kode Kategori     : ");
            editKategori.setKode(input.nextLine());
            System.out.print("Nama Kategori     : ");
            editKategori.setKategori(input.nextLine());
            data.set(indexKategori, editKategori);
            System.out.println("+=============================================+");
            System.out.println("|            DATA KATEGORI TERSIMPAN          |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public void hapus() {
        ScreenHelper.clearConsole();
        int indexKategori = pilih();
        if (indexKategori != -1) {
            data.remove(indexKategori);
            System.out.println("+=============================================+");
            System.out.println("|             DATA KATEGORI DIHAPUS           |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }
}
