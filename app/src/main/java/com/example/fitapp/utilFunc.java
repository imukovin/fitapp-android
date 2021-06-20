package com.example.fitapp;

import static java.lang.Math.abs;

public class utilFunc {
    public static String choosePluralMerge(long number, String caseOne, String caseTwo, String caseFive) {

        String str = Long.toString(number) + " ";
        number = abs(number);

        if (number % 10 == 1 && number % 100 != 11) {
            str += caseOne;
        } else if (number % 10 >= 2 && number % 10 <= 4 && (number % 100 < 10 || number % 100 >= 20)) {
            str += caseTwo;
        } else {
            str += caseFive;
        }

        return str;
    }
}
