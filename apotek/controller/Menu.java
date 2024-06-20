package apotek.controller;
import java.util.Scanner;

public abstract class Menu {
  public Scanner input = new Scanner(System.in);

  public abstract void tampilMenu();

  public abstract void tampilData();

  public abstract void tambah();

  public abstract void edit();

  public abstract void hapus();

  public abstract int pilih();
}
