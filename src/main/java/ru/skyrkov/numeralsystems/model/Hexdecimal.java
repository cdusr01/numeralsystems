package ru.skyrkov.numeralsystems.model;

import java.util.Arrays;

import static java.lang.Math.pow;
import static ru.skyrkov.numeralsystems.util.Util.binaryMap;

public class Hexdecimal extends NumeralSystem{
    public Hexdecimal(String hexdecimal){
        setHexdecimal(hexdecimal);
    }

    @Override
    public String getDecimal(){
        int result = 0;
        if (!hexdecimal.equals("0")){
            char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] number = hexdecimal.toCharArray();
            int len = hexdecimal.length() - 1;
            for (int i = 0; i <= len; i++) {
                int index = 0;
                for (int j = 0; j < hexDigits.length; j++) {
                    if (hexDigits[j] == number[len-i]){
                        index = j;
                        break;
                    }
                }
                result += index * pow(16, i);
            }
        }
        setDecimal(String.valueOf(result));
        return decimal;
    }

    @Override
    public String getBinary(){
        String result = "";
        if (hexdecimal.equals("0")){
            result = "0";
        }else {
            for (char c : hexdecimal.toCharArray()) {
                result += binaryMap.get(String.valueOf(c));
            }

        }
        setBinary(result);
        return binary;
    }

    @Override
    public void setValue(String hexdecimal){
        setHexdecimal(hexdecimal);
    }

    @Override
    public String toString() {
        return "Шестнадцатеричная";
    }
}
