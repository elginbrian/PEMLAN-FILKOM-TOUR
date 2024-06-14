package model;

public class EmployeeModel extends UserModel{
    private String employeeID = super.getUserID();
    private String name = super.getUsername();
    private String address = "undecided";
    private String eMail = "undecided";
    private String phoneNum = "undecided";
    private String gender = "undecided";
    private String position = "undecided";
    private Double salary = 0.0;

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

    public EmployeeModel(String userID, String username, String password, String type){
        super(userID, username, password, type);
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
