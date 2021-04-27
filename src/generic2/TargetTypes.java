package generic2;

public class TargetTypes {
    public static void main(String[] args) {
        Box2<Integer> integerBox2 = EmptyBoxFactory.<Integer>makeBox(); // Box2 인스턴스를 반환 함
        integerBox2.setOb(25);
        System.out.println(integerBox2.getOb());
    }
}

class Box2<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class EmptyBoxFactory {
    public static <T> Box2<T> makeBox() { // 제네릭 메소드
        Box2<T> box2 = new Box2<T>(); // 상자 생성
        return box2; // 생성한 상자 반환
    }
}
