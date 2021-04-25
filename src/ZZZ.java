/**
 * 상속한 AAA의 경우 다른 패키지에 있고
 * ZZZ class의 경우 default package에 속한 상태이다.
 * 그러나 만약 AAA class의 int num을 default로 둔다면 num에 전달인자 n 값을 저장할 수가 없다.
 * 그러나 protected int num으로 AAA 클래스에서 선언하면 protected로 선언된 멤버는 상속 관계에 있는 다른 클래스에서 접근이 가능하다.
 * 그리고 이러한 접근은 상속 관계에 있는 두 클래스가 서로 다른 패키지로 묶여 있어도 가능하다.
 */
public class ZZZ extends alpha.AAA{
    public void init(int n) {
        num = n;
    }
}
