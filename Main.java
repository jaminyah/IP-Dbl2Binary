/**
 * Compile: $ javac float2binary/Main.java
 * Run: $ java float2binary/Main
 * Ref: https://www.exploringbinary.com/base-conversion-in-php-using-bcmath/
 * Ref: https://stackoverflow.com/questions/3954498/how-to-convert-float-number-to-binary
 */

package float2binary;

import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        double dbVal = 2.625;

        String result = convertDbl2Binary(dbVal);
        System.out.println("Double to binary: " + result);
    }

    static String convertDbl2Binary(double db) {

        StringBuilder builder = new StringBuilder();

        int intVal = (int) db;
        double doubleVal = db - intVal;

        System.out.println(intVal);
        System.out.println(doubleVal);

        String leftBinary = convertInt2Binary(intVal);
        builder.append(leftBinary);
        builder.append(".");

        String rightBinary = convertDec2Binary(doubleVal);
        builder.append(rightBinary);

        System.out.println();
        return builder.toString();
    }

    static String convertInt2Binary(int n) {

        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> binArray = new ArrayList<>();
        Integer remainder = 0;
        int quotient = n;

        while (quotient != 0) {
            remainder = quotient % 2;
            binArray.add(remainder);
            quotient = quotient / 2;
        }

        Collections.reverse(binArray);
        for (int binary: binArray) {
            builder.append(String.valueOf(binary));
        }
        return builder.toString();
    }

    static String convertDec2Binary(Double dblVal) {

        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> binArray = new ArrayList<>();
        Integer intVal;
        double tempVal;

        while (dblVal != 0) {
            tempVal = dblVal * 2;
            intVal = (int) tempVal;
            dblVal = tempVal - intVal;
            binArray.add(intVal);
        }

        for (int binary: binArray) {
            builder.append(String.valueOf(binary));
        }
        return builder.toString();
    }
}