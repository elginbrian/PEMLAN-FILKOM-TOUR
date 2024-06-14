package model;

import java.util.Arrays;

public class CustomerModel extends UserModel {
    private String customerID = super.getUserID();
    private String phoneNum = "Undecided";
    private String name = super.getUsername();
    private int age = 0;
    private String address = "Undecided";
    private String gender = "Undecided";
    private Double balance=0.0;

    public CustomerModel(String customerID, String phoneNum, String name, int age, String address, String gender){
        super(name, "customer", "customer");
        this.phoneNum=phoneNum;
        this.name=name;
        this.age=age;
        this.address=address;
        this.gender=gender;
    }

    public CustomerModel(String customerID, String phoneNum, String name, int age, String address, String gender, Double balance){
        super(name, "customer", "customer");
        this.customerID = customerID;
        this.phoneNum=phoneNum;
        this.name=name;
        this.age=age;
        this.address=address;
        this.gender=gender;
        this.balance = balance;
    }

    public CustomerModel(String userID, String username, String password, String type){
        super(userID, username, password, type);
    }

    @Override
    public String getStringArray(){
        String[] arr = {customerID, address, name, phoneNum, gender, balance.toString(), String.valueOf(age)};
        String stringArr = Arrays.toString(arr);

        return stringArr;
    }

    public String getCustomerId(){
        return customerID;
    }
    public Double getBalance() {return balance; }

    public void updateCustomerInfo(String name, String phoneNum, String address, String gender){
        this.name=name;
        this.phoneNum=phoneNum;
        this.address=address;
        this.gender=gender;
    }

    public void topUpBalance(double add){
        if (add > 0) {
            balance += add;
            System.out.println("Balance topped up by " + add + ". Current balance: " + balance);
        } else {
            System.out.println("Invalid amount for top-up.");
        }
    }
    
    public boolean spendBalance(double price){
        if (price > 0) {
            if (balance >= price) {
                balance -= price;
                System.out.println("Spent " + price + ". Remaining balance: " + balance);
                return true;
            } else {
                System.out.println("Insufficient balance.");
                return false;
            }
        } else {
            System.out.println("Invalid amount for spending.");
            return false;
        }
    }

    public void displayCustomer(){
        System.out.println("Customer ID  : " + customerID);
        System.out.println("Name         : " + name);
        System.out.println("Phone Number : " + phoneNum);
        System.out.println("Age          : " + age);
        System.out.println("Address      : " + address);
        System.out.println("Gender       : " + gender);
        System.out.println("Balance      : " + balance);
        System.out.println("------------------------------------------");
    }
}
