package ru.croc.task10;

public class TwentySixSystem {
    public static int[] fromDec(double decimal, int lenOfNum) {
        int[] number = new int[lenOfNum];
        int mod;
        int i = lenOfNum - 1;
        while (decimal > 26) {
            mod = (int) (decimal % 26);
            number[i] = mod;
            --i;
            decimal /= 26;
        }
        return number;
    }
}
