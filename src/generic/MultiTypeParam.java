package generic;

public class MultiTypeParam {
    public static void main(String[] args) {
        DBox<String, Integer> dBox = new DBox<>();
        dBox.set("Apple", 25);
        System.out.println(dBox);
    }

}

/**
 * 다음과 같이 type 매개변수의 이름을 여러개 정의할 수 있다.
 * 타입 매개변수의 이름은 짓기 나름이다. 그러나 일반적으로 다음 두 가지 규칙을 지켜서 이름을 짓는다.
 * 1. 한 문자로 이름을 짓는다.
 * 2. 대문자로 이름을 짓는다.
 *
 * 한글자로 이름을 짓더라도 가급적 의미를 두어 이름을 짓는 것이 좋다.
 * 보편적으로 자주 사용하는 타입 매개변수의 이름과 그 의미는 다음과 같으니 이를 주로 사용하는 것도 괜찮은 선택이다.
 *
 * E - Element
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 *
 * @param <L> - Left
 * @param <R> - RIght
 */
class DBox<L, R> {
    private L left;
    private R right;

    public void set(L l, R r) {
        left = l;
        right = r;
    }

    @Override
    public String toString() {
        return left + " & " + right;
    }
}