package controller;

import model.CarModel;
import model.EmployeeModel;
import model.CustomerModel;
import java.util.*;

public class FilkomTourData {
    public static  String userState = "customer";
    public static CustomerModel currentCustomer = new CustomerModel("N/A", "N/A", "N/A", 0, "N/A", "N/A");

    protected static CarModel[] carList = {
        new CarModel("N 199 X", "Toyota Avanza", "Black", 2019, 100),
        new CarModel("B 15 UL", "Honda Jazz", "Red", 2020, 80),
        new CarModel("L 19 MA", "Toyota Alpard", "Black", 2023, 120),
        new CarModel("N 123 AB", "Honda Civic", "Grey", 2018, 90),
    };
    protected static EmployeeModel[] employeeList = {
        new EmployeeModel(
            UUID.randomUUID().toString().substring(0,8), 
            "Budi Hariadi", 
            "Jl. Mawar Blok Z", 
            "budihariadi@gmail.com", 
            "08123456789", 
            "male", 
            "senior", 
            8000000.0
        ),
        new EmployeeModel(
            UUID.randomUUID().toString().substring(0,8), 
            "Bambang Herlambang", 
            "Jl. Dahlia Blok C", 
            "bambangherlambang@gmail.com", 
            "08987654321", 
            "male", 
            "junior", 
            5000000.0
        ),
        new EmployeeModel(
            UUID.randomUUID().toString().substring(0,8),
            "Siti Aminah", 
            "Jl. Bojongsari Blok E", 
            "sitiaminah123@gmail.com",  
            "08192837465", 
            "female", 
            "female", 
            5000000.0
        )
    };
    protected static CustomerModel[] customerList = {};

    public void displayCarList(){
        for(int i=0; i<carList.length; i++){
            carList[i].displayCar();
        }
    }

    public void displayEmployeeList(){
        for(int i=0; i<employeeList.length; i++){
            employeeList[i].displayEmployee();
        }
    }

    public void displayCustomerList(){
        for(int i=0; i<customerList.length; i++){
            customerList[i].displayCustomer();
        }
    }
}
