package collection_framework;

import java.util.HashSet;
import java.util.Objects;

public class HashExample1 {
    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("Tom", 10));
        people.add(new Person("Bread", 16));
        people.add(new Person("Tom", 10));
        people.add(new Person("Tom", 15));

        System.out.println("인스턴스 수 : " + people.size());
        for (Person person:people) {
            System.out.println(person.toString());
        }
        System.out.println(people);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + "세)";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        int a =  ((Person)obj).age;
        String n = ((Person)obj).name;

        if(a == age && name.equals(n)) {
            return true;
        } else {
            return false;
        }
    }
}