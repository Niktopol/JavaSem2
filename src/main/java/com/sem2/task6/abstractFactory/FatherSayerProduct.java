package com.sem2.task6.abstractFactory;

public class FatherSayerProduct implements AbstractProduct{

    @Override
    public void relateToName(String name) {
        System.out.println("My father`s name is "+name);
    }
}
