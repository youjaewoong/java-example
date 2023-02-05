package object;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * object
 */
public class ObjectEx01 {

	public static void main(String[] args) {
		String nullString = null;
		Objects.requireNonNull(nullString, "입력이 null 입니다!");

	}



}

