package access_level_modifiers;

/**
 * Cat은 pulbic 선언이 되었으므로 어디서든 인스턴스 생성 가능
 * 예를 들어 다른 패키지인 generic1이나 generic2 패키지에서도 해당 인스턴스 생성이 가능하다.
 */
public class Cat {
    public static void main(String[] args) {
        // Dyck과 같은 패키지로 묶여 있으니 Duck 인스턴스 생성 가능
        Duck quack = new Duck();
    }
}

/**
 * Duck class는 default로 선언되었으므로 동일 패키지 내에서만 인스턴스 생성 가능
 * 해당 패키지에서만 인스턴스 생성이 가능하다.
 */
class Duck {
    // 빈 클래스
}
