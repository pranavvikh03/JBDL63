// 2. By implementing Runnable interface
public class T2 implements Runnable {

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Thread Name:"+Thread.currentThread().getName()+" "+i);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
            }
        }
        System.out.println("State is : "+ Thread.currentThread().getState());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getPriority());
        Thread t = new Thread(new T2());
        Thread t2 = new Thread(new T2());
        t2.setPriority(Thread.MAX_PRIORITY);
        t.setPriority(3);
        t2.setName("Thread class 2");
        t2.start();
        t.start();

        Thread.sleep(1000);
        System.out.println(t2.isAlive());




    }
}
