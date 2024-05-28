package cli;

import controller.CrudController;
import controller.RentController;
import model.CarModel;
import model.EmployeeModel;

import java.util.*;

public class RentMenu {
    public static void DisplayRentMenu(String[] args, RentController transaction, CrudController crud) {
        if(crud.userState == "customer"){
            Scanner input = new Scanner(System.in);
            System.out.println("\n=========================================");
            System.out.println("MENU RENTAL");
            System.out.println("=========================================");
            
            if(crud.currentCustomer.getCustomerId() == "N/A"){
                System.out.println("\n[Notifikasi: Silahkan membuat akun customer terlebih dahulu]");
            } else {
                System.out.println("Apa tindakan yang ingin anda lakukan?");
                System.out.println("1. Menyewa Mobil");
                System.out.println("2. Mengembalikan Mobil");
                System.out.print("Masukkan pilihan anda: ");
                int choice = input.nextInt();
                input.nextLine();

                if(choice == 1){
                    System.out.println("\nMobil yang tersedia: ");
                    System.out.println("------------------------------------------");
                    transaction.displayCarList();
                    
                    
                    System.out.print("\nMasukkan plat nomor mobil yang ingin anda \nsewa: ");
                    String numPlate = input.nextLine();
                    
                    CarModel selectedCar = crud.readCar(numPlate);
            
                    EmployeeModel employeeNull = new EmployeeModel("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", 0.0);
                    System.out.println("Sopir yang tersedia: ");
                    System.out.println("------------------------------------------");
                    transaction.displayEmployeeList();
            
                    System.out.print("*Jika ingin tanpa supir tuliskan 'N/A'");
                    System.out.print("\nMasukkan ID sopir yang ingin anda sewa: ");
                    String employeeId = input.nextLine();
                    EmployeeModel selectedEmployee = crud.readEmployee(employeeId);
            
                    System.out.print("Masukkan jumlah hari anda menyewa: ");
                    int day = input.nextInt();
                    input.nextLine();
    
                    System.out.println("\n=========================================");
                    System.out.println("BIAYA");
                    System.out.println("=========================================");
                    System.out.println("Biaya Mobil : Rp." + selectedCar.getPrice(day));
                    System.out.println("Biaya Sopir : Rp." + selectedEmployee.getFee(day));
                    System.out.println("Total Biaya : Rp." + (selectedCar.getPrice(day) + selectedEmployee.getFee(day)));
                    System.out.println("=========================================");
                    System.out.print("Ingin melanjutkan? (y/n) : ");
                    String confirm = input.nextLine();
                    if(confirm.equalsIgnoreCase("y")){
                        transaction.rentCar(selectedCar, selectedEmployee, day);
                    }

                } else if(choice == 2){
                    System.out.print("Masukkan plat nomor mobil yang ingin \nanda kembalikan: ");
                    String numPlate = input.nextLine();
                    transaction.returnCar(numPlate);
                }
            }
            
        } else {
            System.out.println("\n=========================================");
            System.out.println("DATA TRANSAKSI");
            System.out.println("=========================================");
            transaction.DisplayTransactionList();
        }      
    }
}
