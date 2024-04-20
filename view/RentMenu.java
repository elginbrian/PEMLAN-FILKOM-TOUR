import controller.CrudController;
import controller.TransactionController;
import model.CarModel;
import model.EmployeeModel;

import java.util.*;

public class RentMenu {
    public static void DisplayRentMenu(String[] args, TransactionController transaction, CrudController crud) {
        if(crud.userState == "customer"){
            Scanner input = new Scanner(System.in);
            System.out.println("\n=========================================");
            System.out.println("MENU RENTAL");
            System.out.println("=========================================");
            
            if(crud.currentCustomer.getCustomerId() == "N/A"){
                System.out.println("\n[Notifikasi: Silahkan membuat akun customer terlebih dahulu]");
            } else {
                System.out.println("Mobil yang tersedia: ");
                transaction.displayCarList();
                System.out.print("\nMasukkan plat nomor mobil yang ingin anda \nsewa: ");
    
                String numPlate = input.nextLine();
                CarModel selectedCar = crud.readCar(numPlate);
        
                EmployeeModel employeeNull = new EmployeeModel("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", 0.0);
                System.out.println("Sopir yang tersedia: ");
                transaction.displayEmployeeList();
        
                System.out.print("*Jika ingin tanpa supir tuliskan 'N/A'");
                System.out.print("\nMasukkan ID sopir yang ingin anda sewa: ");
                String employeeId = input.nextLine();
                EmployeeModel selectedEmployee = crud.readEmployee(employeeId);
        
                System.out.print("Masukkan jumlah hari anda menyewa: ");
                int day = input.nextInt();
        
                transaction.rentCar(selectedCar, selectedEmployee, day);
            }
            
        } else {
            System.out.println("\n=========================================");
            System.out.println("DATA TRANSAKSI");
            System.out.println("=========================================");
            transaction.DisplayTransactionList();
        }      
    }
}
