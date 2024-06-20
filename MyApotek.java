import java.util.ArrayList;
import java.util.Scanner;

import apotek.controller.Apoteker;
import apotek.menu.MainMenu;
import apotek.utility.DataApotek;
import apotek.utility.ScreenHelper;

public class MyApotek {
    private static Scanner input = new Scanner(System.in);
    private static DataApotek masterData = new DataApotek();
    private static ArrayList<Apoteker> dataApoteker;
    private static Apoteker activeApoteker;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        dataApoteker = masterData.initApoteker();

        while(isRunning) {
            showMenu();
        }
    }

    private static void showMenu() {
        while(activeApoteker == null) {
            loginMenu();
        }
        MainMenu menuApotek = new MainMenu(dataApoteker, activeApoteker);
        menuApotek.tampilMenu();
        
        activeApoteker = null;
        System.out.print("Apakah anda ingin menutup program ini? (y | t) : ");
        String jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("y")) {
            isRunning = false;
            ScreenHelper.clearConsole();
            System.out.println("+==============================================+");
            System.out.println("| TERIMAKASIH SUDAH MENGGUNAKAN PROGRAM INI :) |");
            System.out.println("+==============================================+");        
        }
    }

    private static void loginMenu() {
        ScreenHelper.clearConsole();
        String username, password;
        System.out.println("+=============================================+");
        System.out.println("|                LOGIN APOTEKER               |");
        System.out.println("+=============================================+");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        for (Apoteker temp: dataApoteker) {
            if (temp.login(username, password)) {
                activeApoteker = temp;
            }
        }           
    }
}
