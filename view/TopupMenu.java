import controller.Crud;
import java.util.*;

public class TopupMenu {
    public static void DisplayTopupMenu(String[] args, Crud crud){
        Scanner input = new Scanner(System.in);
        System.out.println("\n=========================================");
        System.out.println("MENU TOP-UP");
        System.out.println("=========================================");
        System.out.println("Customer saat ini: ");
        crud.readCustomer(crud.currentCustomer.getCustomerId());
        
        if(crud.currentCustomer.getCustomerId() == "N/A"){
            System.out.println("[Notifikasi: Silahkan membuat akun customer terlebih dahulu]");
        } else {
            System.out.print("\nMasukkan jumlah nominal yang ingin anda top-up: ");
            Double nominal = input.nextDouble();
            crud.currentCustomer.topUpBalance(nominal);
        }
    }
}
