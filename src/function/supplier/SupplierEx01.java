package function.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <pre>
 * Supplier<T>
 * T 타입의 값을 제공하는 함수 인터페이스
 * 반환값 : T get()
 * </pre>
 */
public class SupplierEx01 {
	public static void main(String[] args) {
		Supplier<Integer> get10 = () -> 10;
		System.out.println(get10.get());
	}
}
