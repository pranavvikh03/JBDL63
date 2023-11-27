package Polymorphism;


class A{
    public void show(int a){
        System.out.println("I am Class A:"+a);
    }
}

class B extends A{
    @Override
    public void show(int a){
        System.out.println("I am class B:"+a);
    }
}
public class Runtime {
    public static void main(String[] args) {
        B a = new B();
        a.show(10);
    }
}
