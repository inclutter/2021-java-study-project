package generic1;

public class GenericExample2 {
    public static void main(String[] args) {
        ThirdDBox<String, Integer> box1 = new ThirdDBox<>();
        ThirdDBox<String, Integer> box2 = new ThirdDBox<>();
        ThirdDBox<String , String> box3 = new ThirdDBox<>();

        box1.set("Apple",25);
        box2.set("Orange", 33);
        box3.set(box1.secondToString(), box2.secondToString());
        System.out.println(box3.toString());

    }
}

class ThirdDBox<L, R> {
    private L left;
    private R right;

    public void set(L l, R r) {
        this.left=l;
        this.right=r;
    }

    @Override
    public String toString() {
        return this.left + "\n" + this.right;
    }
    public String secondToString() {
        return this.left + " & " + this.right;
    }


}
