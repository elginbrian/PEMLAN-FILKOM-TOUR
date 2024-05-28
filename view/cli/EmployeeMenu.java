package cli;

import java.util.*;
import controller.CrudController;
import model.EmployeeModel;

public class EmployeeMenu {
    public static void DisplayEmployeeMenu(String[] args, CrudController crud) {
        Scanner input = new Scanner(System.in);
        boolean continueLoop = true;

        while(continueLoop) {
            System.out.println("\n=========================================");
            System.out.println("DATA KARYAWAN");
            System.out.println("=========================================");
            crud.displayEmployeeList();

            System.out.println("\nPilih tindakan yang ingin anda lakukan!");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Cancel");

            System.out.print("\nMasukkan pilihan anda: ");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    String employeeID = UUID.randomUUID().toString().substring(0,8);
                    System.out.println("Masukkan name         : ");
                    String name       = input.nextLine();
                    System.out.println("Masukkan address      : ");
                    String address    = input.nextLine();
                    System.out.println("Masukkan email        : ");
                    String eMail      = input.nextLine();
                    System.out.println("Masukkan phone number : ");
                    String phoneNum   = input.nextLine();
                    System.out.println("Masukkan gender       : ");
                    String gender     = input.nextLine();
                    System.out.println("Masukkan position     : ");
                    String position   = input.nextLine();
                    System.out.println("Masukkan salary       : ");
                    Double salary     = input.nextDouble();

                    EmployeeModel newEmployee = new EmployeeModel(employeeID, name, address, eMail, phoneNum, gender, position, salary);
                    crud.createEmployee(newEmployee);
                    break;

                case 2:
                    System.out.println("Masukkan employee id  : ");
                    employeeID = input.nextLine();
                    crud.readEmployee(employeeID);
                    break;

                case 3:
                    System.out.println("Masukkan employee id  : ");
                    employeeID = input.nextLine();
                    System.out.println("Masukkan name         : ");
                    name       = input.nextLine();
                    System.out.println("Masukkan address      : ");
                    address    = input.nextLine();
                    System.out.println("Masukkan email        : ");
                    eMail      = input.nextLine();
                    System.out.println("Masukkan phone number : ");
                    phoneNum   = input.nextLine();
                    System.out.println("Masukkan gender       : ");
                    gender     = input.nextLine();
                    System.out.println("Masukkan position     : ");
                    position   = input.nextLine();
                    System.out.println("Masukkan salary       : ");
                    salary     = input.nextDouble();
                    crud.updateEmployee(employeeID, name, address, eMail, phoneNum, gender, position, salary);
                    break;

                case 4:
                    System.out.println("Masukkan employee id  : ");
                    employeeID = input.nextLine();
                    crud.deleteEmployee(employeeID);
                    break;

                case 5:
                    continueLoop = false;
                    break;
            }
        }
    }
}
