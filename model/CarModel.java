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

    private double calculatePrice(String carBrand, int year, double tankCapacity, boolean isDiesel){
        // Misalnya, kita akan menghitung harga berdasarkan tahun dan kapasitas tangki
        double basePrice = 100; // Harga dasar
        double yearMultiplier = 0.95; // Pengurang harga setiap tahun
        double tankCapacityMultiplier = 0.05; // Penambahan harga setiap liter kapasitas tangki

        // Hitung harga dasar berdasarkan merek mobil
        if (carBrand.equals("Toyota")) {
            basePrice += 50;
        } else if (carBrand.equals("Honda")) {
           basePrice += 40;
        } else {
            basePrice += 30;
        }

        // Hitung harga berdasarkan tahun
        int currentYear = 2024; // Tahun sekarang 
        int age = currentYear - year;
        basePrice *= Math.pow(yearMultiplier, age);

        // Hitung harga berdasarkan kapasitas tangki
        basePrice += tankCapacity * tankCapacityMultiplier;

        // Jika mobil menggunakan diesel, tambahkan biaya tambahan
        if (isDiesel) {
            basePrice += 20;
        }
        return basePrice;
    }

    public double getPrice(int day) {
        double dailyRate = 50; // Tarif harian 
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
        System.out.println("Rating        : " + rating);
        System.out.println("Fuel Type     : " + (isDiesel ? "Diesel" : "Gasoline"));
        System.out.println("Rented Status : " + (isRented ? "Rented" : "Available"));
        System.out.println("------------------------------------------");
    }
}

