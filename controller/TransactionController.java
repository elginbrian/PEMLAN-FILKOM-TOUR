package controller;

import model.CustomerModel;

import java.util.UUID;

import model.CarModel;
import model.EmployeeModel;

public class TransactionController extends FilkomTourData {
    class Transaction{
        private String transactionId;
        private CustomerModel customer;
        private EmployeeModel employee;
        private CarModel car;
        private int day;
        private Double price;
        private Boolean isReturned = false;

        public Transaction(CustomerModel customer, EmployeeModel employee, CarModel car, int day){
            this.transactionId = UUID.randomUUID().toString().substring(0,8);
            this.customer = customer;
            this.employee = employee;
            this.car = car;
            this.day = day;
            this.price = car.getPrice(day) + employee.getFee(day);
        }

        public void DisplayTransaction(){
            System.out.println("TransactionId : " + transactionId);
            System.out.println("Customer ID   : " + customer.getCustomerId());
            System.out.println("Employee ID   : " + employee.getEmployeeId());
            System.out.println("Car ID        : " + car.getNumPlate());
            System.out.println("Day           : " + day);
            System.out.println("Price         : " + price);
            System.out.println("Is Returned   : " + (isReturned ? "Yes" : "Not yet"));
            System.out.println("------------------------------------------");
        }
        
    }

    private static Transaction transactionList[] = {};

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
            if(transactionList[i].car.getNumPlate().equals(numPlate)){
                transactionList[i].isReturned = true;
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
