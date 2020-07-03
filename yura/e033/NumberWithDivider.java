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

public class NumberWithDivider {
    private final int num;
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public NumberWithDivider(int num) {
        this.num = num;
    }

    public void bildList() {
        if(num==0){
            list.add(0);
            return;
        }
        if(num==1){
            list.add(1);
            return;
        }
        int numCur = num;
        for (int i = 2; i <= numCur; i++) {
            while (true) {
                if (numCur % i != 0)
                    break;
                list.add(i);
                numCur /= i;
            }
        }
    }

    public int getNumberFromList() {
        int ans = 1;
        for (int i : list)
            ans *= i;
        return ans;
    }

    public boolean checkCuriosing(NumberWithDivider denumerator) {
        List<Integer> listNumerator = Util.getList(this.list);
        List<Integer> listDenumerator = Util.getList(denumerator.list);


        return false;
    }

    public int[] getMinFruction(NumberWithDivider denumerator) {
        int ans[] = {1, 1};
        List<Integer> listNumerator = Util.getList(this.list);
        List<Integer> listDenumerator = Util.getList(denumerator.list);
        Util.lessFraction(listNumerator, listDenumerator);
        Util.Multiplay(listNumerator, ans, 0);
        Util.Multiplay(listDenumerator, ans, 1);
        return ans;
    }
}
