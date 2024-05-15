package enums.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Year;

public class GeneratorKey {

    @AllArgsConstructor
    public enum CodePrefix {
        KS("KS"),
        ;
        // 다른 값들도 추가할 수 있습니다.
        @Getter
        String type;
    }

    public static String getCurrentYear() {
        return Year.now().toString();
    }

    public static String generateKey(CodePrefix prefix, int maxCodeNumber) {
        String currentYear = getCurrentYear();
        int newNumber = maxCodeNumber + 1;
        String formattedNumber = String.format("%04d", newNumber); // 4자리로 변경

        if (Integer.parseInt(formattedNumber) > 9999) {
            throw new IllegalArgumentException("key 값이 9999 를 넘어갔습니다.");
        }
        return prefix.getType() + "-" + currentYear + "-" + formattedNumber;
    }

}
