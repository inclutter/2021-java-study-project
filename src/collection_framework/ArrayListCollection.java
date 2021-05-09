package collection_framework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCollection {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();

        // 컬렉션 인스턴스에 문자열 인스턴스 저장
        arrayList.add("Toy");
        arrayList.add("Box");
        arrayList.add("Robot");

        // 저장된 문자열 인스턴스의 참조
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + '\t');

        }
        System.out.println();
        arrayList.remove(0); // 첫 번째 인스턴스의 삭제

        // 첫 번째 인스턴스 삭제 후 나머지 인스턴스들을 참조
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + '\t');
        }
        System.out.println();
    }
}
