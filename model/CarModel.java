package model;

public class CarModel {
   private String numPlate;
   private String carBrand;
   private String carColor;
   private int year;
   private Double tankCapacity;
   private Double rating = 0.0;
   private Boolean isDiesel = false;
   private Boolean isRented = false;

   public CarModel(String numPlate, String carBrand, String carColor, int year, double tankCapacity) {
        this.numPlate = numPlate;
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.year = year;
        this.tankCapacity = tankCapacity;
    }

    public void updateCarInfo(String numPlate, String carBrand, String carColor, int year, double tankCapacity) {
        this.numPlate = numPlate;
        this.carBrand = carBrand;
        this.carColor = carColor;
        this.year = year;
        this.tankCapacity = tankCapacity;
    }

    public void setFuelType(boolean isDiesel){
        this.isDiesel=isDiesel;
    }
    
    public void setRentStatus(boolean isRented){
        this.isRented=isRented;
    }

    public void setRate(Double rating){
        this.rating=rating;
    }

    public boolean getRentStatus(){
        return isRented;
    }

    public String getNumPlate(){
        return numPlate;
    }

    private double calculatePrice(String carBrand, int year, double tankCapacity, double isDiesel){
        //rumusnya gimana bang
        return 0.0;
    }

    public double getPrice(int day){
        //rumusnya gimana bang
        return 0.0;
    }

    public void displayCar(){
        System.out.println("Car Information:");
        System.out.println("Number Plate: " + numPlate);
        System.out.println("Brand: " + carBrand);
        System.out.println("Color: " + carColor);
        System.out.println("Year: " + year);
        System.out.println("Tank Capacity: " + tankCapacity);
        System.out.println("Rating: " + rating);
        System.out.println("Fuel Type: " + (isDiesel ? "Diesel" : "Gasoline"));
        System.out.println("Rented Status: " + (isRented ? "Rented" : "Available"));
    }
}

