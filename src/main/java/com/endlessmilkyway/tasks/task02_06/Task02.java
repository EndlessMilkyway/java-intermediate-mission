package com.endlessmilkyway.tasks.task02_06;

import com.endlessmilkyway.tasks.view.InputView;
import java.util.List;
import java.util.function.BiConsumer;

public class Task02 {

    private static final String HEADER = "연산 결과는 ";
    private static final String FOOTER = " 입니다.";

    public void run() {
        InputView inputView = InputView.getInstance();
        List<Long> numbers = inputView.getNumbersFromConsole();

        String operator = inputView.getOperatorFromConsole();

        switch (operator) {
            case "+":
                BiConsumer<Long, Long> sum = (x, y) -> System.out.println(HEADER + (x + y) + FOOTER);
                sum.accept(numbers.get(0), numbers.get(1));
                break;
            case "-":
                BiConsumer<Long, Long> subtract = (x, y) -> System.out.println(HEADER + (x - y) + FOOTER);
                subtract.accept(numbers.get(0), numbers.get(1));
                break;
            case "*":
                BiConsumer<Long, Long> multiple = (x, y) -> System.out.println(HEADER + (x * y) + FOOTER);
                multiple.accept(numbers.get(0), numbers.get(1));
                break;
            case "/":
                BiConsumer<Long, Long> divide = (x, y) -> System.out.println(HEADER + ((double) x / y) + FOOTER);
                divide.accept(numbers.get(0), numbers.get(1));
                break;
            case "**":
                BiConsumer<Long, Long> square = (x, y) -> System.out.println(HEADER + Math.pow(x, y) + FOOTER);
                square.accept(numbers.get(0), numbers.get(1));
        }
    }
}
