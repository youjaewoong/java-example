package enums.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Year;

public class GeneratorKeyMain {

    public static void main(String[] args) {

        System.out.println("GeneratorKey :::" + GeneratorKey.generateKey(GeneratorKey.CodePrefix.KS, 44));
    }
}
