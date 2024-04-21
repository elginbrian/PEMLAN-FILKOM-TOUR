package controller;

import model.CustomerModel;
import java.util.UUID;
import model.CarModel;
import model.EmployeeModel;

public class RentController extends AppData {
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
                Transaction[] newTransaction = new Transaction[transactionList.length + 1];
                for(int i=0; i<transactionList.length; i++){
                    newTransaction[i] = transactionList[i];
                }
                newTransaction[newTransaction.length - 1] = new Transaction(currentCustomer, selectedEmployee, selectedCar, day);
                transactionList = newTransaction;
    
                System.out.println("\n[Notifikasi: Transaksi berhasil diproses]\n");
            }
        }
    }

    public void returnCar(
        String numPlate
    ){
        for(int i=0; i<transactionList.length; i++){
            if(transactionList[i].getCar().getNumPlate().equals(numPlate)){
                transactionList[i].setReturnStatus(true);
                System.out.println("\n[Notifikasi: Mobil berhasil dikembalikan]\n");
                break;
            }
        }

    }
    public void DisplayTransactionList(){
        if(transactionList.length > 0){
            for(int i=0; i<transactionList.length; i++){
                transactionList[i].DisplayTransaction();
            }
        } else {
            System.out.println("\n[Notifikasi: Data Transaksi Kosong]\n");
        }
    }
}
