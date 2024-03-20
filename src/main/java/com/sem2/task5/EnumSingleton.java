package com.sem2.task5;

public enum EnumSingleton {
    INSTANCE("hello");
    private String word;

    public void sayWord(){
        System.out.println("My word is: " + word);
    }

    private EnumSingleton(String word){
        this.word = word;
    }
}
