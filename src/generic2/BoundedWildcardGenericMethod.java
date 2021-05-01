package generic2;

public class BoundedWildcardGenericMethod {
    public static void main(String[] args) {
        Box10<Toy2> tBox = new Box10<>();
        BoxHandler2.inBox(tBox, new Toy2());
        BoxHandler2.outBox(tBox);

        Box10<Robot> rBox = new Box10<>();
        BoxHandler2.inBox(rBox, new Robot());
        BoxHandler2.outBox(rBox);

    }
}

class Box10<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class Toy2 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class Robot {
    @Override
    public String toString() {
        return "I am a Robot";
    }
}

class BoxHandler2 {
    public static <T> void outBox(Box10<? extends T> box) {
        T t = box.getOb();
        System.out.println(t);
    }

    public static <T> void inBox(Box10<? super T> box, T n) {
        box.setOb(n);
    }

}