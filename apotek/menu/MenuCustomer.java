package apotek.menu;

import java.util.ArrayList;

import apotek.controller.Menu;
import apotek.controller.Customer;
import apotek.utility.ScreenHelper;

public class MenuCustomer extends Menu {
    private ArrayList<Customer> data;

    public MenuCustomer(ArrayList<Customer> data) {
        this.data = data;
    }

    public void tampilMenu() {
        int pilihan;
        do {
            ScreenHelper.clearConsole();
            System.out.println("+=============================================+");
            System.out.println("|                 DATA CUSTOMER               |");
            System.out.println("+=============================================+");
            System.out.println("| 1 | Tampil Customer                         |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 2 | Tambah Customer                         |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 3 | Edit Customer                           |");
            System.out.println("+---+-----------------------------------------+");
            System.out.println("| 4 | Hapus Customer                          |");
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

    public void tampilData() {
        ScreenHelper.clearConsole();
        if (data.size() > 0) {
            System.out.println("+=============================================+");
            System.out.println("|              TAMPIL DATA CUSTOMER           |");
            System.out.println("+=============================================+");
            for (Customer tempCustomer : data) {
                System.out.println("Nama Customer   : " + tempCustomer.getNama());
                System.out.println("Alamat Customer : " + tempCustomer.getAlamat());
                System.out.println("Email Customer  : " + tempCustomer.getEmail());
                System.out.println("No. HP          : " + tempCustomer.getHp());
                System.out.println("+=============================================+");
            }
            input.nextLine();
        } else {
            System.out.println("Data Customer kosong, silakan tambahkan data.");
            input.nextLine();
        }
    }

    public void tambah() {
        ScreenHelper.clearConsole();
        String nama, alamat, email, hp;
        System.out.println("+=============================================+");
        System.out.println("|             TAMBAH DATA CUSTOMER            |");
        System.out.println("+=============================================+");

        System.out.print("Nama Customer   : ");
        nama = input.nextLine();
        System.out.print("Alamat Customer : ");
        alamat = input.nextLine();
        System.out.print("Email Customer  : ");
        email = input.nextLine();
        System.out.print("No. HP          : ");
        hp = input.nextLine();
        input.nextLine();

        Customer tempCustomer = new Customer(
                nama, alamat, email, hp);
        data.add(tempCustomer);
        System.out.println("+=============================================+");
        System.out.println("|            DATA CUSTOMER TERSIMPAN          |");
        System.out.println("+=============================================+");
        input.nextLine();
    }

    public void edit() {
        int indexCustomer = pilih();
        if (indexCustomer != -1) {
            Customer editCustomer = data.get(indexCustomer);
            System.out.println("+=============================================+");
            System.out.println("|              EDIT DATA CUSTOMER             |");
            System.out.println("+=============================================+");
            System.out.print("Nama Customer   : ");
            editCustomer.setNama(input.nextLine());
            System.out.print("Alamat Customer : ");
            editCustomer.setAlamat(input.nextLine());
            System.out.print("Email Customer  : ");
            editCustomer.setEmail(input.nextLine());
            System.out.print("No. HP          : ");
            editCustomer.setHp(input.nextLine());
            input.nextLine();
            data.set(indexCustomer, editCustomer);
            System.out.println("+=============================================+");
            System.out.println("|            DATA CUSTOMER TERSIMPAN          |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public void hapus() {
        int indexCustomer = pilih();
        if (indexCustomer != -1) {
            data.remove(indexCustomer);
            System.out.println("+=============================================+");
            System.out.println("|             DATA CUSTOMER DIHAPUS           |");
            System.out.println("+=============================================+");
            input.nextLine();
        }
    }

    public int pilih() {
        ScreenHelper.clearConsole();
        int customerDipilih = -1;

        if (data.size() > 0) {
            do {
                System.out.println("+=============================================+");
                System.out.println("|                PILIH CUSTOMER               |");
                System.out.println("+=============================================+");
                for (int index = 0; index < data.size(); index++) {
                    Customer tempCustomer = data.get(index);
                    System.out.println("Index           : " + index);
                    System.out.println("Nama Customer   : " + tempCustomer.getNama());
                    System.out.println("Alamat Customer : " + tempCustomer.getAlamat());
                    System.out.println("Email Customer  : " + tempCustomer.getEmail());
                    System.out.println("No. HP          : " + tempCustomer.getHp());
                    System.out.println("+=============================================+");
                }

                System.out.print("Silakan pilih index Customer : ");
                customerDipilih = input.nextInt();
                input.nextLine();

            } while (customerDipilih == -1);
        } else {
            System.out.println("Data Customer kosong, silakan tambahkan data.");
            input.nextLine();
        }
        return customerDipilih;
    }
}
