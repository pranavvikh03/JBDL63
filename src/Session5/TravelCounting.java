package Session5;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TravelCounter implements Runnable{
    int count;

    synchronized void increment(){
        count++;
    }

    @Override
    public void run() {
        increment();
    }

    @Override
    public String toString() {
        return "TravelCounter{" +
                "count=" + count +
                '}';
    }
}

public class TravelCounting{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        TravelCounter travelCounter = new TravelCounter();
        for(int i = 0; i < 10000; i++){
            executorService.submit(travelCounter);
        }
//        List<Runnable> remaining = executorService.shutdownNow();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Visitors:"+travelCounter.count);
//        System.out.println("Total Remeaning:"+remaining.size());
        System.out.println(executorService.isTerminated());
        if(executorService.isTerminated()){
            System.out.println("Total Visitors:"+travelCounter.count);
        }
    }
}
