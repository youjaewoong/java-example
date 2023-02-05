package enums.message;

import java.util.function.BiFunction;

public enum Business implements BusinessCode {
	TEST("test", BusinessDetails::returnDetails);

	private final String message;
	private final BiFunction<BusinessCode, Object[], String> details;

	Business(String message, BiFunction<BusinessCode, Object[], String> details) {
		this.message = message;
		this.details = details;}

	public String businessApply(Object... args) {
		return details.apply(this, args);
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
