package model;

import java.util.Arrays;

public class CarModel {
   private String numPlate;
   private String carBrand;
   private String carColor;
   private int year;
   private Double tankCapacity;
   private Boolean isRented = false;

   public CarModel(String numPlate, String carBrand, String carColor, int year, double tankCapacity) {
        this.numPlate = numPlate;
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.year = year;
        this.tankCapacity = tankCapacity;
   }

   public CarModel(String numPlate, String carBrand, String carColor, int year, double tankCapacity, boolean isRented){
       this.numPlate = numPlate;
       this.carBrand = carBrand;
       this.carColor = carColor;
       this.year = year;
       this.tankCapacity = tankCapacity;
       this.isRented = isRented;
   }

    public String getStringArray(){
        String[] arr = {numPlate, carBrand, carColor, String.valueOf(year), tankCapacity.toString(), isRented.toString()};
        String stringArr = Arrays.toString(arr);

        return stringArr;
    }

    public void updateCarInfo(String numPlate, String carBrand, String carColor, int year, double tankCapacity) {
        this.numPlate = numPlate;
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.year = year;
        this.tankCapacity = tankCapacity;
    }
    
    public void setRentStatus(boolean isRented){
        this.isRented=isRented;
    }

    public boolean getRentStatus(){
        return isRented;
    }

    public String getNumPlate(){
        return numPlate;
    }

    public String getCarBrand() { return carBrand; }

    public double getPrice(int day) {
        double dailyRate = 50000; // Tarif harian 
        double discountRate = 0.9; // Tarif diskon untuk sewa lebih dari 7 hari 
        
        // Hitung harga total berdasarkan jumlah hari
        double totalPrice = dailyRate * day;
    
        // Berikan diskon jika menyewa lebih dari 7 hari
        if (day > 7) {
            totalPrice *= discountRate;
        }
    
        return totalPrice;
    }

    public void displayCar(){
        System.out.println("Number Plate  : " + numPlate);
        System.out.println("Brand         : " + carBrand);
        System.out.println("Color         : " + carColor);
        System.out.println("Year          : " + year);
        System.out.println("Tank Capacity : " + tankCapacity);
        System.out.println("Rented Status : " + (isRented ? "Rented" : "Available"));
        System.out.println("------------------------------------------");
    }
}

