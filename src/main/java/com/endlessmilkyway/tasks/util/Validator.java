package com.endlessmilkyway.tasks.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validInput(String input) {
        if (!Validator.validate(input)) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다!");
        }
    }

    public static boolean validate(String str) {
        Pattern pattern = Pattern.compile("^[\\d\\s]+$");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public static void validateElemsCount(int count) {
        if (count != 2) {
            throw new IllegalArgumentException("[ERROR] 2개의 숫자를 입력하셔야 합니다!");
        }
    }
}
