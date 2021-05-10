package collection_framework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorCollection {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
        list.add("Box");

        Iterator<String> iterator = list.iterator(); // 반복자 처음 획득

        while(iterator.hasNext())
            System.out.print(iterator.next() + '\t');
        System.out.println();

        iterator = list.listIterator(); // 반복자 다시 획득

        String str;
        while(iterator.hasNext()) {
            str = iterator.next();
            if(str.equals("Box"))
                iterator.remove();
        }

        iterator = list.iterator(); // 반복자 다시 획득

        while(iterator.hasNext())
            System.out.print(iterator.next() + '\t');
        System.out.println();
    }
}
