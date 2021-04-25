package zoo1;

public class Cat {
    /**
     * public으로 선언된 method는 어디서든 호출이 가능하다.
     */
    public void makeSound() {
        System.out.println("야옹");
    }

    /**
     * defualt로 선언된 method는 동일 패키지로 묶은 클래스 내에서만 접근이 가능하다.
     */
    void makeHappy() {
        System.out.println("스마일");
    }
}
