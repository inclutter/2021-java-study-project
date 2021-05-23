package collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConvertCollection {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("Box", "Toy", "Box", "Toy"); // List Inteface
        ArrayList<String> list = new ArrayList<>(lst); // List에 있는 인터페이스 메소드들을 ArrayList에서 구현함

        for (String s:list) {
            System.out.print(s.toString() + '\t');
        }
        System.out.println();

        // 중복된 인스턴스를 걸러 내기 위한 작업
        /**
         * 다른 컬렉션 인스턴스로부터 HashSet<E> 인스턴스 생성
         * public HashSet(Collection<? extends E> c) {
         *         map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
         *         addAll(c);
         *     }
         */
        HashSet<String> set = new HashSet<>(list);

        // 원래대로 ArrayList<String> 인스턴스로 저장물을 옮긴다.
        list = new ArrayList<>(set); // ArrayList 인스턴스로 다시 list에 저장

        for (String s:list) {
            System.out.print(s.toString() + '\t');
        }
        System.out.println();

    }
}