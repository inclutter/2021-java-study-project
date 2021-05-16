package collection_framework;

import java.util.HashSet;

/**
 * HashSet<E>이 판단하는 동일 인스턴스의 기준은, Object 클래스에 정의되어 있는 다음 두 메소드의 호출 결과를 근거로 하기 떄문
 *
 */
public class HashSetEqualityOne {
    public static void main(String[] args) {
        HashSet<Num1> set = new HashSet<>();
        set.add(new Num1(7799)); // 다른 인스턴스
        set.add(new Num1(9955)); // 다른 인스턴스
        set.add(new Num1(7799)); // 다른 인스턴스

        System.out.println("인스턴스 수 : " + set.size());

        for (Num1 n : set) {
            System.out.print(n.toString() + '\t');
        }
        System.out.println();
    }
}

class Num1 {
    private int num;

    public Num1(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
