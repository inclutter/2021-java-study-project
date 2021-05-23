package collection_framework;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeCollection {
    public static void main(String[] args) {
        Deque<String> deq = new ArrayDeque<>();

        // 앞으로 넣고
        deq.offerFirst("1.Box");
        deq.offerFirst("2.Toy");
        deq.offerFirst("3.Robot");

        // 앞으로 꺼내기
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
    }
}
