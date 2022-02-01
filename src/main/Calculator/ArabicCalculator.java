package main.Calculator;

import java.io.IOException;

public class ArabicCalculator extends Calculator{

    private int convertToInt(String a) {
        return Integer.parseInt(a);
    }

    @Override
    public void calculate(String first_number, String second_number, String operation) throws IOException{
        int result = switch (operation) {
            case "+" -> addition(convertToInt(first_number), convertToInt(second_number));
            case "-" -> subtraction(convertToInt(first_number), convertToInt(second_number));
            case "*" -> multiplication(convertToInt(first_number), convertToInt(second_number));
            case "/" -> division(convertToInt(first_number), convertToInt(second_number));
            default -> throw new IOException();
        };

        System.out.println(result);
    }
}
