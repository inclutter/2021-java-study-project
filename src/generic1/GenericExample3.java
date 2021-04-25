package generic1;

public class GenericExample3 {
    public static <N extends Number> void swapBox(ExampleBox3<N> lBox, ExampleBox3<N> rBox) {
        ExampleBox3<N> tBox = new ExampleBox3<N>();
        tBox.setOb(lBox.getOb());
        lBox.setOb(rBox.getOb());
        rBox.setOb(tBox.getOb());
    }

    public static void main(String[] args) {
        ExampleBox3<Integer> box1 = new ExampleBox3<>();
        box1.setOb(99);

        ExampleBox3<Integer> box2 = new ExampleBox3<>();
        box2.setOb(55);

        System.out.println(box1.getOb() + " & " + box2.getOb());
        swapBox(box1, box2);
        System.out.println(box1.getOb() + " & " + box2.getOb());
    }
}

class ExampleBox3<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}
