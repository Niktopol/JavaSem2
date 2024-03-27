package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component("guitarist")
public class Guitarist implements Musician{
    @Override
    public void doCoding() {
        System.out.println("Tring");
    }
}
