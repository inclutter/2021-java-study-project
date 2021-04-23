package generic;

public class Generic1 {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box);
        ToStringTest toStringTest = new ToStringTest();
        System.out.println(toStringTest);
    }
}

class Box<T> {
    private T ob;
    public void set(T o) { this.ob = o; }
    // 객체를 리턴할 경우 만약 @Override toString을 했다면
    // 해당 객체 주소가 리턴되는게 아니고 overriding한 새 toString 메소드의 결과가 리턴된다.
    public T get() { return this.ob; }
}

class Toy {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler {
    public static void outBox(Box<Toy> box) {
        Toy t = box.get();
        System.out.println(t);
    }

    public static void inBox(Box<Toy> box, Toy n) {
        box.set(n);
    }
}

class ToStringTest {
    @Override
    public String toString() {
        return "To string test.";
    }
}