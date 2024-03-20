package com.sem2.task5;

public class LazySingleton {
    private String word;
    private static LazySingleton instance;

    private LazySingleton(String word){
        this.word = word;
    }

    public void sayWord(){
        System.out.println(word);
    }

    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton("i am lazy");
        }
        return instance;
    }
}
