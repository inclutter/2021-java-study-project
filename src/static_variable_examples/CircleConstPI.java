package static_variable_examples;

public class CircleConstPI {
    public static void main(String[] args) {
        Circle circle = new Circle(1.2);
        circle.showPerimeter();
        circle.showArea();
    }
}

class Circle {
    static final double PI = 3.1415; // 변하지 않는, 참조가 목적인 값  // 변수를 선언할 때 그 앞에 final이라는 선언을 추가하면 그 변수는 '상수'가 된다. 그리고 다음 두가지 특징을 지니게 된다.
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    void showPerimeter() {
        double peri = (radius * 2) * PI;
        System.out.println("둘레 : " + peri);
    }

    void showArea() {
        double area = (radius * radius) * PI;
        System.out.println("넓이 : " + area);
    }

}