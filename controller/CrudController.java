package controller;

import model.CarModel;
import model.EmployeeModel;
import model.CustomerModel;;

public class CrudController extends FilkomTourData {

    public void createCar(CarModel newCar){
        if(userState.equals("employee")){
            CarModel[] newCarList = new CarModel[this.carList.length + 1];
            for(int i = 0; i < this.carList.length; i++){
                newCarList[i] = this.carList[i];
            }
            newCarList[newCarList.length - 1] = newCar;
            this.carList = newCarList;
            System.out.println("\n[Notifikasi: Mobil baru berhasil dibuat]\n");
        } else {
            System.out.println("\n[Notifikasi: Mobil baru gagal dibuat]\n");
        }
    }

    public CarModel readCar(String numPlate){
        boolean found = false;
        CarModel car = null;

        for(int i = 0; i < this.carList.length; i++){
            if(this.carList[i].getNumPlate() == numPlate){
                this.carList[i].displayCar();
                car = this.carList[i];
                found = true;
            }
        }
        if(!found){
            System.out.println("\n[Notifikasi: Data mobil tidak ditemukan]\n");
        }
        
        return car;
    }

    public void updateCar(
        String numPlate,
        String carBrand,
        String carColor, 
        int year,
        Double tankCapacity
    ){
        if(userState.equals("employee")){
            boolean found = false;
            for(int i = 0; i < this.carList.length; i++){
                if(this.carList[i].getNumPlate() == numPlate){
                    this.carList[i].updateCarInfo(numPlate, carBrand, carColor, year, tankCapacity);
                    found = true;
                }
            }
            if(!found){
                System.out.println("\n[Notifikasi: Data mobil tidak ditemukan]\n");
            }
        }
    }

    public void deleteCar(String numPlate){
        if(userState.equals("employee")){
            CarModel[] newCarList = new CarModel[this.carList.length + 1];
            for(int i=0; i<newCarList.length; i++){
                if(this.carList[i].getNumPlate() == numPlate){
                    continue;
                }
                newCarList[i] = this.carList[i];
            }
            this.carList = newCarList;
        }
    }

    public void createCustomer(CustomerModel newCustomer){
        CustomerModel[] newCustomerList = new CustomerModel[this.customerList.length + 1];
        for(int i = 0; i < this.customerList.length; i++){
            newCustomerList[i] = this.customerList[i];
        }
        newCustomerList[newCustomerList.length - 1] = newCustomer;
        this.customerList = newCustomerList;

        if(userState == "customer"){
            currentCustomer = newCustomer;
        }
    }

    public void readCustomer(String customerId){
        boolean found = false;
        for(int i = 0; i < customerList.length; i++){
            if(customerList[i].getCustomerId() == customerId){
                customerList[i].displayCustomer();
                found = true;
            }
        }
        if(!found){
            System.out.println("\n[Notifikasi: Data customer tidak ditemukan]\n");
        }
    }

    public void updateCustomer(
        String customerId,
        String name,
        String phoneNum,
        String address,
        String gender
    ){
        boolean found = false;
        for(int i = 0; i < customerList.length; i++){
            if(customerList[i].getCustomerId() == customerId){
                customerList[i].updateCustomerInfo(name, phoneNum, address, gender);
                found = true;
            }
        }
        if(!found){
            System.out.println("\n[Notifikasi: Data customer tidak ditemukan]\n");
        }
    }

    public void deleteCustomer(String customerId){
        CustomerModel[] newCustomerList = new CustomerModel[this.customerList.length + 1];
        for(int i=0; i<newCustomerList.length; i++){
            if(this.customerList[i].getCustomerId() == customerId){
                continue;
            }
            newCustomerList[i] = this.customerList[i];
        }
        this.customerList = newCustomerList;    
    }

    public void createEmployee(EmployeeModel newEmployee){
        if(userState.equals("employee")){
            EmployeeModel[] newEmployeeList = new EmployeeModel[this.employeeList.length + 1];
            for(int i = 0; i < this.employeeList.length; i++){
                newEmployeeList[i] = this.employeeList[i];
            }
            newEmployeeList[newEmployeeList.length - 1] = newEmployee;
            this.employeeList = newEmployeeList;
        }
    }

    public EmployeeModel readEmployee(String employeeId){
        boolean found = false;
        EmployeeModel employee = null;
        for(int i = 0; i < employeeList.length; i++){
            if(employeeList[i].getEmployeeId() == employeeId){
                employeeList[i].displayEmployee();
                found = true;
                employee = employeeList[i];
            }
        }
        if(!found){
            System.out.println("\n[Notifikasi: Data employee tidak ditemukan]\n");
        }
        return employee;
    }

    public void updateEmployee(
        String employeeId, 
        String name, 
        String address, 
        String eMail, 
        String phoneNum, 
        String gender, 
        String position, 
        Double salary
    ){
        boolean found = false;
        if(userState.equals("employee")){
            for(int i = 0; i < employeeList.length; i++){
                if(employeeList[i].getEmployeeId() == employeeId){
                    employeeList[i].updateEmployeeInfo(name, address, eMail, phoneNum, gender, position, salary);
                    found = true;
                }
            }
            if(!found){
                System.out.println("\n[Notifikasi: Data employee tidak ditemukan]\n");
            }
        }
    }    

    public void deleteEmployee(String employeeId){
        if(userState.equals("employee")){
            EmployeeModel[] newEmployeeList = new EmployeeModel[this.employeeList.length + 1];
            for(int i=0; i<newEmployeeList.length; i++){
                if(this.employeeList[i].getEmployeeId() == employeeId){
                    continue;
                }
                newEmployeeList[i] = this.employeeList[i];
            }
            this.employeeList = newEmployeeList;
        }
    }

    @Override
    public void displayCustomerList(){
        if(userState.equals("employee")){
            super.displayCustomerList();
        }
    }
}
