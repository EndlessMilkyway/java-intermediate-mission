package com.endlessmilkyway.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

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
            System.out.print("배열의 길이를 입력해주세요 : ");
            length = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return length;
    }

    public String getArrayElemsFromConsole() {
        String elems = "";
        try {
            System.out.print("배열의 항목들을 입력해주세요(띄어쓰기로 구분) : ");
            elems = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return elems;
    }
}
