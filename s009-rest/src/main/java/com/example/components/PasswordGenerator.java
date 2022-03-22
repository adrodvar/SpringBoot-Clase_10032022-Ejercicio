package com.example.components;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PasswordGenerator {

    private int length;
    private String characters;
    private Random random;

    public PasswordGenerator(){
        this.random = new Random();
        this.length = this.random.nextInt(8) + 8;
        characters = "asbcdefghijk1234567";
    }
    public String generate(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++)
            result.append(characters.charAt(random.nextInt(characters.length())));
        return result.toString();
    }


}








