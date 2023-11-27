import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareImpl {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Pranav", 40000L));
        list.add(new Employee(102, "Venkata", 60000L));
        list.add(new Employee(103, "Sarkthak", 20000L));
        list.add(new Employee(104, "Manoj", 100000L));
        System.out.println(list);
        Collections.sort(list, new SalaryCompare());
        System.out.println(list);


//        List<NewEmployee> list = new ArrayList<>();
//        list.add(new NewEmployee(101, "Pranav", 40000L));
//        list.add(new NewEmployee(102, "Venkata", 60000L));
//        list.add(new NewEmployee(103, "Sarkthak", 20000L));
//        list.add(new NewEmployee(104, "Manoj", 100000L));
//        System.out.println(list);
//        Collections.sort(list, new SalaryCompare());
//        System.out.println(list);

    }
}

class NameCompare implements Comparator<NewEmployee>{

    @Override
    public int compare(NewEmployee o1, NewEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryCompare implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}