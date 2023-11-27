class Bank{
    private int moneyInAccount = 10000;

    synchronized public void withDraw(int amount){
        if(this.moneyInAccount < amount){
            System.out.println("Insufficient fund in account. wait till deposit");
            try{
                wait();
            }
            catch (Exception e){}
        }
        this.moneyInAccount -= amount;
        System.out.println("Withdrawl is done");
    }

    synchronized public void deposit(int amount){
        this.moneyInAccount += amount;
        System.out.println("Deposit is done");
        notify();
    }
}
public class Interthread {
    public static void main(String[] args) {
        final Bank t = new Bank();
        new Thread(){
            public void run(){
                t.withDraw(12000);
            }
        }.start();
        new Thread(){
            public void run(){
                t.deposit(3000);
            }
        }.start();
    }
}