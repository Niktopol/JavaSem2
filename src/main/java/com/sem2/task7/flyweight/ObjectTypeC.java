package com.sem2.task7.flyweight;

public class ObjectTypeC implements Flyweight{
    float floatNum;
    double doubleNum;

    public ObjectTypeC(){
        floatNum = 0.6874654F;
        doubleNum = 0.268656486465548D;
    }
    @Override
    public void printIdentity() {
        System.out.println("I`m object type C and i have: "+floatNum+" and "+doubleNum);
    }
}
