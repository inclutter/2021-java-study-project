package generic2;

public class UpperBoundedWildcard {
    public static void main(String[] args) {
        Box6<Integer> iBox = new Box6<>();
        iBox.setOb(1234);
        Box6<Double> dBox = new Box6<>();
        dBox.setOb(10.009);

        Unboxer4.peekBox(iBox);
        Unboxer4.peekBox(dBox);
    }
}

class Box6<T> {
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

class Unboxer4 {
    public static void peekBox(Box6<? extends Number> box6) {
        System.out.println(box6);
    }
}