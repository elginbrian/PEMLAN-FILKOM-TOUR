package controller;

import model.CarModel;
import model.CustomerModel;
import model.EmployeeModel;
import util.StringToArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    protected static final String vehicleRoute  = "data/VehicleTable.txt";
    protected static final String customerRoute = "data/CustomerTable.txt";
    protected static final String employeeRoute = "data/EmployeeTable.txt";
    protected static final String authRoute     = "data/UserTable.txt";

    public static String userState = "customer";
    public static CustomerModel currentCustomer = new CustomerModel("N/A", "N/A", "N/A", 0, "N/A", "N/A");

    public static List<CarModel> getCarList(){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(vehicleRoute));
            String line;
            CarModel result;
            List<CarModel> list = new ArrayList<CarModel>();

            while((line = bfReader.readLine()) != null){
                String[] arr = StringToArray.convert(line);
                result = new CarModel(
                        arr[0],
                        arr[1],
                        arr[2],
                        Integer.valueOf(arr[3]),
                        Double.valueOf(arr[4]),
                        Boolean.valueOf(arr[5])
                );
                list.add(result);
                result.displayCar();
            }

            return list;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ArrayList<CarModel>();
        }
    }

    public static List<EmployeeModel> getEmployeeList(){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(employeeRoute));
            String line;
            EmployeeModel result;
            List<EmployeeModel> list = new ArrayList<EmployeeModel>();

            while((line = bfReader.readLine()) != null){
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
                list.add(result);
                result.displayEmployee();
            }

            return list;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ArrayList<EmployeeModel>();
        }
    }

    public static List<CustomerModel> getCustomerList(){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(customerRoute));
            String line;
            CustomerModel result;
            List<CustomerModel> list = new ArrayList<>();

            while((line = bfReader.readLine()) != null){
                String[] arr = StringToArray.convert(line);
                result = new CustomerModel(
                        arr[0],
                        arr[1],
                        arr[2],
                        Integer.valueOf(arr[3]),
                        arr[4],
                        arr[5]
                );
                result.displayCustomer();
                list.add(result);
            }

            return list;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
}
