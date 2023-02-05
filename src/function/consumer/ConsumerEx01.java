package function.consumer;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <pre>
 * Consumer<T>
 * T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
 * 반환값 : void Accept(T t)
 * 함수조합용 : andThen
 * </pre>
 */
public class ConsumerEx01 {
	public static void main(String[] args) {
		Consumer<Integer> printT = (i) -> System.out.println(i);
		printT.accept(10);
	}
}
