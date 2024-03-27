package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component("drummer")
public class Drummer implements Musician{
    @Override
    public void doCoding() {
        System.out.println("Bam-Bam!");
    }
}
