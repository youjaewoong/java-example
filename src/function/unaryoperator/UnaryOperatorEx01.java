package function.unaryoperator;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * <pre>
 * UnaryOperator<T>
 * Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
 * 반환값 : T
 * </pre>
 */
public class UnaryOperatorEx01 {
	public static void main(String[] args) {
		UnaryOperator<Integer> plus10 = (i) -> i + 10;
		UnaryOperator<Integer> multiply2 = (i) -> i * 2;
		System.out.println(plus10.andThen(multiply2).apply(2));
	}
}
