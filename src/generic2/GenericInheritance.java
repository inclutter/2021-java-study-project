package generic2;

public class GenericInheritance {
    public static void main(String[] args) {
        // 아래 SteelBox class에서 Box 클래스에 있는 ob 변수의 값을 저장했기 때문에 다음과 같이
        // Box클래스에 SteellBox 인스턴스를 전달해도 해당 값을 정상적으로 getting 할 수 있게 되었다.
        Box<Integer> iBox = new SteelBox<Integer>(7959);
        Box<String> sBox = new SteelBox<String>("Simple");
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

/**
 * Box class를 상속한다
 * @param <T>
 */
class SteelBox<T> extends Box<T> {
    // 상속한 박스 class에 있는 ob 인자에 파라미터 값을 전달한다.
    public SteelBox(T o) {
        ob = o;
    }
}
