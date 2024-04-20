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
            this.transactionId = UUID.randomUUID().toString();;
            this.customer = customer;
            this.employee = employee;
            this.car = car;
            this.day = day;
            this.price = car.getPrice(day);
        }

        public void DisplayTransaction(){
            System.out.println("TransactionId : " + transactionId);
            System.out.println("Customer ID   : " + customer.getCustomerId());
            System.out.println("Employee ID   : " + employee.getEmployeeId());
            System.out.println("Car ID        : " + car.getNumPlate());
            System.out.println("Day           : " + day);
            System.out.println("Price         : " + price);
            System.out.println("Is Returned   : " + (isReturned ? "Yes" : "No"));
            System.out.println("------------------------------------------");
        }
        
    }

    private Transaction transactionList[] = {};

    public void rentCar(
        CarModel selectedCar,
        EmployeeModel selectedEmployee,
        int day
    ){  
        if(currentCustomer.getCustomerId() == "N/A"){
            System.out.println("\n[Notifikasi: Silahkan membuat akun customer terlebih dahulu]\n");
        } else {
            Transaction[] newTransaction = new Transaction[transactionList.length + 1];
            for(int i=0; i<transactionList.length; i++){
                newTransaction[i] = transactionList[i];
            }
            
            newTransaction[newTransaction.length - 1] = new Transaction(currentCustomer, selectedEmployee, selectedCar, day);
        }
    }

    public void returnCar(
        String customerId,
        String numPlate,
        Double rateCar,
        Double rateEmployee
    ){
        
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
