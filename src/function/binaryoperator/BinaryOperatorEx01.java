package function.binaryoperator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * <pre>
 * BinaryOperator<T>
 * BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
 * </pre>
 */
public class BinaryOperatorEx01 {
	public static void main(String[] args) {
		// BiFunction
		BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
		Integer result = func.apply(2, 3);
		System.out.println(result); // 5

		// BinaryOperator
		BinaryOperator<Integer> func2 = (x1, x2) -> x1 + x2;
		Integer result2 = func.apply(2, 3);
		System.out.println(result2); // 5

		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		Integer result3 = math(Arrays.asList(numbers), 0, (a, b) -> a + b);
		System.out.println(result3); // 55

		Integer result4 = math(Arrays.asList(numbers), 0, Integer::sum);
		System.out.println(result4); // 55
	}
	public static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator) {
		T result = init;
		for (T t : list) {
			result = accumulator.apply(result, t);
		}
		return result;
	}
}
