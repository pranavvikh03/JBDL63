package Session5;

import java.util.ArrayList;
import java.util.List;

class Students<T>{
    T var;
    Students(T var){
        this.var = var;
    }

    void show(){
        System.out.println(String.format("Current value is %s and its type is %s", this.var, this.var.getClass().getTypeName()));
    }
}
public class Generics {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        Integer i = list.get(0);
        System.out.println(list);

        Students<String> s = new Students<>("Pranav");
        s.show();
    }
}
