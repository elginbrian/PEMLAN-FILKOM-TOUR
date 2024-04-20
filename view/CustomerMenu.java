import controller.Crud;
import java.util.*;
import model.CustomerModel;

public class CustomerMenu {
    public static void DisplayCustomerMenu(String[] args, Crud crud) {
        Scanner input = new Scanner(System.in);
        boolean continueLoop = true;
        
        if(crud.userState == "employee"){
            while(continueLoop){
                System.out.println("\n=========================================");
                System.out.println("DATA CUSTOMER");
                System.out.println("=========================================");
                crud.displayCustomerList();
    
                System.out.println("\nPilih tindakan yang ingin anda lakukan!");
                System.out.println("1. Create Customer");
                System.out.println("2. Read Customer");
                System.out.println("3. Update Customer");
                System.out.println("4. Delete Customer");
                System.out.println("5. Cancel");
    
                System.out.print("\nMasukkan pilihan anda: ");
                int option = input.nextInt();
    
                switch (option) {
                    case 1:
                        String customerID = UUID.randomUUID().toString().substring(0,8);
                        System.out.print("Masukkan name         : ");
                        String name       = input.nextLine();
                        System.out.print("Masukkan phone number : ");
                        String phoneNum   = input.nextLine();
                        System.out.print("Masukkan age          : ");
                        int age           = input.nextInt();
                        System.out.print("Masukkan address      : ");
                        String address    = input.nextLine();
                        System.out.print("Masukkan gender       : ");
                        String gender     = input.nextLine();
    
                        CustomerModel newCustomer = new CustomerModel(customerID, name, phoneNum, age, address, gender);
                        crud.createCustomer(newCustomer);
                        break;
    
                    case 2:
                        System.out.print("Masukkan customer id  : ");
                        customerID = input.nextLine();
                        crud.readCustomer(customerID);
                        break;
    
                    case 3:
                        System.out.print("Masukkan customer id  : ");
                        customerID = input.nextLine();
                        System.out.print("Masukkan name         : ");
                        name       = input.nextLine();
                        System.out.print("Masukkan phone number : ");
                        phoneNum   = input.nextLine();
                        System.out.print("Masukkan age          : ");
                        age        = input.nextInt();
                        System.out.print("Masukkan address      : ");
                        address    = input.nextLine();
                        System.out.print("Masukkan gender       : ");
                        gender     = input.nextLine();
    
                        crud.updateCustomer(customerID, name, phoneNum, address, gender);
                        break;
    
                    case 4:
                        System.out.print("Masukkan customer id  : ");
                        customerID = input.nextLine();
                        crud.deleteCustomer(customerID);
                        break;
    
                    case 5:
                        continueLoop = false;
                        break;
                }
            }
        } else {
            System.out.println("\n=========================================");
            System.out.println("DATA CUSTOMER");
            System.out.println("=========================================");
            System.out.println("Current Customer");
            crud.readCustomer(crud.currentCustomer.getCustomerId());

            System.out.print("Ingin membuat akun baru? (y/n): ");
            String confirm = input.nextLine();
            if(confirm.equalsIgnoreCase("y")){
                System.out.println("\n=========================================");
                String customerID = UUID.randomUUID().toString().substring(0,8);
                System.out.print("Masukkan name         : ");
                String name       = input.nextLine();
                System.out.print("Masukkan phone number : ");
                String phoneNum   = input.nextLine();
                System.out.print("Masukkan age          : ");
                int age           = input.nextInt();
                input.nextLine();
                System.out.print("Masukkan address      : ");
                String address    = input.nextLine();
                System.out.print("Masukkan gender       : ");
                String gender     = input.nextLine();
        
                CustomerModel newCustomer = new CustomerModel(customerID, name, phoneNum, age, address, gender);
                crud.createCustomer(newCustomer);
            }
        }
    }
}
