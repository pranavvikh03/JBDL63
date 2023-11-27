package Static;


import java.util.List;

class Student{
    public String dept = "Computer";
    String name;
}
public class Main {
    static{
        System.out.println("static block");
    }
    static int sum = 10;
    public static void main(String[] args) {
        System.out.println("main");
    }
}


