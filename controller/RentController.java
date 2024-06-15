package controller;

import model.CarModel;
import model.EmployeeModel;
import model.TransactionModel;
import util.StringToArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RentController extends AppController {
    public static String rentCar(
        CarModel selectedCar,
        EmployeeModel selectedEmployee,
        int day
    ){
        if(currentCustomer.getCustomerId() == "N/A"){
            System.out.println("\n[Notifikasi: Silahkan membuat akun customer terlebih dahulu]\n");
            return "[Notifikasi: Silahkan membuat akun customer terlebih dahulu]";
        } else {
            double price = selectedCar.getPrice(day) + selectedEmployee.getFee(day);

            if(currentCustomer.spendBalance(price)){
                TransactionModel transaction = new TransactionModel(currentCustomer, selectedEmployee, selectedCar, day);
                transaction.setReturnStatus(false);
                try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(transactionRoute, true))){
                    bfWriter.write(transaction.getStringArray());
                    bfWriter.newLine();
                    System.out.println("\n[Notifikasi: Transaksi berhasil]\n");

                    DataController.deleteCustomer(currentCustomer.getUsername());
                    DataController.postCustomer(currentCustomer);

                    selectedCar.setRentStatus(true);
                    DataController.deleteCar(selectedCar.getNumPlate());
                    DataController.postCar(selectedCar);
                    return "Insert data success";
                } catch (Exception e){
                    return e.getLocalizedMessage();
                }
            } else  {
                System.out.println("Saldo anda tidak cukup, Harga: " + price);
                return "Saldo anda tidak cukup";
            }
        }
    }

    public static String returnCar(
        String numPlate
    ){
        List<TransactionModel> list = getTransactionList();
        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(transactionRoute, false))) {
            for (TransactionModel transaction: list) {
                if(transaction.getCar().getNumPlate().equalsIgnoreCase(numPlate)){
                    transaction.setReturnStatus(true);
                }
                bfWriter.write(transaction.getStringArray());
                bfWriter.newLine();

                transaction.getCar().setRentStatus(false);
                DataController.deleteCar(transaction.getCar().getNumPlate());
                DataController.postCar(transaction.getCar());
            }
            return "Mobil berhasil dikembalikan";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
    public static List<TransactionModel> getTransactionList(){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(transactionRoute));
            String line;
            TransactionModel result;
            List<TransactionModel> list = new ArrayList<>();

            while((line = bfReader.readLine()) != null){
                String[] arr = StringToArray.convert(line);
                result = new TransactionModel(
                        arr[0],
                        DataController.getCustomerById(arr[1]),
                        DataController.getEmployeeById(arr[2]),
                        DataController.getCarByNumplate(arr[3]),
                        Integer.valueOf(arr[4]),
                        Double.valueOf(arr[5]),
                        Boolean.valueOf(arr[6])
                );
                list.add(result);
                result.DisplayTransaction();
            }

            return list;
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
}
