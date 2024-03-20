package com.sem2.task6.prototype;

public class PrototypeTwo implements Prototype{
    private String myKey;
    public PrototypeTwo(String myKey){
        this.myKey = myKey;
    }
    @Override
    public String toString(){
        return "My key is: " + myKey;
    }
    @Override
    public Prototype clone() {
        return new PrototypeTwo(myKey);
    }
}
