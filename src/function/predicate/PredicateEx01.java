package function.predicate;

import java.util.function.Predicate;

/**
 * <pre>
 * Predicate<T>
 * T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
 *  - boolean test(T t)
 * 함수 조합용 메소드
 *  - And, Or, Negate
 * </pre>
 */
public class PredicateEx01 {
	public static void main(String[] args) {
		Predicate<String> startsWith1 = (s) -> s.startsWith("pre1");
		Predicate<String> startsWith2 = (s) -> s.startsWith("pre2");
		Predicate<String> startsWith3 = (s) -> s.startsWith("pre1");
		Predicate<Integer> isEven = (s) -> s%2 == 0;
		System.out.println(startsWith1.and(startsWith2).test("pre1")); //false
		System.out.println(startsWith1.or(startsWith2).test("pre1")); //true
		System.out.println(startsWith1.and(startsWith3).test("pre1")); //true
		System.out.println(isEven.test(2)); //true
	}
}
