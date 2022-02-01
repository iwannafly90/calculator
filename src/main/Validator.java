package main;

import main.Calculator.RomanCalculator;

import java.util.Locale;

public class Validator {

    public static boolean isValidNumeric(String str) {
        try {
            int res = Integer.parseInt(str);
            return res >= 1 && res <= 10;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isValidRoman(String str) {
        String checkedString = str.toUpperCase(Locale.ROOT);
        for (int i = 0; i <= checkedString.length() - 1; i++){
            if (!RomanCalculator.romanSymbolsMap.containsKey(checkedString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
