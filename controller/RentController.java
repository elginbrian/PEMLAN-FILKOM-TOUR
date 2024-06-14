package controller;

import model.CarModel;
import model.EmployeeModel;

public class RentController extends AppController {
    public void rentCar(
        CarModel selectedCar,
        EmployeeModel selectedEmployee,
        int day
    ){  
        if(currentCustomer.getCustomerId() == "N/A"){
            System.out.println("\n[Notifikasi: Silahkan membuat akun customer terlebih dahulu]\n");
        } else {
            Double price = selectedCar.getPrice(day) + selectedEmployee.getFee(day);

            if(currentCustomer.spendBalance(price)){

    
                System.out.println("\n[Notifikasi: Transaksi berhasil diproses]\n");
            }
        }
    }

    public void returnCar(
        String numPlate
    ){


    }
    public void DisplayTransactionList(){

    }
}
