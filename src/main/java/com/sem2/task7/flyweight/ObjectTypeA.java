package com.sem2.task7.flyweight;

import java.util.Arrays;

public class ObjectTypeA implements Flyweight{
    Long bigNum;

    int[] arr;

    public ObjectTypeA(){
        bigNum = 646543465798465L;
        arr = new int[]{1, 2, 3};
    }
    @Override
    public void printIdentity() {
        System.out.println("I`m object type A and i have: "+bigNum+" and "+ Arrays.toString(arr));
    }
}
