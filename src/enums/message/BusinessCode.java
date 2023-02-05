package enums.message;

public interface BusinessCode {

	String getMessage();

	default String getMessage(Object... args) {
		return String.format(this.getMessage(), args);
	}
}
