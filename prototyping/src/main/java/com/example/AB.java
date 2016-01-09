package com.example;

/**
 * Created by Matthew on 11/23/2015.
 */


public class AB {

    public static String createString(int N, int K) {
        for (int cntB = 0; cntB <= N; cntB++) {
            char[] a = new char[N];
            for (int i = 0; i < cntB; i++) {
                a[i] = 'B';
            }
            for (int i = cntB; i < N; i++) {
                a[i] = 'A';
            }
            System.out.println("the array: ");
            for (int iii=0; iii<N; iii++)
                System.out.print(a);
            int cur = 0;
            while (true) {
                if (cur == K) {
                    return new String(a);
                }
                int pos = -1;
                for (int i = 0; i + 1 < N; i++) {
                    if (a[i] == 'B' && a[i + 1] == 'A') {
                        pos = i;
                        break;
                    }
                }
                if (pos == -1) {
                    break;
                }
                cur++;
                a[pos] = 'A';
                a[pos + 1] = 'B';
            }
        }
        return "";
    }
    public static void main(String[] args){
        int N = 3;
        int K = 2;
        AB mainAB = new AB();
        AB.createString(N, K);
    }

}


