package controller;

import model.CarModel;
import model.EmployeeModel;
import model.CustomerModel;
import util.StringToArray;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class DataController extends AppController {

    public static String postCar(CarModel newCar){
        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(vehicleRoute, true))){
            bfWriter.write(newCar.getStringArray());
            bfWriter.newLine();
            System.out.println("\n[Notifikasi: Mobil baru berhasil dibuat]\n");
            return "Insert data success";
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public static CarModel getCarByNumplate(String numPlate){
        boolean found = false;
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(vehicleRoute));
            String line;
            CarModel result = new CarModel("","", "", 0, 0);

            while((line = bfReader.readLine()) != null){
                if(line.contains(numPlate)){
                    String[] arr = StringToArray.convert(line);
                    result = new CarModel(
                            arr[0],
                            arr[1],
                            arr[2],
                            Integer.valueOf(arr[3]),
                            Double.valueOf(arr[4]),
                            Boolean.valueOf(arr[5])
                    );
                    result.displayCar();
                    found = true;
                }
            }

            if(!found){
                System.out.println("Data Mobil Tidak Ditemukan");
            }

            return result;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new CarModel("","", "", 0, 0);
        }
    }

    public static String putCar(
        String numPlate,
        String carBrand,
        String carColor, 
        int year,
        Double tankCapacity
    ){
        boolean found = false;
        List<CarModel> list = getCarList();

        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(vehicleRoute, false))) {
            for (CarModel car : list) {
                if(car.getNumPlate().equalsIgnoreCase(numPlate)){
                    car.updateCarInfo(numPlate, carBrand, carColor, year, tankCapacity);
                    found = true;
                }
                bfWriter.write(car.getStringArray());
                bfWriter.newLine();
            }

            if(!found){
                System.out.println("\n[Notifikasi: Data mobil tidak ditemukan]\n");
            }
            return "Data berhasil diupdate";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public static String deleteCar(String numPlate) {
        List<CarModel> list = getCarList();

        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(vehicleRoute, false))) {
            for (CarModel car : list) {
                if(car.getNumPlate().equalsIgnoreCase(numPlate)){
                    continue;
                }
                bfWriter.write(car.getStringArray());
                bfWriter.newLine();
            }
            return "Data berhasil dihapus";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public static String postCustomer(CustomerModel newCustomer){
        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(customerRoute, true))){
            bfWriter.write(newCustomer.getStringArray());
            bfWriter.newLine();
            System.out.println("\n[Notifikasi: Customer baru berhasil dibuat]\n");
            return "Insert data success";
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public static CustomerModel getCustomerById(String customerId){
        boolean found = false;
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(customerRoute));
            String line;
            CustomerModel result = new CustomerModel("","", "", 0, "","");

            while((line = bfReader.readLine()) != null){
                if(line.contains(customerId)){
                    String[] arr = StringToArray.convert(line);
                    result = new CustomerModel(
                            arr[0],
                            arr[1],
                            arr[2],
                            Integer.valueOf(arr[3]),
                            arr[4],
                            arr[5],
                            Double.valueOf(arr[6])
                    );
                    result.displayCustomer();
                    found = true;
                }
            }

            if(!found){
                System.out.println("Data Mobil Tidak Ditemukan");
            }

            return result;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new CustomerModel("","", "", 0, "","");
        }
    }

    public static String putCustomer(
        String customerId,
        String name,
        String phoneNum,
        String address,
        String gender
    ){
        boolean found = false;
        List<CustomerModel> list = getCustomerList();

        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(customerRoute, false))) {
            for (CustomerModel customer : list) {
                if(
                        customer.getCustomerId().equalsIgnoreCase(customerId) ||
                        customer.getUsername().equalsIgnoreCase(name)
                ){
                    customer.updateCustomerInfo(name, phoneNum, address, gender);
                    found = true;
                }
                bfWriter.write(customer.getStringArray());
                bfWriter.newLine();
            }

            if(!found){
                System.out.println("\n[Notifikasi: Data customer tidak ditemukan]\n");
            }
            return "Customer berhasil diupdate";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }

    public static String deleteCustomer(String customerId) {
        boolean found = false;
        List<CustomerModel> list = getCustomerList();

        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(customerRoute, false))) {
            for (CustomerModel customer : list) {
                if(
                        customer.getUserID().equalsIgnoreCase(customerId) ||
                        customer.getUsername().equalsIgnoreCase(customerId)
                ){
                    found = true;
                    continue;
                }
                bfWriter.write(customer.getStringArray());
                bfWriter.newLine();
            }

            if(!found){
                System.out.println("\n[Notifikasi: Data customer tidak ditemukan]\n");
            }
            return "Customer berhasil dihapus";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
    

    public static String postEmployee(EmployeeModel newEmployee){
        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(employeeRoute, true))){
            bfWriter.write(newEmployee.getStringArray());
            bfWriter.newLine();
            System.out.println("\n[Notifikasi: Employee baru berhasil dibuat]\n");
            return "Insert data success";
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public static EmployeeModel readEmployee(String employeeId){
        boolean found = false;
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(employeeRoute));
            String line;
            EmployeeModel result = new EmployeeModel("", "", "", "", "", "", "", 0.0);

            while((line = bfReader.readLine()) != null){
                if(line.contains(employeeId)){
                    String[] arr = StringToArray.convert(line);
                    result = new EmployeeModel(
                            arr[0],
                            arr[1],
                            arr[2],
                            arr[3],
                            arr[4],
                            arr[5],
                            arr[6],
                            Double.valueOf(arr[7])
                    );
                    result.displayEmployee();
                    found = true;
                }
            }

            if(!found){
                System.out.println("Data Employee Tidak Ditemukan");
            }

            return result;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new EmployeeModel("", "", "", "", "", "", "", 0.0);
        }
    }

    public static String updateEmployee(
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
        List<EmployeeModel> list = getEmployeeList();

        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(customerRoute, false))) {
            for (EmployeeModel employee : list) {
                if(employee.getEmployeeId().equalsIgnoreCase(employeeId)){
                    employee.updateEmployeeInfo(name, address, eMail, phoneNum, gender, position, salary);
                    found = true;
                }
                bfWriter.write(employee.getStringArray());
                bfWriter.newLine();
            }

            if(!found){
                System.out.println("\n[Notifikasi: Data employee tidak ditemukan]\n");
            }
            return "Employee berhasil diupdate";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }    

    public static String deleteEmployee(String employeeId) {
        boolean found = false;
        List<EmployeeModel> list = getEmployeeList();

        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(customerRoute, false))) {
            for (EmployeeModel employee : list) {
                if(employee.getEmployeeId().equalsIgnoreCase(employeeId)){
                    found = true;
                    continue;
                }
                bfWriter.write(employee.getStringArray());
                bfWriter.newLine();
            }

            if(!found){
                System.out.println("\n[Notifikasi: Data employee tidak ditemukan]\n");
            }
            return "Employee berhasil dihapus";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
}
