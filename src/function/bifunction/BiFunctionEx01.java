package function.bifunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * BiFunction<T, U, R>
 * 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
 * 반환값 : R apply(T t, U u)
 */
public class BiFunctionEx01 {
	public static void main(String[] args) {
		// takes two Integers and return an Integer
		BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
		Integer result = func.apply(2, 3);
		System.out.println(result); // 5

		// take two Integers and return a List<Integer>
		BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);
		List<Integer> result3 = func3.apply(2, 3);
		System.out.println(result3);

	}
}
