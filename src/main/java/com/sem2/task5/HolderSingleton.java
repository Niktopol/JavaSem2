package com.sem2.task5;

public class HolderSingleton {

    private String word;
    private HolderSingleton(String word){
        this.word = word;
    }

    private static class Holder{
        static final HolderSingleton instance = new HolderSingleton("i have a secret");
    }

    public static HolderSingleton getInstance(){
        return Holder.instance;
    }

    public void sayWord(){
        System.out.println(word);
    }
}
