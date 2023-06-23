package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Pojo {


    @Loggable
    public void test(){
        System.out.println("Test method");
        this.testUtil();
    }


    @Loggable
    public void testUtil(){
        System.out.println("testUtils");
    }
} // gadwera xdeba mtliani klasiis da ara abieqtis
