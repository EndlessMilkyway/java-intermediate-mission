package com.endlessmilkyway.tasks.task03.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

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
