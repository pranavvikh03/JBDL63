package ExceptionHandling;

import java.sql.SQLClientInfoException;

public class Main {

    public static void ageChecked(int age) throws AgeLimitException{
            if (age < 18)
                throw new AgeLimitException("Age should be less than 18");

    }
    public static void main(String[] args) {

        int divide = 10;
        int r = 0;
        try {
            ageChecked(12);
            r = 20 / divide;
        }
        catch(ArithmeticException e){
            divide = 10;
            r = 20 / divide;
        }
        catch (AgeLimitException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("System level error");
        }
        finally{
            System.out.println("Finally block");
        }
        System.out.println(r);
    }
}
