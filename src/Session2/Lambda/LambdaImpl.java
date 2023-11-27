package Lambda;

@FunctionalInterface
interface Operation{
    void calc(int a, int b);
    default void show(){
        System.out.println("hello");
    }
}

interface Ops{
    int calc(int a, int b);
}
class A implements Operation{

    @Override
    public void calc(int a, int b) {
        System.out.println(a);
    }
}

public class LambdaImpl {
    public static void main(String[] args) {
        A a = new A();
        a.calc(10, 20);
        Operation operation = new Operation() {
            @Override
            public void calc(int a, int b) {
                System.out.println(a);
            }
        };
        int na = 90;
        Operation operation1 = (am, aa) -> {
            int re = 20;
            System.out.println(re);
            re = 30;
            System.out.println(re);
        };

        Ops ops = (aa, b) -> aa+b;

//        operation.calc(20, 20);
        operation1.calc(30, 20);
    }
}
