package function.function;

import java.util.function.Function;

/**
 * <pre>
 * Function<T, R>
 * T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
 * 반환값 : R apply(T t)
 * </pre>
 */
public class FunctionEx01 {
	public static void main(String[] args) {
		Function<Integer, Integer> plus10 = (i) -> i + 10;
		Function<Integer, Integer> multiply2 = (i) -> i * 2;

		// compose 뒤에꺼 먼지 실행 후 앞에꺼 실행
		Function<Integer, Integer> multply2AndPlus1 = plus10.compose(multiply2);

		// andThen 앞에꺼 먼저 실행 후 뒤에꺼 실행
		Function<Integer, Integer> multply2AndPlus2 = plus10.andThen(multiply2);

		// R apply(T t)
		System.out.println(multply2AndPlus1.apply(2));
		System.out.println(multply2AndPlus2.apply(2));
	}

}
