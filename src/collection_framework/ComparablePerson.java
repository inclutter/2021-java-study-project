package collection_framework;

import java.util.TreeSet;

public class ComparablePerson {
    public static void main(String[] args) {

        /**
         *
         * 아래 생성자에 저장
         * public TreeSet() {
         *         this(new TreeMap<E,Object>());
         *     }
         */
        TreeSet<Person1> tree = new TreeSet<>();
        tree.add(new Person1("YOON", 37));
        tree.add(new Person1("HONG", 53));
        tree.add(new Person1("PARK", 22));

        for (Person1 p:
             tree) {
            System.out.println(p);
        }
    }
}

class Person1 implements Comparable<Person1> {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int compareTo(Person1 o) {
        return this.age - o.age; // 현재 나이가 크면 양의 정수, 작으면 음의 정수, 같으면 0 반환
    }
}