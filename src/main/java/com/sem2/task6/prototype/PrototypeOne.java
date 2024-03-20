package com.sem2.task6.prototype;

public class PrototypeOne implements Prototype{
    private String myFriend;
    public PrototypeOne(String myKey){
        this.myFriend = myKey;
    }
    @Override
    public String toString(){
        return "My friend is: " + myFriend;
    }
    @Override
    public Prototype clone() {
        return new PrototypeOne(myFriend);
    }
}
