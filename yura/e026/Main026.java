package ru.yura.e026;
/*
 *
 *@Data 03.07.2020
 *@autor Fedorov Yuri
 *@project Euler
 *
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main026 {
    private final static int arr[] = new int[1001];
    private String s;
    private static int n = 1001;
    private int max = 1;
    private boolean find;
    BigDecimal b1 = BigDecimal.valueOf(1);

    public static void main(String[] args) {
        Main026 main = new Main026();
        for (int i = 27; i < n; i++) {
            main.fiilArr(i);
        }
    }

    private void fiilArr(int i) {
        s = getStringCur(i);
        //     System.out.println(s);
        getMaxRepit(s.toCharArray(), i, s);

    }


    private void getMaxRepit(char[] charsArray, int numb, String s) {
        find = false;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (isPrevios(list, i))
                continue;
            if (!isTrueSequence(charsArray, i))
                continue;
            if (i > max) {
                find = true;
            }
            // System.out.println(s);
            list.add(i);
        }
        if (!find)
            return;
        max = list.get(list.size()-1);
        System.out.println(numb + "  " + max + "   ");// + //Arrays.toString(charsArray));
        ;
    }

    private boolean isPrevios(List<Integer> list, int i) {
        for (int z : list)
            if (i % z == 0)
                return true;
        return false;
    }

    private boolean isTrueSequence(char[] charsArray, int len) {
        if (isCharrOnlyOne(charsArray, len))
            return false;
        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] != charsArray[i % len])
                return false;
        }
        return true;
    }

    private boolean isCharrOnlyOne(char[] charsArray, int len) {
        for (int i = 0; i < len; i++) {
            if (charsArray[0] != charsArray[i])
                return false;
        }
        return true;
    }

    private String getStringCur(int i) {
        return b1.divide(BigDecimal.valueOf(i), 100000, RoundingMode.DOWN).toString().substring(2);
    }
}
