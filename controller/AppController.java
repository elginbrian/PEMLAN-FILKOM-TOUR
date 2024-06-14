package controller;

import model.CustomerModel;

public class AppController {
    protected static final String vehicleRoute  = "data/VehicleTable.txt";
    protected static final String customerRoute = "data/CustomerTable.txt";
    protected static final String employeeRoute = "data/EmployeeTable.txt";
    protected static final String authRoute     = "data/UserTable.txt";

    public static String userState = "customer";
    public static CustomerModel currentCustomer = new CustomerModel("N/A", "N/A", "N/A", 0, "N/A", "N/A");

    public void getCarList(){

    }

    public void getEmployeeList(){

    }

    public void getCustomerList(){

    }
}
