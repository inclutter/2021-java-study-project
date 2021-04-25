package generic1;

public class GenericExample1 {
    public static void main(String[] args) {
        SecondDBox<String, Integer> box1 = new SecondDBox<>();
        SecondDBox<String, Integer> box2 = new SecondDBox<>();
        DDBox<SecondDBox<String, Integer>, SecondDBox<String, Integer>> ddBox = new DDBox<>();

        box1.set("Apple",25);
        box2.set("Orange",33);

        ddBox.set(box1, box2);
        System.out.println(ddBox.toString());
    }
}


class SecondDBox<L, R> {
    private L left;
    private R right;

    public void set(L l, R r) {
        this.left = l;
        this.right = r;
    }

    @Override
    public String toString() {
        return left + " & " + right;
    }
}

class DDBox<T1, T2> {
    private T1 type1;
    private T2 type2;

    public void set(T1 t1, T2 t2) {
        this.type1 = t1;
        this. type2 = t2;
    }

    @Override
    public String toString() {
        return type1.toString() + '\n' + type2.toString();
    }
}