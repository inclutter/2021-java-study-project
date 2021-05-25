package collection_framework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ECarSortCollections {
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        list.add(new Car(1200));
        list.add(new Car(3000));
        list.add(new Car(1800));

        List<ECar> elist = new ArrayList<>();

        Collections.sort(list); // 정렬

        for (Iterator<Car> itr = list.iterator(); itr.hasNext();) {
            System.out.println(itr.next().toString() + '\t');
        }
    }
}

class Car implements Comparable<Car> {
    protected int disp; // 배기량

    public Car(int disp) {
        this.disp = disp;
    }

    @Override
    public int compareTo(Car o) {
        return disp - o.disp;
    }

    @Override
    public String toString() {
        return "cc : " + disp;
    }
}

class ECar extends Car { // 전기 자동차를 표현한 클래스
    private int battey; // 배터리
    public ECar(int d, int b) {
        super(d);
        battey = b;
    }

    @Override
    public String toString() {
        return "cc : " + disp + ", ba : " + battey;
    }
}