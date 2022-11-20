package ru.croc.task10;

public class TwentySixSystem {
    public static long[] fromDec(long decimal, int lenOfNum) {
        long[] number = new long[lenOfNum];
        long mod;
        int i = lenOfNum - 1;
        while (decimal > 0) {
            mod = decimal % 26;
            number[i] = mod;
            decimal /= 26;
            --i;
        }
        return number;
    }
}
