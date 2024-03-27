package com.example.demo.configuration;

import com.example.demo.component.Drummer;
import com.example.demo.component.Guitarist;
import com.example.demo.component.Musician;
import com.example.demo.component.Trombonist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public Drummer drummer(){
        return new Drummer();
    }
    @Bean
    public Guitarist guitarist(){
        return new Guitarist();
    }
    @Bean
    public Trombonist trombonist(){
        return new Trombonist();
    }
}
