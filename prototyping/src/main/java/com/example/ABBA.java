package com.example;

import java.util.Objects;

public class ABBA{
    public ABBA(){

    }

    public String addA(String in){
        return in+'A';
    }

    public String reverse_and_addB(String in){
        String reverse = new StringBuffer(in).reverse().toString();
        return reverse+"B";
  }

    public String canObtain(String initial, String target){
        if (initial.compareTo(target) == 0 )
            return "Possible";
        if((target.length() - initial.length()) <=0 )
            return "Impossible";

        String result1 = canObtain(addA(initial), target);
        String result2 = canObtain( reverse_and_addB(initial), target);

        if (Objects.equals(result1, "Possible") || Objects.equals(result2, "Possible")) {
            return "Possible";
        }
        else
            return "Impossible";

    }

    public static void main(String[] args){
        ABBA myABBA = new ABBA();
        String result = myABBA.canObtain("AABB", "BBAABA");
        System.out.print( result );

    }
}