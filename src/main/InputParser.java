package main;

import main.Calculator.ArabicCalculator;
import main.Calculator.Calculator;
import main.Calculator.RomanCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputParser {
    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();

                if (input.equals("q")) {
                    break;
                }

                String operation = "";
                if (input.contains("+")) {
                    operation = "+";
                } else if (input.contains("-")) {
                    operation = "-";
                } else if (input.contains("*")) {
                    operation = "*";
                } else if (input.contains("/")) {
                    operation = "/";
                }

                if (operation.equals("")) {
                    throw new Exception("Input is not valid");
                }

                String first_number = input.substring(0, input.indexOf(operation)).trim();
                String second_number = input.substring(input.indexOf(operation) + 1).trim();

                if (Validator.isValidNumeric(first_number) && Validator.isValidNumeric(second_number)) {
                    Calculator calculator = new ArabicCalculator();
                    calculator.calculate(first_number, second_number, operation);
                } else if (Validator.isValidRoman(first_number) && Validator.isValidRoman(second_number)) {
                    Calculator calculator = new RomanCalculator();
                    calculator.calculate(first_number, second_number, operation);
                } else {
                    throw new Exception("Input is not valid");
                }
            }
        }
    }

}
