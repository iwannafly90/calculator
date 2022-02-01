package main.Calculator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public class RomanCalculator extends Calculator{
    public static final HashMap<Character,Integer> romanSymbolsMap = new HashMap<>();
    static {
        romanSymbolsMap.put('I',1);
        romanSymbolsMap.put('V',5);
        romanSymbolsMap.put('X',10);
        romanSymbolsMap.put('L',50);
        romanSymbolsMap.put('C',100);
        romanSymbolsMap.put('D',500);
        romanSymbolsMap.put('M',1000);
    }

    public static String convertToRoman(int number) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0; i<values.length; i++) {
            while(number >= values[i]) {
                number -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public int convertFromRomanToInt(String romanSymbol) {
        int sum = 0;
        int n = romanSymbol.length();

        for(int i = 0; i < n; i++)
        {
            if (i != n - 1 && romanSymbolsMap.get(romanSymbol.charAt(i)) <
                    romanSymbolsMap.get(romanSymbol.charAt(i + 1)))
            {
                sum += romanSymbolsMap.get(romanSymbol.charAt(i + 1)) -
                        romanSymbolsMap.get(romanSymbol.charAt(i));
                i++;
            }
            else
            {
                sum += romanSymbolsMap.get(romanSymbol.charAt(i));
            }
        }
        return sum;
    }

    @Override
    public void calculate(String first_number, String second_number, String operation) throws IOException {
        int result = 0;

        String upperCaseFirstNumber = first_number.toUpperCase(Locale.ROOT);
        String upperCaseSecondNumber = second_number.toUpperCase(Locale.ROOT);

        switch (operation) {
            case "+" -> result = addition(convertFromRomanToInt(upperCaseFirstNumber), convertFromRomanToInt(upperCaseSecondNumber));
            case "-" -> result = subtraction(convertFromRomanToInt(upperCaseFirstNumber), convertFromRomanToInt(upperCaseSecondNumber));
            case "*" -> result = multiplication(convertFromRomanToInt(upperCaseFirstNumber), convertFromRomanToInt(upperCaseSecondNumber));
            case "/" -> result = division(convertFromRomanToInt(upperCaseFirstNumber), convertFromRomanToInt(upperCaseSecondNumber));
        }
        if (result < 0) {
            throw new IOException();
        }
        System.out.println(convertToRoman(result));
    }
}
