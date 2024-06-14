package model;

public class EmployeeModel extends UserModel{
    private String employeeID = super.getUserID();
    private String name;
    private String address;
    private String eMail;
    private String phoneNum;
    private String gender;
    private String position;
    private Double salary;

    public EmployeeModel(String employeeID, String name, String address, String eMail, String phoneNum, String gender, String position, Double salary){
        super(name, "employee", "employee");
        this.name=name;
        this.address=address;
        this.eMail=eMail;
        this.phoneNum=phoneNum;
        this.gender=gender;
        this.position=position;
        this.salary=salary;
    }

    public void updateEmployeeInfo(String name, String address, String eMail, String phoneNum, String gender, String position, Double salary){
        this.name=name;
        this.address=address;
        this.eMail=eMail;
        this.phoneNum=phoneNum;
        this.gender=gender;
        this.position=position;
        this.salary=salary;
    }

    public double getFee(int day){
        return Math.round((salary / 90) * day);
    }

    public String getEmployeeId(){
        return employeeID;
    }

    public void displayEmployee(){
        System.out.println("employeeID : "+employeeID);
        System.out.println("name       : "+name);
        System.out.println("address    : "+address);
        System.out.println("eMail      : "+eMail);
        System.out.println("phoneNum   : "+phoneNum);
        System.out.println("gender     : "+gender);
        System.out.println("position   : "+position);
        System.out.println("salary     : "+salary);
        System.out.println("------------------------------------------");
    }
}
