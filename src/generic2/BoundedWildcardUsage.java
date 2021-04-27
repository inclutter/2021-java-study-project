package generic2;

public class BoundedWildcardUsage {
    public static void main(String[] args) {

    }
}

class Box1<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class Toy {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler {
    public static void outBox(Box1<? extends Toy> box) {
        Toy t = box.getOb();
        System.out.println(t);

        Toy n = new Toy();
        /**
         * 와일드 카드 상속(? extends Toy)의 경우 다음과 같이 to set이 안됨
         * TODO : 주석 제거하면 컴파일 에러 발생하므로 에러 확인 원할 경우 주석 해제
         */
        // box.setOb(n);
    }

    public static void inBox(Box1<Toy> box, Toy n) {
        box.setOb(n);
    }
}