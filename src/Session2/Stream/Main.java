package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10,20,30,40);
        Predicate<Integer> predicate = n ->  n % 20 == 0;
        Stream<Integer> dd = arr.stream();
        Stream<Integer> s = arr.stream().filter( n ->  n % 20 == 0);
        Stream<Integer> s1 = arr.stream().map(n -> n + 10);
        Stream<Integer> s3 = arr.stream().filter( n ->  n % 20 != 0).map(n -> n + 5);
        int result = arr.stream().filter(n ->  n % 20 != 0).reduce(0,(c, e) -> c + e);
        System.out.println(result);
        s3.forEach(n -> System.out.println(n));
    }
}