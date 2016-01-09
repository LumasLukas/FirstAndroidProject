 package com.example;

import java.util.ArrayList;

public class ProtoClass {

    private int my_instance_var;

    public ProtoClass(int n) {
        //constructor
        my_instance_var = n;
    }

    public static void main(String[] args) {
        int n = 5;
        ProtoClass mainAB = new ProtoClass(n);
        System.out.println(mainAB.my_instance_var);

        ArrayList mylist = new ArrayList();

        mylist.add('m');
        mylist.add('a');
        mylist.add('t');
        mylist.add('h');
        mylist.add('e');
        mylist.add('w');
        mylist.add('t, 2');
        System.out.print("my List: " + mylist.toString());
    }
}