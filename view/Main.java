//package view;
import java.util.*;
import controller.CrudController;
import controller.RentController;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CrudController crud = new CrudController();
        RentController transaction = new RentController();
        boolean continueLoop = true;

        /*
            What customers can do:
            - Create Customer
            - Read Car
            - Read Employee
            - Rent Car
            - Return Car

            What employees can do:
            - Create, Read, Update, Delete Car
            - Create, Read, Update, Delete Employee
            - Create, Read, Update, Delete Customer
        */

        while(continueLoop) {
            System.out.println("\n=========================================");
            System.out.println("SELAMAT DATANG DI APLIKASI FILKOM TOUR");
            System.out.println("=========================================");
            System.out.println("Silahkan pilih role anda!");
            System.out.println("1. Karyawan");
            System.out.println("2. Customer");
            System.out.println("0. Keluar");
            System.out.print("\nMasukkan pilihan anda: ");
            int role = input.nextInt();

            switch(role) {
                case 1:
                    crud.userState = "employee";
                    break;
                case 2:
                    crud.userState = "customer";
                    break;
                default:
                    break;
            }

            if (crud.userState == "employee"){
                while(true){
                    System.out.println("\n=========================================");
                    System.out.println("SELAMAT DATANG DI MENU KARYAWAN");
                    System.out.println("=========================================");
                    System.out.println("Data apa yang ingin anda akses?");
                    System.out.println("1. Data Transaksi");
                    System.out.println("2. Data Mobil");
                    System.out.println("3. Data Karyawan");
                    System.out.println("4. Data Customer");
                    System.out.println("5. Cancel");
                    
                    System.out.print("\nMasukkan pilihan anda: ");
                    int option = input.nextInt();
    
                    if(option == 1){
                        RentMenu.DisplayRentMenu(args, transaction, crud);

                    } else if(option == 2) {
                        CarMenu.DisplayCarMenu(args, crud);
                        
                    } else if (option == 3){
                        EmployeeMenu.DisplayEmployeeMenu(args, crud);
                        
                    } else if (option == 4){
                        CustomerMenu.DisplayCustomerMenu(args, crud);
                        
                    } else {
                        break;
                    }
                }

            } else if (crud.userState == "customer"){
                
                while(true){
                    System.out.println("\n=========================================");
                    System.out.println("SELAMAT DATANG CUSTOMER");
                    System.out.println("=========================================");
    
                    System.out.println("Apa keperluan anda?");
                    System.out.println("1. Akses Profil Akun Customer");
                    System.out.println("2. Melihat List Mobil");
                    System.out.println("3. Melihat List Karyawan");
                    System.out.println("4. Rental Mobil");
                    System.out.println("5. Top-up Saldo");
                    System.out.println("6. Cancel");
    
                    System.out.print("\nMasukkan pilihan anda: ");
                    int option = input.nextInt();
    
                    if(option == 1){
                        CustomerMenu.DisplayCustomerMenu(args, crud);

                    } else if(option == 2){
                        CarMenu.DisplayCarMenu(args, crud);

                    } else if(option == 3){
                        EmployeeMenu.DisplayEmployeeMenu(args, crud);

                    } else if(option == 4){
                        RentMenu.DisplayRentMenu(args, transaction, crud);

                    } else if(option == 5){
                        TopupMenu.DisplayTopupMenu(args, crud);

                    } else {
                        break;
                    }
                }
                
            } else if (role == 0){
                continueLoop = false;
            }
        }
    }
}