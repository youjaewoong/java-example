package enums.message;

import java.util.ArrayList;
import java.util.List;

public class BusinessDetails {
	public static String returnDetails(BusinessCode code, Object... args) {

		List<String> list = new ArrayList<>();
		for (Object arg : args) {
			if (arg instanceof String) {
				list.add((String) arg);
			}
		}
		list.add(code.getMessage());
		return String.join(", ", list);
	}
}
