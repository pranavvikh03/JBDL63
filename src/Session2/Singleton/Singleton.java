package Singleton;


//Eager Way
class SingletonEager {
    private static SingletonEager singleton = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getSingleton(){
        return singleton;
    }
}

//Lazy Way
class SingletonLazy {
    private static SingletonLazy singleton;

    private SingletonLazy(){}

    public static SingletonLazy getSingleton(){
        if(singleton == null){
            singleton = new SingletonLazy();
            return singleton;
        }
        return singleton;
    }
}

//Lazy Way with Synchronized (Also known as Double check Locking)
class SingletonLazyWithSynchronized {
    private static SingletonLazyWithSynchronized singleton;

    private SingletonLazyWithSynchronized(){
        System.out.println("New Object created");
    }

    public static SingletonLazyWithSynchronized getSingleton(){
        if(singleton == null){
            synchronized(SingletonLazyWithSynchronized.class){
                if(singleton == null){
                    singleton = new SingletonLazyWithSynchronized();
                }
            }
        }
        return singleton;
    }
}

//Enum based Singleton Design
enum SingletonWithEnum{
    INSTANCE;
}
public class Singleton
{
    public static void main(String[] args) {
//        System.out.println("Hello World");
//        SingletonEager s1 = SingletonEager.getSingleton();
//        SingletonEager s2 = SingletonEager.getSingleton();
//         System.out.println(s1.hashCode());
//         System.out.println(s2.hashCode());

//         SingletonLazy s1 = SingletonLazy.getSingleton();
//         SingletonLazy s2 = SingletonLazy.getSingleton();
//         System.out.println(s1.hashCode());
//         System.out.println(s2.hashCode());

         Thread t1 = new Thread(new Runnable(){
             public void run(){
                 SingletonLazyWithSynchronized s1 = SingletonLazyWithSynchronized.getSingleton();
             }
         });

         Thread t2 = new Thread(new Runnable(){
             public void run(){
                 SingletonLazyWithSynchronized s2 = SingletonLazyWithSynchronized.getSingleton();
             }
         });
         t1.start();
         t2.start();

        SingletonWithEnum s1 = SingletonWithEnum.INSTANCE;
        SingletonWithEnum s2 = SingletonWithEnum.INSTANCE;
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

