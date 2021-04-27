package generic2;

/**
 * wildcard는 만능패라는 뜻
 */
public class WildcardUnboxer {
    public static void main(String[] args) {
        Box3<String> stringBox3 = new Box3<>();
        stringBox3.setOb("So Simple String");
        Unboxer.peekBox(stringBox3); // 상자 안의 내용물을 확인해본다.
    }
}

class Box3<T> {
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

class Unboxer {
    public static <T> T openBox(Box3<T> box3) {
        return box3.getOb();
    }
    // 상자 안의 내용물을 확인하는(출력하는) 기능의 제네릭 메소드
    public static <T> void peekBox(Box3<T> box3) {
        System.out.println(box3);
    }
}