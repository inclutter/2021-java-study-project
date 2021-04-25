# 2021-java-study-project
2021 repository for java study

## 01 Java wrapper class

<img src='images/스크린샷 2021-04-24 오후 11.34.05.png'>

## 02 Java package naming

<img src='images/스크린샷 2021-04-25 오후 3.16.47.png'>

## 03 접근 수준 지시자(Access-level Modifiers)

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

### • 클래스 정의 대상의 pulbic과 default 선언이 갖는 의미

`public class AAA { // 클래스의 pulbic 선언`

`}`

`class ZZZ { // 클래스의 default 선언`

`}`

- 정리하면, 클래스 정의에 대한 public과 default 선언이 갖는 의미는 다음과 같다.
  - public
    - 어디서든 인스턴스 생성이 가능하다.
  - default
    - 동일 패키지로 묶인 클래스 내에서만 인스턴스 생성을 허용한다.

<img src='images/img.png'>

