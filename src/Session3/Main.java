import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
            1. ArrayList
                add(Object);
                add(index, object)
                size()
                get(index)
                addAll(Collection)
                contains()
                Set(index, value)
                remove(object)
                capacity() // only for vector
        */
//        List<Integer> list = new ArrayList<>(2);
//
//        list.add(10);
//        list.add(20);
//        list.set(1, 40);
//        System.out.println(list.size());
////
//        list.add(1,5);
//
//        System.out.println(list.get(2));
//
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.addAll(list);
//        list1.add(50);
//
//
//        System.out.println(list1.contains(1024));
//        System.out.println(list);
//        System.out.println(list1);


//        List<Integer> list = new LinkedList<>();
//        list.add(10);
//        list.add(2, 35);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//        System.out.println(list);
//        list.removeIf(no -> no == 20);
//        System.out.println(list);

//        Collections.sort(list);

//        Vector<Integer> arr1 = new Vector<>(6);
//        arr1.add(10);
//        arr1.add(10);
//        arr1.add(10);
//        arr1.add(10);
//        arr1.add(10);
//        arr1.add(10);
//        System.out.println(arr1.capacity());
//        arr1.add(10);
//        System.out.println(arr1.capacity());

//
//
//        Stack<Integer> lifo = new Stack<>();
//        lifo.push(10);
//        lifo.push(20);
//        System.out.println(lifo.peek());
//        System.out.println(lifo.size());
//        System.out.println(lifo.pop());
//        System.out.println(lifo.size());
//
//        List<Integer> list = new LinkedList<>();
//
//
//        list.removeIf(student ->  (student.getMarks() < 60));
//
//
//        Stack<Integer> list = new Stack<>();
//

//
//        Queue<Integer> queue = new ArrayDeque<>();
//
//        queue.offer(10);
//        queue.offer(20);
//        queue.offer(30);
//        queue.offer(40);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());


        // If we don't pass anything in constructor then by default it is minheap, else it is maxheap (Collections.reverseOrder())
//        PriorityQueue<Integer> queue= new PriorityQueue<>(Collections.reverseOrder());
//        queue.offer(10);
//        queue.offer(20);
//        queue.offer(1);
//        queue.offer(40);
//        queue.offer(10);
//        queue.offer(5);
//
//        System.out.println(queue.poll());

//        List<String> list = new ArrayList<>();
//        list.add("Mukul");
//        list.add("Pranav");
//        list.add("Utpal");
//        list.add("Dipti");
//
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        ListIterator<String> listIterator = list.listIterator(list.size() - 1);
//        while(listIterator.hasPrevious()){
//            System.out.println(listIterator.previous());
//        }



//        SortedSet<String> list = new TreeSet<>();
//        list.add("Mukul");
//        list.add("Pranav");
//        list.add("Utpal");
//        list.add("Dipti");
//
//        System.out.println(list);
//
//        Iterator<String> listIterator = list.iterator();
//        while(listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        Map<String, String> mp = new HashMap<>();
        mp.put("105", "Mukul");
//        mp.put("102", "Pranav");
//        mp.put("103", "Utpal");
//        mp.put("104", "Dipti");
//        mp.put("105", "Mukul");
//        mp.put("101", "Pranav");
//        mp.put("106", "Utpal");
//        mp.put("107", "Dipti");
//        mp.put("108", "Mukul");
//        mp.put("109", "Pranav");
//        mp.put("111", "Utpal");
//        mp.put("1012", "Dipti");
//        mp.put("10121", "Dipti");
//        mp.put("10122", "Dipti");
//
//        System.out.println(mp);
//
//
//
//        for(Map.Entry<String, String> m : mp.entrySet()){
//            System.out.println("Key:"+m.getKey()+" Value:"+m.getValue());
//        }


        List<String> list = new ArrayList<>();
        list.add("Mukul");
        list.add("Pranav");
        list.add("Utpal");
        list.add("Dipti");
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
//        for(String i : list){
//            System.out.println(i);
//        }
        list.forEach(i -> System.out.println(i));

    }
}

/*
*  Key - Value
*  studentId - Name
*
*
*
* */