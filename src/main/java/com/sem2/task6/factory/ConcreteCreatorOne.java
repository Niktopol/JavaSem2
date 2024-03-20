package com.sem2.task6.factory;

public final class ConcreteCreatorOne extends Creator{
    @Override
    public Product factoryMethod(String name) {
        return new ConcreteProductOne(name);
    }
}
