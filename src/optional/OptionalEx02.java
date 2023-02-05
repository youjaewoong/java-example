package optional;

import static optional.OptionalEx01.OptionalMain.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * grouping method
 */
public class OptionalEx02 {

	public static void main(String[] args) {
		/**
		orElse
		  파라미터로 값을 받는다
		  값이 미리 존재하면 쓴다.
		orElseGet
		  파라미터로 supplier(함수형 인터페이스)를 필요로 한다.
		  값이 없으면 orElseGet을 사용한다.
		 **/
		// null 일때만 실행되는 orElseGet
		String check = null;
		String result = Optional.ofNullable(check).orElse(testFunction());
		System.out.println("첫번째: "+result);
		String result02 = Optional.ofNullable(check).orElseGet(()->testFunction());
		System.out.println("두번째: "+result02);

		List<String> data = DataGenerator.getList();
		String Value1 = data.stream().filter(p-> p.equals("1")).findAny().orElseGet(()->"orElseGet");
		String value2 = data.stream().filter(p-> p.equals("4")).findAny().orElseGet(()->"orElseGet");
		System.out.println(Value1);
		System.out.println(value2);

		// size check
		boolean isArrears = Optional.ofNullable(data)
								  .orElseGet(List::of)
								  .size() > 1;

		System.out.println("isArrears ::" + isArrears);

		System.out.println("=================================");


	}

	public static String testFunction(){
		System.out.println("testFunction() 실행");
		return "강아지";
	}

	public static class DataGenerator {
		static List<String> getList() {
			return Arrays.asList("aa", "bb", "cc", "dd");
		};
	}


}

