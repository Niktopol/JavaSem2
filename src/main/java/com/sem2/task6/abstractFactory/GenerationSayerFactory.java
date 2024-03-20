package com.sem2.task6.abstractFactory;

public class GenerationSayerFactory implements AbstractFactory{
    @Override
    public AbstractProduct createProductA() {
        return new FatherSayerProduct();
    }

    @Override
    public AbstractProduct createProductB() {
        return new GrandfatherSayerProduct();
    }
}
