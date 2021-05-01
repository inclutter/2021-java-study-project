# 2021-java-study-project
## ◎ Java study project list

1. Java Wrapper class
2. Java package naming
3. Access-level modifiers
4. Constants
5. Wildcard



### 01 Java wrapper class

<img src='images/스크린샷 2021-04-24 오후 11.34.05.png'>

### 02 Java package naming

<img src='images/스크린샷 2021-04-25 오후 3.16.47.png'>

### 03 접근 수준 지시자(Access-level Modifiers)

- pulbic
  - 어디서든 접근이 가능하다.
- protected
  - default 선언이 허용하는 접근을 모두 허용한다.
  - 더불어 protected는 default가 허용하지 않는 '한 영역'에서의 접근도 허용한다.
- private
  - 클래스 내부에서만 접근 가능
- default
  - default는 키워드가 아닌, '아무런 선언도 하지 않은 상황을 의미한다.'
  - 비록 이는 키워드가 아닌 일종의 '상황'이지만 이 역시 '접근 수준 지시자'의 한 종류로 구분을 한다.
  - 그리고 이러한 선언을 할 수 있는 대상은 다음 두가지이다.
    - 클래스의 정의
      - 클래스의 정의를 대상으로는 다음 두가지 선언이 가능하다.
        - pulbic
        - default
    - 클래스의 인스턴스 변수와 메소드
      - 인스턴스 변수와 메소드를 대상으로는 다음 네가지 선언이 모두 가능하다.
        - public
        - protected
        - private
        - default

#### • 클래스 정의 대상의 pulbic과 default 선언이 갖는 의미

```java
public class AAA { // 클래스의 pulbic 선언`
}
```

```java
class ZZZ { // 클래스의 default 선언`
}
```

- 정리하면, 클래스 정의에 대한 public과 default 선언이 갖는 의미는 다음과 같다.
  - public
    - 어디서든 인스턴스 생성이 가능하다.
  - default
    - 동일 패키지로 묶인 클래스 내에서만 인스턴스 생성을 허용한다.

<img src='images/img.png'>

### 04 Constants(상수)

변수를 선언할 때 그 앞에 final이라는 선언을 추가하면 그 변수는 '상수'가 된다. 그리고 다음 두가지 특징을 지니게 된다.

- 값을 딱 한 번만 할당할 수 있다.
- 한 번 할당된 값은 변경이 불가능하다.

```java
public class Constants {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        final char CONST_CHAR = '상';
        final int CONST_ASSIGNED;

        CONST_ASSIGNED = 12;
        System.out.println("상수1 : " + MAX_SIZE);
        System.out.println("상수2 : " + CONST_CHAR);
        System.out.println("상수3 : " + CONST_ASSIGNED);
    }
}
```

### 05 Wildcard(만능패)

```java
/**
 * 아래 와일드 카드의 경우
 * Number를 상속하는 하위 클래스가 올 수 있다.
 * 하위 클래스는 Integer와 Double이 올 수 있다.
 * wildecard extends의 경우 다음과 같이 to set을 할 수 없다.
 * 이유는 어떤 값을 저장할지 알 수 없기 때문이다.
 * to set을 하려고 하는 값이 어떤 값이 올지 알 수 없다.
 * 그 값이 double일지, 아니면 Integer일지 알 수 없으므로 다음과 같이 컴파일 에러가 발생한다.
 * @param box5
 */
public static void peekBox(Box5<? extends Number> box5, int n) { // Wildcard 사용 메소드
    System.out.println(box5.getOb());
    // TODO : 컴파일 오류 확인 원할 경우 주석 해제
    // box5.setOb(n);
}

/**
 * 아래 와일드 카드의 경우
 * Integer 또는 Inter가 상속하는 클래스가 올 수 있다
 * 상속하는 클래스로는 Integer, Number, Object가 올 수 있다.
 * wildecard super의 경우 to get을 할 수 있다.
 * 정확히 말하자면 to get은 가능하나 값을 저장하는데에 제한이 있다.
 * 아래와 같이 Object 변수에는 저장이 가능하다 Object 변수의 경우 위에 상속하는 클래스에 최상위에 있으므로
 * 다음과 같이 어떤 타입이 와도 저장이 가능하다
 * 그러나 Integer 타입 변수의 경우 box5의 to get을 한 값이 어떤 값이 올지 알 수 없으므로 값을 저장을 할 수가 없게된다.
 * @param box5
 * @param n
 */
public static void setBox(Box5<? super Integer> box5, int n) {
    box5.setOb(n);
    Object t = box5.getOb();
    // TODO : 컴파일 오류 확인 원할 경우 주석 해제
    // Integer k = box5.getOb();
    System.out.println(box5.getOb());
}
```

#### 참조변수를 Object형으로 선언하는 것은 피해야 한다.

자바는 Object형 잠조변수의 선언이나 Object형으로의 형 변환이 불필요하도록 문법을 개선시켜왔다. Object라는 이름이 코드에 직접 등장하는 것은 컴파일러를 통한 오류의 발견 가능성을 낮추는 행위이기 때문이다.

#### 언제 와일드카드에 제한을 걸어야 하는가?

와일드카드의 상한과 하한 제한이 필요한 이유의 본질은 그 자체로 이해하기 난해한 부분이 있다.

매개변수 선언 : Box<? extends Toy> box

**→ box가 참조하는 인스턴스를 대상으로 꺼내는 작업만 허용하겠다는 의미**

매개변수 선언 : Box<? super Toy> box

**→ box가 참조하는 인스턴스를 대상으로 넣는 작업만 허용하겠다는 의미**

#### • 제네릭을 이용한 상한, 하한 제한으로 에러 방지

 다음과 같은 에러를 방지 하기 위해 상한 제한 또는 하한 제한을 걸어둬 에러를 방지할 수 있다.

```java
public class BoundedWildcardGeneric {

    /**
     * box에 con과 동일한 내용물이 들었는지 확인
     *
     * @param box - 기존 Box11<T> box 선언에서 Box11<? extends T>로 수정하여 에러를 해결할 수 있다.
     * @param con
     * @param <T>
     * @return
     */
    public static <T> boolean compBox(Box11<? extends T> box, T con) {
        T bc = box.getOb();
        // TODO : 에러 발생하는 부분 확인을 원할 경우 주석 해제
        // box.setOb(con); // 프로그래머의 실수로 삽입된 문장 때문에 내용물이 바뀐다.
        return bc.equals(con);
    }

    public static void main(String[] args) {
        Box11<Integer> box1 = new Box11<>();
        box1.setOb(24);
        Box11<String> box2 = new Box11<>();
        box2.setOb("Poly");

        if(compBox(box1,25))
            System.out.println("상자 안에 25 저장");
        if(compBox(box2, "Moly"))
            System.out.println("상자 안에 Moly 저장");

        System.out.println(box1.getOb());
        System.out.println(box2.getOb());
    }
}

class Box11<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}
```

#### 

#### • 제네릭 인터페이스의 정의와 구현

클래스외에 다음과 같이 인터페이스 역시 클래스와 마찬가지로 제네릭으로 정의할 수 있다.

```java
package generic2;

public class GetableGenericInterface {
    public static void main(String[] args) {
        Box12<Toy3> box = new Box12<>(); // 다음과 같이 T를 대신할 자료형이 Toy3로 동일해야 참조 가능함
        box.setOb(new Toy3());

        Getable<Toy3> gt = box; // Box12<T>가 Getable를 구현하므로 참조 가능 // 다음과 같이 T를 대신할 자료형이 Toy3로 동일해야 참조 가능함
        System.out.println(gt.get());
    }
}

interface Getable<T> {
    public T get();
}

/**
 * 인터페이스 Getable<T>를 구현하는 Box12<T> 클래스
 * @param <T>
 */
class Box12<T> implements Getable<T> {
    private T ob;

    public void setOb(T ob) {
        this.ob = ob;
    }

    @Override
    public T get() {
        return ob;
    }
}

class Toy3 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}
```

제네릭 인터페이스를 구현할 때에는 다음과 같이 T를 결정한 상태로 구현할 수도 있다.

단, 이렇듯 제네릭 인터페이스의 T를 String으로 결정하면 Getable<T>의 메소드를 구현할 때에도 다음과 같이 T가 아닌 String으로 명시하고 구현해야 한다.

``` java
class Box<T> implements Getable<String {...} // 제네릭 인터페이스를 구현할 때 다음과 같이 T를 결정한 상태로 구현할 수도 있다.

@Override
public String get() {...}
```

```java
public class GetableGenericInterface2 {
    public static void main(String[] args) {
        Box13<Toy4> box = new Box13<>();
        box.setOb(new Toy4());

        /**
         * Getable1<String>형 참조변수는 다음과 같이 Box14<T> 인스턴스를 T의 자료형에 상관없이 참조할 수 있다.
         * Box13의 참조변수가 Toy4여도 참조할 수 있음
         */
        Getable1<String> gt = box;
        System.out.println(gt.get());
    }
}

interface Getable1<T> {
    public T get();
}

class Box13<T> implements Getable1<String> {
    private T ob;

    public void setOb(T ob) {
        this.ob = ob;
    }

    @Override
    public String get() { // 반환형은 T가 아닌 String이어야 한다.
        return "I am a Toy";
    }
}

class Toy4 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}
```