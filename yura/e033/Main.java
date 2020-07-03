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

public class Main {
    private final NumberWithDivider arr[]=new NumberWithDivider[100];
    private List<Integer> listNumerator=new ArrayList<>();
    private List<Integer> listDenumerator=new ArrayList<>();
    public static void main(String[] args) {
        Main main=new Main();
        main.bildARR();
        main.printCuriousNumber();
        System.out.println(main.listNumerator);
        System.out.println(main.listDenumerator);
    }

    private void printCuriousNumber() {
        for(int i=10;i<100;i++)
            for(int j=i+1;j<100;j++){
                if(i%10==0)
                    continue;
                int [] fraction=arr[i].getMinFruction(arr[j]);
                checkCuriosing(fraction,i,j);

//                 if(arr[i].checkCuriosing(arr[j])){
//                     listNumerator.add(i);
//                     listDenumerator.add(j);
//                 }
            }


    }

    private void checkCuriosing(int[] fraction, int ii, int jj) {
        char numer[]=Util.getNumber(ii);
        char denumer[]=Util.getNumber(jj);
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                if(numer[i]==denumer[j]){
                    String s=""+numer[getIndex(i)];
                    int ss=Integer.valueOf(s);
                    String s1=""+denumer[getIndex(j)];
                    int ss1=Integer.valueOf(s1);
                    int[] fraction2=arr[ss].getMinFruction(arr[ss1]);
                    insideInList(fraction,fraction2,ii,jj);
                }
            }

        }

    }

    private void insideInList(int[] fraction, int[] fraction2, int ii, int jj) {
        if(fraction[0]==fraction2[0])
            if(fraction[1]==fraction2[1]){
                System.out.println(ii+"   "+jj);
                listNumerator.add(fraction[0]);
                listDenumerator.add(fraction[1]);
            }
    }

    private int getIndex(int i) {
        return i==0?1:0;
    }

    private  void bildARR() {
        for(int i=0;i<100;i++){
            arr[i]=new NumberWithDivider(i);
            arr[i].bildList();
            System.out.println(i+"  "+arr[i].getList());
            assert(i==arr[i].getNumberFromList());
        }


    }
}
