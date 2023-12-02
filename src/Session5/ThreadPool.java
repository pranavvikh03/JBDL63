package Session5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Id:"+Thread.currentThread().getId());
    }
}
public class ThreadPool {
    public static void main(String[] args) throws Exception {
//        for(int i = 0; i < 10; i++){
//            new Thread(()->{
//                System.out.println("Thread Name : "+ Thread.currentThread().getName());
//            }).start();
//        }

        ExecutorService service = Executors.newFixedThreadPool(10);
        ExecutorService service1 = Executors.newCachedThreadPool();
        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(10);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 100; i++){
            service.execute(new Task());
        }
        long endTime = System.currentTimeMillis();
        Thread.sleep(2000);
        System.out.println("Total time Required in milliseconds:"+ (endTime - startTime));
    }
}



/*
* 1000 threads parallelly
* t1 t2 t3 t4 .... t10
*
*
* Queue FIFO Producer Consumer push into the queue {}
* {
* 10
* }
* */
