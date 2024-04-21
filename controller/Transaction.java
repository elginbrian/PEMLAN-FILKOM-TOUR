package controller;

import model.CustomerModel;
import java.util.UUID;
import model.CarModel;
import model.EmployeeModel;

public class Transaction {
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

        public CarModel getCar(){
            return car;
        }

        public void setReturnStatus(boolean isReturned){
            this.isReturned = isReturned;
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
