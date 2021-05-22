package collection_framework;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorPerson {
    public static void main(String[] args) {
        /**
         *
         * 아래 생성자에 저장
         * public TreeSet(Comparator<? super E> comparator) {
         *         this(new TreeMap<>(comparator));
         *     }
         */
        TreeSet<Person2> tree = new TreeSet<>(new PersonComparator()); // 1. PersonComparator() 인스턴스를 매개변수로 전달한다. 매개변수로 전달된 TreeSet 인스턴스가 tree에 저장됨
        tree.add(new Person2("YOON", 37));
        tree.add(new Person2("HONG", 53));
        tree.add(new Person2("PARK", 22));

        for (Person2 p:
             tree) {
            System.out.println(p);
        }
    }
}

class Person2 implements Comparable<Person2> {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    @Override
    public int compareTo(Person2 o) {
        return this.age - o.age;
    }
}

class PersonComparator implements Comparator<Person2> {
    /**
     * 해당 메소드를 사용하여 정렬처리를 함 compareTo를 사용 안함
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o2.age - o1.age;
    }
}