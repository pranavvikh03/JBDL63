import java.util.regex.Pattern;

//1. By extending Thread Class
public class T1 extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }
        System.out.println("State is : "+ Thread.currentThread().getState());
    }

    public static void main(String[] args) throws Exception{
//        T1 t1 = new T1();
//        System.out.println("State is : "+ t1.getState());
//        t1.start(); // It is used to start method
//        Thread.sleep(1000);
//        System.out.println("State is : "+ t1.getState());

        T1 t1 = new T1();
        T1 t2 = new T1();

        T1 t3 = new T1();
        T1 t4 = new T1();

        t2.start();
        t2.setDaemon(true);
        t1.start();
        System.out.println("Thread Name: "+Thread.currentThread().getName());
        t1.join();
        System.out.println("isalive status: "+t1.isAlive());
//
//        t2.start();
//        System.out.println("Thread Name: "+Thread.currentThread().getName());
//        t2.join();
//
//        t3.start();
//        System.out.println("Thread Name: "+Thread.currentThread().getName());
//        t3.join();
//
//        t4.start();
//        System.out.println("Thread Name: "+Thread.currentThread().getName());
//        t4.join();


    }
}
