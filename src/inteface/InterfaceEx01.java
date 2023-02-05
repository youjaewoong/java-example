package inteface;

import java.util.function.Supplier;

public class InterfaceEx01 {

	public static void main(String[]args) {
		Supplier<PrintName> printName = PrintName::new;
		printName.get().printNameUpperCase();
	}

	public static class PrintName implements PrintNameInterface {
		@Override
		public String getName() {
			return "hi";
		}

		/**
		 * default method 를 재정의 할수 있습니다.
		 */
		@Override
		public void printNameUpperCase() {
			System.out.println(getName().toLowerCase());
		}
	}

	public interface PrintNameInterface {

		/**
		 * @ImplSpec
		 * @implSpec 자바독 태그 필수
		 */
		default void printNameUpperCase() {
			System.out.println(getName().toUpperCase());
		}

		String getName();
	}
}


