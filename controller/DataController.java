package controller;

import model.CarModel;
import model.EmployeeModel;
import model.CustomerModel;;

public class DataController extends AppController {

    public void postCar(CarModel newCar){
        if(userState.equals("employee")){



            System.out.println("\n[Notifikasi: Mobil baru berhasil dibuat]\n");
        } else {
            System.out.println("\n[Notifikasi: Mobil baru gagal dibuat]\n");
        }
    }

    public CarModel getCarByNumplate(String numPlate){
        boolean found = false;
        CarModel car = null;



        if(!found){
            System.out.println("\n[Notifikasi: Data mobil tidak ditemukan]\n");
        }
        return car;
    }

    public void putCar(
        String numPlate,
        String carBrand,
        String carColor, 
        int year,
        Double tankCapacity
    ){
        if(userState.equals("employee")){
            boolean found = false;



            if(!found){
                System.out.println("\n[Notifikasi: Data mobil tidak ditemukan]\n");
            }
        }
    }

    public void deleteCar(String numPlate) {
        if (userState.equals("employee")) {



        }
    }

    public void postCustomer(CustomerModel newCustomer){

    }

    public void getCustomerById(String customerId){
        boolean found = false;


        if(!found){
            System.out.println("\n[Notifikasi: Data customer tidak ditemukan]\n");
        }
    }

    public void putCustomer(
        String customerId,
        String name,
        String phoneNum,
        String address,
        String gender
    ){
        boolean found = false;


        if(!found){
            System.out.println("\n[Notifikasi: Data customer tidak ditemukan]\n");
        }
    }

    public void deleteCustomer(String customerId) {


    }
    

    public void createEmployee(EmployeeModel newEmployee){
        if(userState.equals("employee")){



        }
    }

    public EmployeeModel readEmployee(String employeeId){
        boolean found = false;
        EmployeeModel employee = null;



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



            if(!found){
                System.out.println("\n[Notifikasi: Data employee tidak ditemukan]\n");
            }
        }
    }    

    public void deleteEmployee(String employeeId) {
        if (userState.equals("employee")) {

        }
    }
}
