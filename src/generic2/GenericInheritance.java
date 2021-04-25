package generic2;

public class GenericInheritance {
    public static void main(String[] args) {
        SteelBox<Integer> iBox = new SteelBox<Integer>(7959);
        SteelBox<String> sBox = new SteelBox<String>("Simple");
        System.out.println(iBox.getOb());
        System.out.println(sBox.getOb());
    }
}

class Box<T> {
    protected T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class SteelBox<T> extends Box<T> {
    public SteelBox(T o) {
        ob = o;
    }
}
