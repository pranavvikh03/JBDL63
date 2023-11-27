package AccessSpecifier;

class Student{
      String name = "Pranav";

    private void show(){
        System.out.println(name);
    }
}


class Department extends Student{
    private Department(){};
    public void show1(){
        System.out.println(name);
    }
}
public class Example {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
    }
}
