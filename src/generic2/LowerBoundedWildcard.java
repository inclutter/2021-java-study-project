package generic2;

public class LowerBoundedWildcard {
    public static void main(String[] args) {
        Box8<Integer> iBox = new Box8<Integer>();
        iBox.setOb(5577);

        Box8<Number> nBox = new Box8<>();
        nBox.setOb(new Integer(9955));

        Box8<Object> oBox = new Box8<>();
        oBox.setOb("My Simple Instance");

        Unboxer5.peekBox(iBox);
        Unboxer5.peekBox(nBox);
        Unboxer5.peekBox(oBox);
    }
}

class Box8<T> {
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

class Unboxer5 {
    public static void peekBox(Box8<? super Integer> box) {
        System.out.println(box);
    }
}