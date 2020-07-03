package ru.yura.e033;
/*
 *
 *@Data 03.07.2020
 *@autor Fedorov Yuri
 *@project Euler
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Integer> getList(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        list.forEach(x -> ans.add(x));
        return ans;
    }

    public static void lessFraction(List<Integer> listNumerator, List<Integer> listDenumerator) {
        for (int i = 0; i < listNumerator.size(); i++) {
            int q = listNumerator.get(i);
            int indDenum = listDenumerator.indexOf(q);
            if (indDenum == -1)
                continue;
            listDenumerator.remove(indDenum);
            listNumerator.remove(i);
            i--;
        }
    }

    public static void Multiplay(List<Integer> list, int[] ans, int i) {
        list.forEach(x -> ans[i] *= x);
    }

    public static char[] getNumber(Integer i) {
        char ch[] = new char[2];
        String s = i.toString();
        ch[0] = s.charAt(0);
        ch[1] = s.charAt(1);
        return ch;
    }
}
