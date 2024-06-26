package model;

import java.util.Arrays;
import java.util.UUID;

public class TransactionModel {
        private String transactionId;
        private CustomerModel customer;
        private EmployeeModel employee;
        private CarModel car;
        private int day;
        private Double price;
        private Boolean isReturned = false;

        public TransactionModel(CustomerModel customer, EmployeeModel employee, CarModel car, int day){
            this.transactionId = UUID.randomUUID().toString().substring(0,8);
            this.customer = customer;
            this.employee = employee;
            this.car = car;
            this.day = day;
            this.price = car.getPrice(day) + employee.getFee(day);
        }

        public TransactionModel(String transactionId, CustomerModel customer, EmployeeModel employee, CarModel car, int day, Double price, Boolean isReturned){
            this.transactionId = transactionId;
            this.customer = customer;
            this.employee = employee;
            this.car = car;
            this.day = day;
            this.price = price;
            this.isReturned = isReturned;
        }

        public String getStringArray(){
            String[] arr = {transactionId, customer.getUsername(), employee.getUsername(), car.getNumPlate(), String.valueOf(day), String.valueOf(price), String.valueOf(isReturned)};
            String stringArr = Arrays.toString(arr);

            return stringArr;
        }

        public CarModel getCar(){
            return car;
        }
        public CustomerModel getCustomer() { return this.customer; }

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
