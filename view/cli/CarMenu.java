package cli;

import controller.DataController;
import model.CarModel;

import java.util.*;

public class CarMenu {
    public static void DisplayCarMenu(String[] args, DataController crud) {
        Scanner input = new Scanner(System.in);
        boolean continueLoop = true;

        if(crud.userState == "employee"){
            while(continueLoop){
                System.out.println("\n=========================================");
                System.out.println("DATA MOBIL");
                System.out.println("==========================================");
                crud.getCarList();
    
                System.out.println("\nPilih tindakan yang ingin anda lakukan!");
                System.out.println("1. Create Mobil");
                System.out.println("2. Read Mobil");
                System.out.println("3. Update Mobil");
                System.out.println("4. Delete Mobil");
                System.out.println("5. Cancel");
    
                System.out.print("\nMasukkan pilihan anda: ");
                int option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 1:
                        System.out.print("Masukkan plat nomor : ");
                        String numPlate     = input.nextLine(); 
                        System.out.print("Masukkan brand      : ");
                        String carBrand     = input.nextLine(); 
                        System.out.print("Masukkan color      : ");
                        String carColor     = input.nextLine(); 
                        System.out.print("Masukkan tahun      : ");
                        int year            = input.nextInt(); 
                        System.out.print("Masukkan kapasitas  : ");
                        double tankCapacity = input.nextDouble();
    
                        CarModel newCar     = new CarModel(numPlate, carBrand, carColor, year, tankCapacity);
                        crud.postCar(newCar);
                        break;
                    case 2:
                        System.out.print("Masukkan plat nomor : ");
                        numPlate     = input.nextLine(); 
    
                        crud.getCarByNumplate(numPlate);
                        break;
                    case 3:
                        System.out.print("Masukkan plat nomor : ");
                        numPlate     = input.nextLine(); 
                        System.out.print("Masukkan brand      : ");
                        carBrand     = input.nextLine(); 
                        System.out.print("Masukkan color      : ");
                        carColor     = input.nextLine(); 
                        System.out.print("Masukkan tahun      : ");
                        year         = input.nextInt(); 
                        System.out.print("Masukkan kapasitas  : ");
                        tankCapacity = input.nextDouble();
    
                        crud.putCar(numPlate, carBrand, carColor, year, tankCapacity);
                        break;
                    case 4:
                        System.out.print("Masukkan plat nomor : ");
                        numPlate     = input.nextLine(); 
                        
                        crud.deleteCar(numPlate);
                        break;
                    case 5:
                        continueLoop = false;
                        break;
                }
            }

        } else {
            System.out.println("\n=========================================");
            System.out.println("DATA MOBIL");
            System.out.println("==========================================");
            crud.getCarList();
        }
    }
}
