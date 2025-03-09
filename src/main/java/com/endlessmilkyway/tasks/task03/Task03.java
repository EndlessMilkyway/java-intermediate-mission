package com.endlessmilkyway.tasks.task03;

import com.endlessmilkyway.tasks.task03.view.InputView;

public class Task03 {

    private static final int CAPITAL_A_ASCII = 65;
    private static final int CAPITAL_Z_ASCII = 90;
    private static final int SMALL_A_ASCII = 97;
    private static final int SMALL_Z_ASCII = 122;
    private static final int NUMBER_FOR_CONVERT_CASE = 32;

    public void run() {
        InputView inputView = InputView.getInstance();
        String input = inputView.getStringFromConsole();

        reverseString(input);
        convertCharacterCase(input);
    }

    private void reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        String reversedInput = sb.reverse().toString();

        System.out.println(reversedInput);
    }

    private void convertCharacterCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            convert(sb, c);
        }

        System.out.println(sb);
    }

    private void convert(StringBuilder sb, char c) {
        if (CAPITAL_A_ASCII <= c && c <= CAPITAL_Z_ASCII) {
            sb.append((char) (c + NUMBER_FOR_CONVERT_CASE));
        } else if (SMALL_A_ASCII <= c && c <= SMALL_Z_ASCII) {
            sb.append((char) (c - NUMBER_FOR_CONVERT_CASE));
        } else {
            sb.append(c);
        }
    }
}
