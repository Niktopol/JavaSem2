package com.sem2.task6.abstractFactory;

public class GrandfatherSayerProduct implements AbstractProduct{
    @Override
    public void relateToName(String name) {
        System.out.println("My grandfather`s name is "+name);
    }
}
