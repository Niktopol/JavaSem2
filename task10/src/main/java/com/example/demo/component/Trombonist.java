package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component("trombonist")
public class Trombonist implements Musician{
    @Override
    public void doCoding() {
        System.out.println("Doot");
    }
}
