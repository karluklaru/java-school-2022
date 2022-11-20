package ru.croc.task10;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class PasswordHash implements Callable {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final char[] ENGLISH_LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final int passSize;
    private final String passwordHash;
    private final long[] startCombination;
    private final long[] endCombination;

    public PasswordHash(String passwordHash, int passSize, long startDecimal, long endDecimal) {
        this.passwordHash = passwordHash;
        this.passSize = passSize;
        this.startCombination = TwentySixSystem.fromDec(startDecimal, passSize);
        this.endCombination = TwentySixSystem.fromDec(endDecimal, passSize);
    }

    @Override
    public String call() {
        long[] combination = startCombination;
       // System.out.println(Arrays.toString(endCombination));
        StringBuilder variant;
        outer: while(true) {
            variant = new StringBuilder();
            for (long one : combination) {
                variant.append(ENGLISH_LETTERS[(int) one]);
            }
            if (passwordHash.equals(hashPassword(variant.toString()))) {
                return variant.toString();
            }
            if (combination == endCombination) {
                break;
            }

            int i = passSize - 1;
            while (combination[i] == ENGLISH_LETTERS.length - 1) {
                combination[i] = 0;
                i--;
                if (i < 0) break outer;
            }
            combination[i]++;
        }
        return null;
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

}
