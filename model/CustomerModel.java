package model;

public class CustomerModel {
    private String customerID;
    private String phoneNum;
    private String name;
    private int age;
    private String address;
    private String gender;
    private Double balance=0.0;

    public CustomerModel(String customerID, String phoneNum, String name, int age, String address, String gender){
        this.customerID=customerID;
        this.phoneNum=phoneNum;
        this.name=name;
        this.age=age;
        this.address=address;
        this.gender=gender;
    }

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
    
    public void spendBalance(double price){
        if (price > 0) {
            if (balance >= price) {
                balance -= price;
                System.out.println("Spent " + price + ". Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount for spending.");
        }
    }

    public void displayCustomer(){
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + gender);
        System.out.println("Balance: " + balance);
    }
}
