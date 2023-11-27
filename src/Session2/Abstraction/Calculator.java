package Abstraction;


import java.util.Scanner;

//interface Operation{
//    int calc(int a, int b);
//}

abstract class Operation{
    abstract int calc(int a, int b);
}

class Addition extends Operation{

    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}


class Subtraction extends Operation{

    @Override
    public int calc(int a, int b) {
        return Math.abs(a - b);
    }
}

class Multiplication extends Operation{

    @Override
    public int calc(int a, int b) {
        return a * b;
    }
}
//Overriding:When child class provides another/new implementation for parent class method then it is overriding
//method overriding parameter size and name should be same just different is in implementation
//
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        ch = sc.nextInt();
        Operation ops = null;
        if(ch == 1){
            ops = new Addition();
            System.out.println(ops.calc(10, 20));
        }
        else if(ch == 2){
            ops = new Subtraction();
            System.out.println(ops.calc(10, 20));
        }
        else if(ch == 3){
            ops = new Multiplication();
            System.out.println(ops.calc(10, 20));
        }
    }
}
