package controller;

import model.CarModel;
import model.EmployeeModel;

public class RentalController {
    private CarModel[] carList;
    private EmployeeModel[] employeeList;
    // private CustomerModel[] customerList;

    public RentalController(){}

    public void createCar(CarModel newCar){

    }

    public void readCar(String numPlate){

    }

    public void updateCar(
        String numPlate,
        String carBrand,
        String carColor, 
        int year,
        Double tankCapacity
    ){

    }

    public void deleteCar(String numPlate){

    }

    public void createCustomer(){

    }

    public void readCustomer(String customerId){

    }

    public void updateCustomer(
        String name,
        String phoneNum,
        String address,
        String gender
    ){

    }

    public void deleteCustomer(){

    }

    public void rentCar(
        String customerId,
        String numPlate,
        int day
    ){

    }

    public void returnCar(
        String customerId,
        String numPlate,
        Double rateCar,
        Double rateEmployee
    ){

    }
}
