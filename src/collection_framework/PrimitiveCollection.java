package collection_framework;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimitiveCollection {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(10); integerLinkedList.add(20); integerLinkedList.add(30);

        int n;
        for (Iterator<Integer> itr = integerLinkedList.iterator(); itr.hasNext();) {
            n = itr.next();
            System.out.print(n + "\t");
        }
        System.out.println();

    }
}
