package apotek.menu;

import java.util.ArrayList;
import java.util.Scanner;

import apotek.controller.*;
import apotek.utility.DataApotek;
import apotek.utility.ScreenHelper;

public class MainMenu {
    private DataApotek masterData = new DataApotek();
    private ArrayList<Obat> dataObat = masterData.initObat();
    private ArrayList<Kategori> dataKategori = masterData.initKategori();
    private ArrayList<Customer> dataPelanggan = masterData.initCustomer();
    private ArrayList<Pembelian> dataPembelian = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private Apoteker activeApoteker;
    private MenuObat menuObat;
    private MenuKategori menuKategori;
    private MenuApoteker menuApoteker;
    private MenuCustomer menuCustomer;
    private MenuPembelian menuPembelian;

    public MainMenu(ArrayList<Apoteker> dataPetugas, Apoteker petugas) {
        this.activeApoteker = petugas;
        this.menuObat = new MenuObat(dataObat, masterData);
        this.menuKategori = new MenuKategori(dataKategori, dataObat);
        this.menuApoteker = new MenuApoteker(dataPetugas);
        this.menuCustomer = new MenuCustomer(dataPelanggan);
        this.menuPembelian = new MenuPembelian(dataPembelian, dataObat, dataPelanggan,
                menuCustomer, menuObat, activeApoteker);
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                  MAIN MENU                  |");
            System.out.println("+=============================================+");
            System.out.println("|    APOTEK PEMROGRAMAN BERORIENTASI OBJEK    |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Menu Obat                               |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Menu Kategori Obat                      |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Menu Customer                           |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Menu Apoteker                           |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 5 | Pembelian Obat                          |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 0 | Logout                                  |");
            System.out.println("+=============================================+");
            System.out.print("\nSilakan masukan pilihan anda (0...5) : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    menuObat.tampilMenu();
                    break;
                case 2:
                    menuKategori.tampilMenu();
                    break;
                case 3:
                    menuCustomer.tampilMenu();
                    break;
                case 4:
                    menuApoteker.tampilMenu();
                    break;
                case 5:
                    menuPembelian.tampilMenu();
                    break;
                case 0:
                    ScreenHelper.clearConsole();
                    System.out.println("+=============================================+");
                    System.out.println("|             KELUAR DARI PROGRAM             |");
                    System.out.println("+=============================================+\n");
                    break;
                default:
                    System.out.println("Pilihan yang anda input tidak tersedia, silakan ulangi kembali.");
                    input.next();
            }
        } while (pilihan != 0);
    }
}
