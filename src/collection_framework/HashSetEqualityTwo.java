package collection_framework;

import java.util.HashSet;

public class HashSetEqualityTwo {
    public static void main(String[] args) {
        HashSet<Num> set = new HashSet<>();
        set.add(new Num(7799)); // hashCode() 함수 실행
        set.add(new Num(7799)); // hashCode() 함수 실행 equals(Object obj) 함수 실행해서 동일 값인지 확인 -> 동일 값이면 저장 안함
        set.add(new Num(9955)); // hashCode() 함수 실행
        set.add(new Num(7799)); // hashCode() 함수 실행 equals(Object obj) 함수 실행해서 동일 값인지 확인 -> 동일 값이면 저장 안함

        System.out.println("인스턴스 수 : " + set.size());

        for (Num n:set) {
            System.out.printf(n.toString() + '\t');
        }
        System.out.println();
    }
}

class Num {
    private int num;

    public Num(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int hashCode() {
        return num % 3;
    }

    /**
     * 다음과 같이 Overriding 하면 object의 값을 비교하는게 아니가 해당 int값을 비교하여 동일 여부를 판단한다.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(num == ((Num)obj).num)
            return true;
        else
            return false;
    }
}