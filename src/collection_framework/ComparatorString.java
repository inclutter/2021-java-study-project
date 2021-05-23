package collection_framework;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorString {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>(new StringComparator());
        // 1. Box - Box = 0 - Box
        tree.add("Box");
        // 2. Rabbit - Box = 3 - Box - Rabbit
        tree.add("Rabbit");
        // 3. Robot - Box = 2 - Box - Rabbit - Robot
        // 4. Robot - Rabbit = -1 - Box - Rabbit -
        tree.add("Robot");
        // 5. AppleComp - Robot = 4
        // 6. AppleComp - Rabbit = 3
        tree.add("AppleComp");
        tree.add("to");

        for (String s:tree) {
            System.out.print(s.toString() + '\t');
        }
        System.out.println();
    }
}

/**
 * 비교시 작아야 앞에 옴
 * 1. Box - Box = 0 - Box
 * 2. Rabbit - Box = 3 - Box - Rabbit
 * 3. Robot - Box = 2 - Box - Rabbit - Robot
 * 4. Robot - Rabbit = -1 - Box - Rabbit -
 * 5. AppleComp - Robot = 4 -
 * 6. AppleComp - Rabbit = 3
 */
class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) { // 정렬의 기준을 정할 수 있음
        return o1.length() - o2.length(); // 길이가 짧은게 더 우선 순위가 높음
    }
}