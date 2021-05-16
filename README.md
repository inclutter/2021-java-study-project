# 2021-java-study-project
## ◎ Java study project list

1. Java Wrapper class
2. Java package naming
3. Access-level modifiers
4. Constants
5. Wildcard
6. Extension
7. Static variable(Java 책 223p 까지만 정리 추후 추가 정리 필요)
8. Collection framework
9. Exception Handling



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

### 06 Extension(상속)

#### • 상속에 대한 매우 치명적인 오해

상속은 코드의 재활용을 위한 문법이다 ← 해당 내용은 상속에 대한 매우 치명적인 오해이다.

상속은 코드의 재활용을 목적으로 사용하는 문법이 아니다.

만약에 재활용을 목적으로 상속을 사용할 경우 무의미하게 코드가 복잡해지고, 기대와 달리 코드를 재활용하지 못하는 상황을 쉽게 경험하게 될 것이다.

코드의 재활용은 프로그래머라면 누구나 바라는 일이다. 그러나 이를 목적으로 20년 넘게 한문적으로 연구가 진행 중이다.

그러나 전자부품이나 기계부품처럼 일부를 뜯어서 다른 장치에 사용하는 것은 아직은 요원한 일이며,

소프트웨어의 특성상 이러한 형태의 재활용이 아닌 다른 형태의 재활용이 시도되고 연구되고 있다.



#### • 상속이란?

연관된 일련의 클래스들에 대해 공통적인 규약을 정의할 수있다.



#### • 상속의 가장 기본적인 특성

상속을 단순하게 설명하면 기존에 정의된 클래스에 메소드와 변수를 추가하여 새로운 클래스를 정의하는 것이 상속이다.

다음과 같이 상속(extends)이란 단어(extension)의 명상적 번역은 다음과 같이 뻗음, 뻗침으로 번역할 수 있다.

상속이라고 하지만 실은 가지가 뻗치든 뻗치는 코드를 의미한다.

<img src='images/스크린샷 2021-05-02 오후 7.59.12.png'>

그럼 예를 들어서 다음의 클래스가 정의되어 있다고 가정해보자.

```java
class Man {
	String name;
	public void tellYourName() {
		System.out.println("My name is" + name);
	}
}
```

이때 위의 클래스를 상속하여(물려 받아서) 다음과 같이 새로운 클래스를 정의할 수 있다. 참고로 키워드의 extends는 상속을 의미하는 키워드이다. 

즉 extends Man은 Man 클래스를 상속한다는 의미이다.

```java
class BusinessMan extends Man { // Man을 상속하는 BusinessMan
	String company;
	String position;
	public void tellYourInfo() {
		System.out.println("My company is " + company);
		System.out.println("My position is " + position);
		tellYourName(); // Man 클래스를 상속했기 때문에 호출 가능!
	}
}
```

그리고 이렇게 Man 클래스를 상속하는 BusinessMan 클래스의 인스턴스를 생성하면, 다음 형태의 인스턴스가 생성된다.

```java
BusinessMan man = new BusinessMan();

// 다음 형태의 인스턴스가 생성
String name; // Man의 멤버 변수
String companay;
String position
void tellYourName() {...} // Man의 멤버
void tellYourInfo() {...}
```

#### • 생성자 호출

- 하위 클래스의 인스턴스 생성 시 상위 클래스, 하위 클래스의 생성자 모두 호출된다.
- 하위 클래스의 인스턴스 생성 시 상위 클래스의 생성자가 먼저 호출된다.

아래 코드에서는 두 클래스의 적절한 생성자 정의 모델을 보이고 있다.

**결론은 간단하다. 상속 관계에 있을지라도 인스턴스 변수는 각 클래스의 생성자를 통해서 초기화해야 한다는 것이다.**

```java
package extends_examples1;

public class MyBusinessMan2 {
    public static void main(String[] args) {
        BusinessMan businessMan = new BusinessMan("YOON", "Hybrid ELD", "Staff Eng");
        businessMan.tellYourInfo();
    }
}

class Man {
    String name;

    public Man(String name) {
        this.name = name;
    }

    public void tellYourName() {
        System.out.println("My name is " + name);
    }
}

class BusinessMan extends Man {
    String company;
    String position;

    public BusinessMan(String name, String company, String position) {
        super(name); // 상위 클래스의 생성자 호출
        this.company = company;
        this.position = position;
    }

    public void tellYourInfo() {
        System.out.println("My company is" + company);
        System.out.println("My position is" + position);
        tellYourName();
    }
}
```

#### • 단일 상속만을 지원하는 자바

자바는 프로그램이 과도하게 복잡해지는 것을 막기 위해 단일 상속만을 지원한다. 이는 다음과 같이 하나의 클래스가 상속할 수 있는 클래스의 수가 최대 하나라는 것을 의미한다.

```java
class AAA {...}
class ZZZ extends AAA {...}
```

그러나 다음과 같이 상속의 깊이를 더하는 것은 얼마든지 가능하다.

```java
class AAA {...}
class MMM extends AAA {...}
class ZZZ extends MMM {...}
```

#### • static 선언이 붙는 '클래스 변수'와 '클래스 메소드'의 상속

앞서 공부한 클래스 변수와 클래스 메소드의 특징을 정리하면 다음과 같다.

- 인스턴스의 생성과 상관이 없이 접근이 가능하다.
- 클래스 내부와 외부에서(접근 수준 지사자가 허용하면) 접근이 가능하다.
- 클래스 변수와 클래스 메소드가 위치한 클래스 내에서는 직접 접근이 가능하다.

즉 클래스 변수와 클래스 메소드는 인스턴스에 속하지 않는, 딱 하나만 존재하는 변수와 메소드이다.

따라서 상속의 대상이 아니다.

```java
class SuperCLS {
	static int count = 0; // 클래스 변수
	public SuperCLS() {
		count++; // 클래스 내에서는 직접 접근이 가능
	}
}
```

### 07 Static variable(클래스 변수)

'인스턴스 변수'는 인스턴스가 생성되었을 때, 생성된 인스턴스 안에 존재하는 변수이다. 그러나 '클래스 변수'는 인스턴스의 생성과 상관없이 존재하는 변수이다.

#### • 선언된 클래스의 모든 인스턴스가 공유하는 '클래스 변수(static 변수)'

클래스 내에 선언된 변수 앞에 static 선언을 붙이면 이는 인스턴스 변수가 아닌 '클래스 변수'가 된다.

이러한 클래스 변수의 특성을 파악하기 위해서 다음 예제를 관찰하자.

다음과 같이 정의 및 선언시 기대할 수 있는 결과로 변수 instNum의 값은 모두 1이 호출되어야 한다.

```java
public class ClassVar {
    public static void main(String[] args) {
        InstCnt instCnt1 = new InstCnt();
        InstCnt instCnt2 = new InstCnt();
        InstCnt instCnt3 = new InstCnt();
    }
}

class InstCnt {
    static int instNum = 0; // 클래스 변수(static 변수)

    InstCnt() { // 생성자
        instNum++; // static으로 선언된 변수의 값 증가
        System.out.println("인스턴스 생성 : " + instNum );
    }
}
```

그러나 기대한 결과와 다르게 instNum값은 공유라도 한듯 1씩 증가한 값이 되었다.

<img src='images/스크린샷 2021-05-02 오후 10.10.28.png'>

> static으로 선언된 변수는 변수가 선언된 클래스의 모든 인스턴스가 공유하는 변수이다.

클래스 변수(static 변수)는 인스턴스 내에 존재하는 변수가 아니라 **'어떠한 인스턴스에도 속하지 않는 상태로 메모리 공간에 딱 하나만 존재하는 변수'이다.**

다만 이 변수가 선언된 클래스의 인스턴스들은 이 변수에 바로 접근할 수 있는 권한이 있을 뿐이다.

그리고 클래스 변수도 '접근 수준 지시자'의 규칙을 그대로 적용받기 때문에 public으로 선언되면 어디서든 접근이 가능하다. 물론 접근 방법에 있어서는 차이를 보인다.



#### • 클래스 변수의 초기화 시점과 초기화 방법

클래스 변수가 언제 메모리 공간에 할당되고 초기화되는지 다음 예제를 보도록하자.

```java
public class OnlyClassNoInstance {
    public static void main(String[] args) {
        InstCnt2.instNum -= 15;
        System.out.println(InstCnt2.instNum);
    }
}

class InstCnt2 {
    static int instNum = 100;

    public InstCnt2() {
        instNum++;
        System.out.println("인스턴스 생성: " + instNum);
    }
}
```

다음 결과를 보면 알 수 있는 사실은 다음과 같다.

> 클래스 변수는 인스턴스 생성 이전에 메모리 공간에 존재한다.

<img src='images/스크린샷 2021-05-03 오전 10.39.32.png'>

결론을 말하자면, 클래스 변수는 해당 클래스 정보가 가상머신에 의해 읽히는 순간 메모리 공간에 할당되고 초기화된다. 그리고 한 가지 확실한 것은 이러한 할당과 초기화는 위의 예제에서 보이듯이 인스턴스의 생성과 무관하게 이뤄진다는 점이다. 따라서 다음과 같이 생성자를 통한 클래스 변수의 초기화를 진행하지 않도록 주의해야 한다.

```java
class InstCnt {
	static int instNum = 100; // 클래스 변수의 정상적인 초기화 방법
	InstCnt() {
		instNum = 0; // 클래스 변수의 초기화가 아니다!
	}
}
```

위의 클래스 변수 instNum은 100으로 초기화된다. 클래스 정보가 가상머신에 의해 읽히는 순간 100으로 초기화된다.

그런데 생성자 변수 instNum을 0으로 다시 초기화한다. 따라서 인스턴스가 생성될 때마다 instNum은 매번 그 값이 0으로 바뀌게 된다.

> 앞서 설명에서 클래스 정보를 가상 머신이 읽는다는 표현을 썼는데, 이렇듯 가상머신이 특정 클래스 정보를 읽는 행위를 가리켜 클래스 로딩이라 한다. 그리고 특정 클래스의 인스턴스 생성을 위해서는 해당 클래스가 반드시 가상머신에 의해 로딩되어야 한다. 즉 인스턴스 생성보다 클래스 로딩이 먼저이다.

• 클래스 변수를 언제 유용하게 활용할 것인가?

앞서 제시했던 예제를 통해서도 클래스 변수가 유용하게 활용되는 상황 한 가지를 짐작할 수 있다.

> 인스턴스 간에 데이터 공유가 필요한 상황에서 클래스 변수를 선언한다

그럼 이어서 클래스 변수가 유용하게 사용되는 사례를 하나 더 보이겠다.

이는 '클래스 내부와 외부에서 참조해야 할 정보'를 클래스 변수에 담은 예이다.

아래 예제에서 PI가 상수로 선언이 된다. PI가 지닌 값은 '원주율'로 결코 변하지 않는 값이기 때문이다. 그런데 인스턴스 변수가 아닌 '클래스 변수'로 선언되었다.

**이는 모든 Circle 인스턴스가 참조해야 하는 값이지만, 인스턴스가 각각 지녀야 하는 값은 아니기 때문이다.**

```java
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
```

### 08 Collection framework(컬레션 프레임워크)

#### • 프레임워크라는 표현의 이해

프레임워크(Framework)라는 표현은 여러 분야에서 상이한 개념으로 사용되기 때문에, 이에 대한 정확한 이미 파악이 쉽지 않을 수 있다. 하지만 기본적으로 다음 의미를 공통적으로 지닌다.

> 잘 정의된 구조 또는 골격

따라서 자바에서 말하는 프레임 워크는 다음과 같이 이해할 수 있다.

> 잘 정의된 구조의 클래스들

즉 프레임워크는 프로그래머들이 쓸 수 있도록 잘 정의된 클래스들의 모임이라 할 수 있다.

그런데, 이것이 전부라면 이는 '라이브러리'라 불리게 된다. 하지만 '컬렉션 라이브러리'라 하지 않고 '컬렉션 프레임워크'라 한다. 이는 컬렉션 관련된 클래스의 정의에 적용되는 설계 원칙 또는 구조가 존재하기 때문이다.

#### • 컬렉션의 의미와 자료구조

컴퓨터 분야에는 '자료구조(Data Structures)'와 '알고리즘(Algorithms)'이라는 학문이 있다. 이중 **'자료구조는 데이터의 저장 관련 학문으로 데이터의 탐색, 삭제 등 다양한 측면을 고려한 데이터의 효율적인 저장 방법을 연구하는 학문'**이다. 반면 **'알고리즘은 저장된 데이터의 일부 또는 전체를 대상으로 하는 각종 가공 및 처리의 방법을 연구하는 학문'**이다. 따라서 이 둘은 서로 다른 학문임에도 불구하고 긴밀히 연관되어 있다. 

자료구조에서 정형화하고 있는 데이터의 저장 방식 중 대표적인 몇 가지를 정리하면 다음과 같다.

리스트(List), 스택(Stack), 큐(Queue), 트리(Tree), 해쉬(Hash)

그리고 위 자료구조들을 대상으로 하는 비교적 간단한 알고리즘 몇 가지를 소개하면 다음과 같다.

버블 정렬(Bubble sort), 퀵 정렬(Quick Sort), 이진 탐색(Binary Search)

그렇다면 컬렉션 프레임워크는 무엇에 대한 프레임워크일까? 이는 데이터의 저장 방법 그리고 이와 관련 있는 알고리즘에 대한 프레임워크이다. 더 쉽게 표현하면, 위에서 언급한 자료구조와 알고리즘을 제네릭 기반의 클래스와 메소드로 미리 구현해 놓은 결과물이다. 따라서 컬렉션 프레임워크를 이용하면 자료구조를 몰라도 트리 기반으로 데이터를 저장할 수 있고, 알고리즘을 몰라도 이진 탐색을 수행할 수 있다.

#### • ArraList<E> 클래스

**List<E> 인터페이스를 구현하는 대표적인 컬렉션 클래스 둘은 다음과 같다.**

- ArrayList<E> : 배열 기반 자료구조, 배열을 이용하여 인터스턴스 저장
- LinkedList<E> : 리스트 기반 자료구조, 리스트를 구성하셔 인스턴스 저장

List<E> 인터페이스를 구현하는 컬렉션 클래스들이 갖는 공통적인 특성 두 가지가 있는데 이는 다음과 같다.

- 인스턴스의 저장 순서를 유지한다.
- 동일한 인스턴스의 중복 저장을 허용한다.

```java
List<DataMap> dataMapList = new ArrayList<>(); // 다음과 같이 제네릭 클래스로 <E>에 자료형을 넣어서 해당 자료형 클래스 변수를 생성한다. List의 경우 여러 자료형이 올 수 있으므로 이렇게 제네릭 클래스로 만드는게 효율적이라고 볼 수 있겠다.(추후 제네릭 클래스를 만들 때 참고 필요)
```

컬렉션 프레임워크의 저장, 참조, 삭제의 방법을 설명했는데, 실제로 컬렉션 프레임워크의 핵심은 이 세 가지이다. 그리고 예제에서 보였듯이 컬렉션 인스턴스를 사용하면 배열처럼 길이를 신경 쓰지 않아도 된다. ArrayList<E> 인스턴스는 내부적으로 배열을 생성해서 인스턴스를 저장하는데, 필요하면 그 배열의 길이를 스스로 늘리기 때문이다. 단 배열의 길이를 늘린다는 것은 더 긴 배열로의 교체를 의미한다. (한번 생성된 배열의 길이를 늘릴 수 없으므로) 따라서 성능에 신경을 써야 한다면 ArrayList<E>의 다음 생성자 정도는 알아 둘 필요가 있다.

```java
 // 인자로 전달된 수의 인스턴스를 저장할 수 있는 공간을 미리 확보
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
```

저장해야 할 인스턴스의 수가 대략 계산이 된다면 위의 생성자를 통해서 적당한 길이의 배열을 미리 만들어 두는 것이 성능 향상에 도움이 된다.

#### • 저장된 인스턴스 순차적 접근 방법 2

앞서 Collection<E>가 Iterable<T>를 상속한다고 하였다. 따라서 Collection<E>를 구현하는 자바의 제네릭 클래스는 Iterable<T>의 다음 추상 메소드를 모두 구현한다.

> Iterator<T> iterator()

이 메소드는 '반복자(Iterator)'라는 것을 반환한다. 반복자는 저장된 인스턴스들을 순차적으로 참조 할 때 사용하는 인스턴스로, 일종의 '지팡이'에 비유할 수 있다. 그리고 이 지팡이를 얻는 방법은 다음과 같다. (물론 이 지팡이의 역할은 저장된 인스턴스들을 가리키는 것이다.)

```java
public static void main(String[] args) {
	List<String> list = new LinkedList<>();
	∙∙∙∙
	Iterator<String> itr = list.iterator(); // 반복자 획득, itr이 지팡이를 참조한다.
}
```

위에서 얻은 지팡이를(반복자를) 통해 호출할 수 있는, Iterator<E> 메소드들은 다음과 같다.

- E next() : 다음 인스턴스의 참조 값을 반환
- boolean hasNext() : next 메소드 호출 시 참조 값 반환 가능 여부 확인
- void remove() : next 메소드 호출을 통해 반환했던 인스턴스 삭제

반복자는 next를 호출할 때마다 첫 번째 인스턴스를 시작으로 다음 인스턴스의 참조 값을 차례로 반환한다. 그리고 더 이상 반환할 대상이 없을 때 NoSuchElementException 예외를 발생시킨다. 따라서 저장된 인스턴스에 차례로 접근할 때에는 다음과 같은 반복문을 구성해야 한다.

```java
while(itr.hasNext()) { // next 메소드가 반환할 대상이 있다면,
	str = itr.next() //next 메소드를 호출한다.
}
```

hasNext는 반환할 대상이 있는지 미리 확인하는 메소드이다. 즉 이 메소드는 반환할 인스턴스가 있으면 true, 그렇지 않으면 false를 반환한다. 따라서 위와 같이 next 호출 이전에 hasNext를 호출하여 next 호출의 성공 가능성을 미리 확인해야 한다. **그리고 앞서 소개한 for-each문을 통한 순차적 접근과 달리 반복자를 이용하면 반복 중간에 특정 인스턴스를 삭제하는 것이 가능하다. (이는 for-each문을 통해서는 불가능한 일이다.) 그 예로 다음 코드를 실행하면, 저장된 문자열 중 "Box"를 모두 지울 수 있다.**

```java
while(itr.hasNext()) { // next 메소드가 반환할 대상이 있다면,
	str = itr.next() //next 메소드를 호출한다.
	if(str.equals("Box"))
		itr.remove() // 위에서 next 메소드가 반환한 인스턴스 삭제
}
```

이러한 반복자는 생성과 동시에 첫 번째 인스턴스를 가리키고, next가 호출될 때마다 가리키는 대상이 다음 인스턴스로 옮겨진다. 그렇다면 이 반복자를 원하는 때에 다시 첫 번째 인스턴스를 가리키게 하려면 어떻게 해야 할까? **가리키던 위치를 되돌리는 방법은 없으니 다음과 같이 반복자를 다시 얻어야 한다.**

```java
Iterator<String> itr = list.iterator()
```

그럼 다음 예제를 통해서 지금까지 설명한 내용을 정리해보겠다.

```java
public class IteratorCollection {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Toy");
        list.add("Box");
        list.add("Robot");
        list.add("Box");

        Iterator<String> iterator = list.iterator(); // 반복자 처음 획득

        while(iterator.hasNext())
            System.out.print(iterator.next() + '\t');
        System.out.println();

        iterator = list.listIterator(); // 반복자 다시 획득

        String str;
        while(iterator.hasNext()) {
            str = iterator.next();
            if(str.equals("Box"))
                iterator.remove();
        }

        iterator = list.iterator(); // 반복자 다시 획득

        while(iterator.hasNext())
            System.out.print(iterator.next() + '\t');
        System.out.println();
    }
}
```
#### • 배열 보다는 컬렉션 인스턴스가 좋다 : 컬렉션 번환

배열과 ArrayLIst<E>는 특성이 유사하다. (ArrayList<E>가 배열을 기반으로 인스턴스를 저장하므로) 그런데 대부분의 경우 배열보다 ArrayList<E>가 좋다. 첫 번째 이유로 인스턴스의 저장과 삭제가 편하다. 그리고 두 번째 이유로 '반복자'를 쓸 수 있다. 단 배열처럼 '선언과 동시에 초기화'를 할 수 없어서 초기에 무엇인가를 채워 넣는 일이 조금 번거롭다. 하지만 다음과 같이 컬렉션 인스턴스를 생성할 수 있어서 이것도 문제가 되지 않는다.

```java
List<String> list = Array.asList("Toy", "Robot", "Box"); // 인자로 전달된 인스턴스들을 저장한 컬렉션 인스턴스의 생성 및 반환
```

그런데 이렇게 생성된 컬렉션 인스턴스는 새로운 인스턴스의 추가나 삭제가 불가능하다. 물론 반복자의 생성은 가능하나 이를 통해서도 참조만 가능할 뿐이다. 따라서 새로운 인스턴스의 추가나 삭제가 필요한 상황이라면 다음 생성자를 기반으로  ArrayList<E>를 생성해야 한다.

#### • 기본 자료형 데이터의 저장과 참조

컬렉션 인스턴스도 기본 자료형의 값은 저장하지 못한다. 그러나 래퍼 클래스의 도움으로 이들 값의 저장 및 참조가 가능하며, 이 과정에서 오토 박싱과 오토 언박싱으로 인해 자연스러운 코드의 구성이 가능하다.

```java
public class PrimitiveCollection {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
      	// 저장 과정에서 오토 박싱 진행
        integerLinkedList.add(10); integerLinkedList.add(20); integerLinkedList.add(30);

        int n;
        for (Iterator<Integer> itr = integerLinkedList.iterator(); itr.hasNext();) {
            n = itr.next(); // 오토 언박싱 진행
            System.out.print(n + "\t");
        }
        System.out.println();

    }
}
```

#### • Set<E>을 구현하는 클래스의 특성과 HashSet<E> 클래스

Set<E>  인터페이스를 구현하는 제네릭 클래스의 특성 두 가지를 정리하면 다음과 같다.

- 저장 순서가 유지되지 않는다.
- 데이터의 중복 저장을 허용하지 않는다.

List<E>를 구현하는 컬렉션 인스턴스에 저장된 데이터를 반복자를 통해 출력해보면 저장된 순서대로 출력됨을 확인할 수 있다. 그리고 앞서 예제에서 "Box"를 두 번 저장하였는데, 두 번 모두 저장됨을 출력 결과에서 확인할 수 있었다. 하지만 Set<E>를 구현하는 클래스는 다르다. 순서도 유지되지 않고 중복도 허용하지 않는다. 그리고 이는 Set이라는 이름처럼 수학에서 말하는 '집합'의 특성이다. 그럼 이와 관련하여 다음 예제를 보자. 이 예제에서는 Set<E>를 구현하는 대표 클래스 HashSet<E>의 사용 예를 보여준다.

### 09 Exception Handling

#### • 자바에서 말하는 예외

프로그램 실행 중에 발생하는 '예외적인 상황'을 줄여서 '예외'라 한다. 즉 예외는 단순한 문법 오류가 아닌, 실행 중간에 발생하는 '정상적이지 않은 상황'을 뜻한다.

```java
package exception_handling;

import java.util.Scanner;

public class ExceptionCase {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("a/b...a?");
        int n1 = kb.nextInt();
        System.out.println("a/b...b");
        int n2 = kb.nextInt();
        System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
        System.out.println("Good bye~~!");
    }
}
```

<img src='images/스크린샷 2021-05-15 오후 11.00.39.png'>

위 예제 코드는 문법적으로 논리적으로 문제가 없다. 문제는 나누느 수가 0이 될 수 없음에도 부룩하고 0을 입력한 프로그램 사용자에게 있다. 그리고 이러한 상황을 가리켜 '예외'라 한다. 예외 발생 순간에 프로그램이 종료된 사실에 주목하자. 그리고 친절한 상황 설명은 아니지만 출려된 문장을 통해서 다음 사실 정도는 알 수 있다.

"0으로 / 연산을 하여 java.lang.ArithmeticException 예외가 발생하였다."

이는 가상머신이 예외 상황을 처리하는 방식이다. 즉 가상머신은 예외가 발생하면 그 내용을 간단히 출력하고 프로그램을 종료해버린다.

그리고 위 예제는 실행 과정에서 다른 예외가 발생할 수도 있다. 이와 관련하여, 예제의 실행 중간에 숫자의 입력을 바라며 다음 내용을 출력하였다.

**a/b...a?**

따라서 숫자의 입력을 기대하고 다음과 같이 사용자의 입력을 읽어 들인다.

**int n1 = kb.nextInt();**

#### • try로 감싸야 할 영역의 결정

```java
try {
	1. ...
	2. 예외 발생 지점
	3. ...
} catch(Exception e) {
	...
}
4. 예외 처리 이후 실행 지점
```

숫자 3의 위치에서 실행을 이어가는 것이 아니라, try ~ catch 문 전체를 건너뛰어 숫자 4의 위치에서 실행을 이어가게 되는데, 이러한 예외 처리 이후의 실행 특성은 관련이 있는 작업들을 하나로 묶는데 도움이 된다. 그럼 지금 설명한 내용을 고려하여 입력 오류에 대한 try ~ catch문을 다음 예제에 확실히 삽입해보자.

```java
package exception_handling;

import java.util.Scanner;

public class ExceptionCase {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("a/b...a?");
        int n1 = kb.nextInt(); // 입력 오류 발생 가능
        System.out.println("a/b...b");
        int n2 = kb.nextInt(); // 입력 오류 발생 가능
        System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
        System.out.println("Good bye~~!");
    }
}
```

예제에서 입력 오류로 인한 InputMismatchException 예외가 발생할 수 있는 문장은 다음 둘이다.

**int n1 = kb.nextInt();**

**Int n2 = kb.nextInt();**

따라서 이들 각각에 대해 try ~ catch문을 구성하는 것도 생각해 볼 수 있다. 그러나 변수 n1의 값이 적절히 들어오지 않는다면 변수 n2의 값을 입력받는 것도, / 연산을 진행하는 것도 의미가 없다. 즉 다음 문장들은 하나의 작업으로 볼 수 있다.

```java
// 아래 문장은 '하나의 작업'에서 제외 가능
System.out.println("a/b...a?");
int n1 = kb.nextInt(); // 입력 오류 발생 가능
System.out.println("a/b...b");
int n2 = kb.nextInt(); // 입력 오류 발생 가능
System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
```

```java
package exception_handling;

import java.util.Scanner;

public class ExceptionCase {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
      	try{
            System.out.println("a/b...a?");
            int n1 = kb.nextInt(); // 입력 오류 발생 가능
            System.out.println("a/b...b");
            int n2 = kb.nextInt(); // 입력 오류 발생 가능
            System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
        } catch (InputMismatchException e) {
          e.getMessage();
        }
        System.out.println("Good bye~~!");
    }
}
```

#### • 둘 이상의 예외를 처리하기 위한 구성

앞서 제시한 나눗셈 관련 예제에서는 다음 두 가지의 예외의 발생 가능성이 있다.

**Java.lang.ArithmeticException**

**Java.lang.InputMismatchException**

따라서 이 둘에 대해서 모두 예외 처리를 하고자 한다면, 다음에서 보이는 바와 같이 catch 구문 둘을 이어서 구성하면 된다.

```java
package exception_handling;

import java.util.Scanner;

public class ExceptionCase {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
      	try{
            System.out.println("a/b...a?");
            int n1 = kb.nextInt(); // 입력 오류 발생 가능
            System.out.println("a/b...b");
            int n2 = kb.nextInt(); // 입력 오류 발생 가능
            System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
        } catch (InputMismatchException e) {
          e.getMessage();
        } catch (ArithmeticException e) {
          e.getMessage();
        }
        System.out.println("Good bye~~!");
    }
}
```

예제에서 보이듯이 catch 구문을 얼마든지 이어서 구성할 수 있다. 그런데 자바 7 부터는 다음과 같이 하나의 catch 구문 안에서 둘 이상의 예외를 처리하는 것도 가능하다.

```java
package exception_handling;

import java.util.Scanner;

public class ExceptionCase {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
      	try{
            System.out.println("a/b...a?");
            int n1 = kb.nextInt(); // 입력 오류 발생 가능
            System.out.println("a/b...b");
            int n2 = kb.nextInt(); // 입력 오류 발생 가능
            System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2);
        } catch (AlithmeticException | InputMismatchException e) {
          e.getMessage();
        }
        System.out.println("Good bye~~!");
    }
}
```

따라서 상황 별 예외의 처리 방식이 다르지 않을 경우, 위와 같이 하나의 catch 구문 안에서 모든 예외가 처리될 수 있도록 묶는 것도 유용한 선택이 될 수 있다.

#### • Throwable 클래스와 예외처리의 책임 전가

자바의 최상위 클래스인 java.lang.Object를 제외하고 예외 클래스의 최상위 클래스는 다음과 같다.

**java.lang.Throwable** 예외 클래스의 최상위 클래스

그리고 이 클래스에는 발생한 예외의 정보를 알 수 있는 메소드가 정의되어 있는데, 대표적인 메소드 둘은 다음과 같다.

**public String getMessage()**

​	→ 예외의 원인을 담고 있는 문자열을 반환

**public String printStackTrace()**

​	→ 예외가 발생한 위치와 호출된 메소드의 정보를 출력

```java
package exception_handling;

public class ExceptionMessage {
    public static void md1(int n) {
        md2(n, 0); // 아래의 메소드 호출
    }

    public static void md2(int n1, int n2) {
        int r = n1 / n2; // 예외 발생 지점
    }

    public static void main(String[] args) {
        md1(3);
        System.out.println("Good bye~~!");
    }
}
```

<img src='images/스크린샷 2021-05-15 오후 11.31.59.png'>

위 예제의 메소드 호출 흐름은 다음과 같다.

main → md1 → md2

그리고 예외는 md2에서 발생하였다. 그런데 md2에서 해당 에외를 처리하지 않았다. 이러한 경우 가상머신은 md2를 호출한 md1에게 예외처리의 책임을 넘긴다.(예외처리의 책임이 넘어가면 예외철의 책임을 넘긴 메소드의 호출은 종료가 된다.) 이렇듯 예외는 처리되지 않으면 그 책임이 넘어간다. 그리고 그 끝은 main이다. 그리고 main 조차 예외처리를 하지 않으면 가상 머신이 대신 예외를 처리한다. 물론 그 방법은 앞서 수차례 보았듯이 예외 관련 메시지의 출력과 프로그램의 종료이다. 그럼 실행 결과에서 보이는 내용의 의미를 정리해보겠다.

```java
Connected to the target VM, address: '127.0.0.1:54403', transport: 'socket'
		// :0으로 / 연산을 하여 ArithmeticException 발생하였다.
  Exception in thread "main" java.lang.ArithmeticException: / by zero
    // :ExceptionMessage 클래스의 md2에서 예외가 시작되었고
	at exception_handling.ExceptionMessage.md2(ExceptionMessage.java:9)
    // :ExceptionMessage 클래스의 md1으로 예외가 넘어갔으며
	at exception_handling.ExceptionMessage.md1(ExceptionMessage.java:5)
    // :ExceptionMessage 클래스의 main으로까지 예외가 넘어갔다. 
	at exception_handling.ExceptionMessage.main(ExceptionMessage.java:13)
Disconnected from the target VM, address: '127.0.0.1:54403', transport: 'socket'

Process finished with exit code 1
```

#### • Exception을 상속하는 예외 클래스의 예외처리

```java
package exception_handling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOExceptionCase {
    public static void main(String[] args) {
        Path file = Paths.get("/java-test/Simple.txt");
        BufferedWriter writer = null;

        try {
            writer = Files.newBufferedWriter(file); // IOException 발생 가능
            writer.write('A'); // IOException 발생 가능
            writer.write('Z'); // IOException 발생 가능

            if(writer != null)
                writer.close(); // IOException 발생 가능

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

위 예제는 다음 경로의 파일을 생성해서, 그 안에 두 개의 문자를 저장하고 끝을 맺는 예제이다.

단, 파일은 자동으로 생성되지만 경로는 자동으로 생성되지 않기 때문에 /java-test 라는 디렉토리가 존재하는 상태에서 위 예제를 실행해야 한다. 그러면 파일이 생성되고 이 파일이 열려서 문자가 저장이 된다.