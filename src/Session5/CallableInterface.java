package Session5;

import java.util.Random;
import java.util.concurrent.*;

public class CallableInterface implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(4000);
        return new Random().nextInt();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<Integer> submit = service.submit(new CallableInterface());
        System.out.println("hello world");
        Integer i = submit.get(2, TimeUnit.SECONDS);
        System.out.println("Random Number:"+i);
    }
}
