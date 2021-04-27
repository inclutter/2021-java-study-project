package generic2;

public class WildcardTest {
    public static void main(String[] args) {
        Box5<Integer> box5 = new Box5<>();
        box5.setOb(55);
        Unboxer3.peekBox(box5);
        Box5<Object> box6 = new Box5<>();
        Unboxer3.setBox(box6,77);
    }
}

class Box5<T> {
    T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class Unboxer3 {
    public static <T> T openBox(Box5<T> box5) {
        return box5.getOb();
    }

    public static void peekBox(Box5<? extends Number> box5) { // Wildcard 사용 메소드
        System.out.println(box5.getOb());
//        box5.setOb(66);
    }

    public static void setBox(Box5<? super Integer> box5, int n) {
        box5.setOb(n);
        Object t = box5.getOb();
        Integer k = box5.getOb();
        System.out.println(box5.getOb());
    }
}