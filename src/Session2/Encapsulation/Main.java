package Encapsulation;

public class Main {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setName("Rohit");
        emp1.setDepartment("HR");
        emp1.setLocation("Pune");
        emp1.setSalary(50000);
        emp1.setSalary(60000);

        System.out.println(emp1.getSalary());
    }
}