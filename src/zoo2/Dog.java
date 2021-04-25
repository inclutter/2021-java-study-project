package zoo2;

public class Dog {
    public void welcome(zoo1.Cat c) {
        // 해당 method의 경우 public 선언이 되었으므로 다른 package에서도 호출이 가능하다
        c.makeSound();

        /**
         * 해당 method의 경우 default 선언이 되었으므로 다른 package에서도 호출이 불가능하고 동일 패키지에서만 호출이 가능하다.
         * TODO : 컴파일 에러 확인 원할 경우 주석해제
         */
        // c.makeHappy();
    }
}
