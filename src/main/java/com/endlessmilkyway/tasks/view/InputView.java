package com.endlessmilkyway.tasks.view;

import com.endlessmilkyway.tasks.util.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    private static final String INPUT_ARRAY_LENGTH_MSG = "배열의 길이를 입력해주세요 : ";
    private static final String INPUT_ARRAY_ELEMS_MSG = "배열의 항목들을 입력해주세요(띄어쓰기로 구분) : ";

    private static final String INPUT_NUMBERS_MSG = "계산할 두 개의 숫자를 입력해주세요 : ";
    private static final String INPUT_OPERATOR_MSG = "어떤 연산을 수행하시겠습니까? (+, -, *, /, **) : ";

    private static final String INPUT_STRING_MSG = "문자열을 입력해주세요 : ";

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public int getArrayLengthFromConsole() {
        int length = 0;
        try {
            System.out.print(INPUT_ARRAY_LENGTH_MSG);
            length = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return length;
    }

    public String getArrayElemsFromConsole() {
        String elems = "";
        try {
            System.out.print(INPUT_ARRAY_ELEMS_MSG);
            elems = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return elems;
    }

    public List<Long> getNumbersFromConsole() {
        List<Long> numbers = new ArrayList<>();
        try {
            System.out.print(INPUT_NUMBERS_MSG);
            String input = br.readLine();

            Validator.validInput(input);

            StringTokenizer st = new StringTokenizer(input, " ");
            Validator.validateElemsCount(st.countTokens());

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                numbers.add(Long.parseLong(s));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }

    public String getOperatorFromConsole() {
        String operator = "";
        try {
            System.out.print(INPUT_OPERATOR_MSG);
            operator = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return operator;
    }

    public String getStringFromConsole() {
        String input = "";
        try {
            System.out.print(INPUT_STRING_MSG);
            input = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return input;
    }
}
