package generic2;

public class WildcardUnboxer2 {
    public static void main(String[] args) {
        Box4<String> box4 = new Box4<>();
        box4.setOb("So Simple String");
        Unboxer2.peekBox(box4);
    }
}

class Box4<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class Unboxer2 {
    public static <T> T openBox(Box4<T> box4) {
        return box4.getOb();
    }

    public static void peekBox(Box4<?> box4) { // Wildcard 사용 메소드
        System.out.println(box4);
    }
}