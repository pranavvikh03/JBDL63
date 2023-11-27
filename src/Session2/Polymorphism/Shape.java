package Polymorphism;

public class Shape {

    public double findArea(int radius){
        return 3.14 * radius * radius;
    }

    public double findArea(int len, int bre){
        return len * bre;
    }

    public static void main(String[] args) {
        Shape shape = new Shape();

        System.out.println(shape.findArea(20, 30));
    }
}
