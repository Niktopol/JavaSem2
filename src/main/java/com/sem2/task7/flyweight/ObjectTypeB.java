package com.sem2.task7.flyweight;

import java.util.Arrays;

public class ObjectTypeB implements Flyweight{

    String longString;

    long[] arr;

    public ObjectTypeB(){
        longString = "USUgijdzfgzdh;hgjWE:OJ'oPPWJSNHONlkMDCOglkihj{QIThWPSRNHPW";
        arr = new long[]{15644988465L, 216546465542L, 28465165454263L};
    }
    @Override
    public void printIdentity() {
        System.out.println("I`m object type B and i have: "+longString+" and "+ Arrays.toString(arr));
    }
}
