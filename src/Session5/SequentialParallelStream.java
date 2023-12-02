package Session5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequentialParallelStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H");

        long startTime = System.currentTimeMillis();
        list.stream().forEach(System.out::print);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Required :"+(endTime - startTime));

        long startTime1 = System.currentTimeMillis();
        list.parallelStream().forEach(System.out::print);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time Required :"+(endTime1 - startTime1));
    }
}
