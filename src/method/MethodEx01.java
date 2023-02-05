package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodEx01 {

	public static void main(String[] args) {

		System.out.println("forEach 내부 null 체크 포함");
		List<String> names = new ArrayList<>();
		names.add("A");
		names.add("B");
		names.forEach(System.out::println);

		System.out.println("pliterator trySplit() 를 사용하면 반씩 나누어 로직처리가 가능하다.");
		Spliterator<String> spliterator = names.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println));
		System.out.println("=========");
		while (spliterator1.tryAdvance(System.out::println));

		System.out.println("removeIf 사용하여 리스트의 특정요소 제거");
		names.removeIf(name -> name.equals("A"));
		names.forEach(System.out::println);
	}


}
