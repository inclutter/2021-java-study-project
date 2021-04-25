package access_level_modifiers;

/**
 * 인스턴스 멤버의 public과 default 선언이 갖는 의미
 * public - 어디서든 접근이 가능하다.
 * default - 동일 패키지로 묶은 클래스 내에서만 접근이 가능하다.
 */
public class AccessLevelModifiersExample {
    public int num1; // 인스턴스 변수의 public 선언
    protected int num2; // 인스턴스 변수의 protected 선언
    private int num3; // 인스턴스 변수의 private 선언
    int num4; // 인스턴스 변수의 default 선언

    public void md1() {} // 인스턴스 메소드의 public 선언
    protected void md2() {} // 인스턴스 메소드의 protected 선언
    private void md3() {} // 인스턴스 메소드의 private 선언
    void md4() {} // 인스턴스 메소드의 default 선언

}
