package collection_framework;

import java.util.LinkedList;
import java.util.List;

public class EnhancedForCollection {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();

        linkedList.add("Toy");
        linkedList.add("Box");
        linkedList.add("Robot");

        for (String s : linkedList) {
            System.out.print(s + '\t');
        }
        System.out.println();

        linkedList.remove(0); // 첫 번째 인스턴스 삭제
        linkedList.remove(0); // 첫 번째 인스턴스 삭제(앞서 첫번째 인스턴스가 삭제되었으므로 그 다음 첫번째 인스턴스가 삭제된다.)

        for (String s :
                linkedList) {
            System.out.print(s + '\t');
        }
        System.out.println();

    }
}
