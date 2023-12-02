package Session4;

class Ticket{
    private int ticketSize = 10;

      synchronized public void bookTicket(int requiredNo){
        if(requiredNo <= ticketSize){
            ticketSize -= requiredNo;
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
            System.out.println(String.format("%d Tickets are booked and remaining are %d", requiredNo,ticketSize));
        }
        else
            System.out.println(String.format("Only %d are available", ticketSize));

    }
}

public class T3{

    public static void main(String[] args) {
        final Ticket t = new Ticket();
        new Thread(){
            public void run(){
                t.bookTicket(6);
            }
        }.start();
        new Thread(){
            public void run(){
                t.bookTicket(6);
            }
        }.start();
    }
}
