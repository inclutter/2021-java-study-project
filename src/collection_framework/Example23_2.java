package collection_framework;

import java.util.Comparator;
import java.util.TreeSet;

public class Example23_2 {
    public static void main(String[] args) {
        TreeSet<Integer> tr = new TreeSet<>(new IntergerComparator()); // 생성자에 new IntergerComparator() 전달한다.
        tr.add(30); // Overriding된 compare 메소드로 정렬 처리가 된다. 0
        tr.add(10); // Overriding된 compare 메소드로 정렬 처리가 된다. 20
        tr.add(20); // Overriding된 compare 메소드로 정렬 처리가 된다. 10
        System.out.println(tr);
    }
}

class IntergerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}