package Session5;
public class VolatileKeyword {
    private static volatile int volatileInteger = 0; // Resource

    public static void main(String[] args)
    {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override public void run()
        {
            int local_value = volatileInteger; // 0
            while (local_value < 5) {
                if (local_value != volatileInteger) {
                    System.out.println("Got Change for volatileInteger :"+volatileInteger);
                    local_value = volatileInteger;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override public void run()
        {
            int local_value = volatileInteger;
            while (volatileInteger < 5) {
                System.out.println("Incrementing MY_INT to "+ local_value);
                volatileInteger = ++local_value;
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
