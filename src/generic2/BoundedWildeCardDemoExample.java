package generic2;

/**
 * 다음 예제는 프로그래머의 실수가 존재한다.
 * 그러나 컴파일 과정에서는 이 실수가 드러나지 않는다.
 * 실수가 컴파일 과정에서 발견될 수 있도록 매개변수 선언을 수정하자. 그리고 프로그래머의 실수를 바로잡자.
 */
public class BoundedWildeCardDemoExample {
    public static void addBox(Box9<? super Integer> b1, Box9<? extends Integer> b2, Box9<? extends Integer> b3) {
        // TODO : 문제가 있는 부분 확인을 원할 경우 주석해제
        // b3.setOb((b1.getOb() + b2.getOb())); // 프로그래머의 실수가 있는 부분
        b1.setOb((b2.getOb() + b3.getOb())); // 프로그래머의 실수가 있는 부분
    }

    public static void main(String[] args) {
        Box9<Integer> box1 = new Box9<Integer>();
        box1.setOb(24);
        Box9<Integer> box2 = new Box9<>();
        box2.setOb(37);
        Box9<Integer> result = new Box9<>();
        result.setOb(0);
        addBox(result,box1,box2);
        System.out.println(result.getOb());
    }
}

class Box9<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}
