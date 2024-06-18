package apotek.menu;

import java.util.ArrayList;

import apotek.controller.Menu;
import apotek.controller.Apoteker;
import apotek.utility.ScreenHelper;

public class MenuApoteker extends Menu {
    private ArrayList<Apoteker> data;

    public MenuApoteker(ArrayList<Apoteker> data) {
        this.data = data;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+==============================================+");
            System.out.println("|                  MENU APOTEKER               |");
            System.out.println("+==============================================+");
            System.out.println("| 1 | Tampil Apoteker                          |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 2 | Tambah Apoteker                          |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 3 | Edit Apoteker                            |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 4 | Hapus Apoteker                           |");
            System.out.println("+---+------------------------------------------+");
            System.out.println("| 0 | Kembali                                  |");
            System.out.println("+==============================================+");
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

    public void tampilData() {
        ScreenHelper.clearConsole();
        if (data.size() > 0) {
            System.out.println("+==============================================+");
            System.out.println("|               TAMPIL DATA APOTEKER           |");
            System.out.println("+==============================================+");
            for (Apoteker tempApoteker : data) {
                System.out.println("Username        : " + tempApoteker.getUsername());
                System.out.println("Nama Apoteker   : " + tempApoteker.getNama());
                System.out.println("Alamat Apoteker : " + tempApoteker.getAlamat());
                System.out.println("Email Apoteker  : " + tempApoteker.getEmail());
                System.out.println("No. HP          : " + tempApoteker.getHp());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Apoteker kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    public void tambah() {
        ScreenHelper.clearConsole();
        String username, nama, alamat, email, hp, password;
        System.out.println("+==============================================+");
        System.out.println("|              TAMBAH DATA APOTEKER            |");
        System.out.println("+==============================================+");

        System.out.print("Username        : ");
        username = input.nextLine();
        System.out.print("Nama Apoteker   : ");
        nama = input.nextLine();
        System.out.print("Alamat Apoteker : ");
        alamat = input.nextLine();
        System.out.print("Email Apoteker  : ");
        email = input.nextLine();
        System.out.print("No. HP          : ");
        hp = input.nextLine();
        System.out.print("Password        : ");
        password = input.nextLine();

        Apoteker tempApoteker = new Apoteker(
                nama, alamat, email, hp, username, password);
        data.add(tempApoteker);
        System.out.println("+==============================================+");
        System.out.println("|             DATA APOTEKER TERSIMPAN          |");
        System.out.println("+==============================================+");
        input.nextLine();
    }

    public void edit() {
        int indexApoteker = pilih();
        if (indexApoteker != -1) {
            Apoteker editApoteker = data.get(indexApoteker);
            System.out.println("+==============================================+");
            System.out.println("|               EDIT DATA APOTEKER             |");
            System.out.println("+==============================================+");
            System.out.print("Username        : ");
            editApoteker.setUsername(input.nextLine());
            System.out.print("Nama Apoteker   : ");
            editApoteker.setNama(input.nextLine());
            System.out.print("Alamat Apoteker : ");
            editApoteker.setAlamat(input.nextLine());
            System.out.print("Email Apoteker  : ");
            editApoteker.setEmail(input.nextLine());
            System.out.print("No. HP          : ");
            editApoteker.setHp(input.nextLine());
            System.out.print("Password        : ");
            editApoteker.setPassword(input.nextLine());
            data.set(indexApoteker, editApoteker);
            System.out.println("+==============================================+");
            System.out.println("|             DATA APOTEKER TERSIMPAN          |");
            System.out.println("+==============================================+");
            input.nextLine();
            input.nextLine();
        }
    }

    public void hapus() {
        int indexApoteker = pilih();
        if (indexApoteker != -1) {
            data.remove(indexApoteker);
            System.out.println("+==============================================+");
            System.out.println("|              DATA APOTEKER DIHAPUS           |");
            System.out.println("+==============================================+");
            input.nextLine();
        }
    }

    public int pilih() {
        ScreenHelper.clearConsole();
        String username = "";
        int apotekerDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+==============================================+");
                System.out.println("|                 PILIH APOTEKER               |");
                System.out.println("+==============================================+");
                for (Apoteker tempApoteker : data) {
                    System.out.println("Username        : " + tempApoteker.getUsername());
                    System.out.println("Nama Apoteker   : " + tempApoteker.getNama());
                    System.out.println("Alamat Apoteker : " + tempApoteker.getAlamat());
                    System.out.println("Email Apoteker  : " + tempApoteker.getEmail());
                    System.out.println("No. HP          : " + tempApoteker.getHp());
                    System.out.println("+==============================================+");
                }

                System.out.print("Silakan pilih username Apoteker : ");
                username = input.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getUsername().equals(username)) {
                        apotekerDipilih = i;
                        break;
                    }
                }
            } while (apotekerDipilih == -1);
        } else {
            System.out.println("Data Apoteker kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return apotekerDipilih;
    }
}
