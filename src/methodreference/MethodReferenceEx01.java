package methodreference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * method reference
 */
public class MethodReferenceEx01 {

	public static void main(String[] args) {
		// static method reference
		UnaryOperator<String> hiGreeting1 = Greeting::hi;
		System.out.println(hiGreeting1.apply("greeting"));

		// instance method reference
		String[] names = {"John", "Mary"};
		Arrays.sort(names, String::compareToIgnoreCase);

		// 문자열을 안받는 constructor reference
		Supplier<Greeting> greeting1 = Greeting::new;
		greeting1.get();

		// 문자열을 받는 constructor reference
		Function<String, Greeting> greeting2 = Greeting::new;
		greeting2.apply("hi");
	}

	public static class Greeting {
		public Greeting() {
			System.out.println("문자열을 안받는 constructor reference");
		}
		public Greeting(String s) {
			System.out.println(String.format("%s 문자열을 받는 constructor reference", s));
		}

		public static String hi(String hi) {
			return "Hi, " + hi;
		};
	}

}
