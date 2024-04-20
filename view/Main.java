package view;

import java.util.*;
import controller.CrudController;
import controller.TransactionController;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CrudController crud = new CrudController();
        TransactionController transaction = new TransactionController();
        boolean continueLoop = true;
        /*
            What customers can do:
            - Create, Read, Update, Delete Customer
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
            System.out.println("SELAMAT DATANG Di APLIKASI FILKOM TOUR");
            System.out.println("=========================================");
            System.out.print("\nSilahkan pilih role anda (employee/customer) atau ketikkan 'batal' untuk keluar aplikasi: ");
            String role = input.nextLine();

            if (role.equalsIgnoreCase("employee")){
                System.out.println("\n=========================================");
                System.out.println("SELAMAT DATANG EMPLOYEE");
                System.out.println("=========================================");
                System.out.println("Apa yang ingin anda setting?");
                System.out.println("1. Car");
                System.out.println("2. Employee");
                System.out.println("3. Customer");
                System.out.println("4. Cancel");
                
                System.out.print("\nMasukkan pilihan anda: ");
                int option = input.nextInt();

                if(option == 1){
                    System.out.println("\n=========================================");
                    System.out.println("SETTING CAR");

                    System.out.println("\n1. Create Mobil");
                    System.out.println("2. Read Mobil");
                    System.out.println("3. Update Mobil");
                    System.out.println("4. Delete Mobil");
                    System.out.println("5. Cancel");

                    System.out.print("\nMasukkan pilihan anda: ");
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            
                            break;
                        case 2:

                            break;
                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:
                        role = "employee";
                            break;
                    }

                } else if (option == 2){
                    System.out.println("\n=========================================");
                    System.out.println("SETTING EMPLOYEE");

                    System.out.println("\n1. Create Employee");
                    System.out.println("2. Read Employee");
                    System.out.println("3. Update Employee");
                    System.out.println("4. Delete Employee");
                    System.out.println("5. Cancel");

                    System.out.print("\nMasukkan pilihan anda: ");
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            
                            break;
                        case 2:

                            break;
                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:
                        role = "employee";
                            break;
                    }

                } else if (option == 3){
                    System.out.println("\n=========================================");
                    System.out.println("SETTING CUSTOMER");
                    System.out.println("\n1. Create Customer");
                    System.out.println("2. Read Customer");
                    System.out.println("3. Update Customer");
                    System.out.println("4. Delete Customer");
                    System.out.println("5. Cancel");
                    System.out.print("\nMasukkan pilihan anda: ");
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            
                            break;
                        case 2:

                            break;
                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:
                        role = "employee";
                            break;
                    }
                } else if(option == 4){
                    role = input.nextLine();
                }

            } else if (role.equalsIgnoreCase("customer")){
                System.out.println("=========================================");
                System.out.println("SELAMAT DATANG CUSTOMER");
                System.out.println("=========================================");

                System.out.println("\nApa keperluan anda?");
                System.out.println("1. Create Customer");
                System.out.println("2. Read Customer");
                System.out.println("3. Update Customer");
                System.out.println("4. Delete Customer");
                System.out.println("5. Read Car");
                System.out.println("6. Read Employee");
                System.out.println("7. Rent Car");
                System.out.println("8. Return Car");
                System.out.println("9. Cancel");

                System.out.print("\nMasukkan pilihan anda: ");
                int option = input.nextInt();

                    switch (option) {
                        case 1:
                            
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:
                        
                            break;
                        case 6:

                            break;
                        case 7: 

                            break;
                        case 8:

                            break;
                        case 9:
                        role = input.nextLine();
                            break;
                        default:
                            break;
                    }

            } else if (role.equalsIgnoreCase("batal")){
                continueLoop = false;
            }
        }
    }
}