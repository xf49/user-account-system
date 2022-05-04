package com.example.demo.utils;

import java.util.Random;

public class Utils {
    public static String genarateToken(){

        String smallCases="abcdefghijklmnopqrstuvwxyz";

        String capitalCases = smallCases.toUpperCase();

        String Alphabet = capitalCases+smallCases;

        String numbers="123456789";

        String options=Alphabet+numbers;

        StringBuilder sb = new StringBuilder();
        //length of token
        int tokenLen = 32;

        for(int i=0;i<tokenLen;i++){
            sb.append(options.charAt(new Random().nextInt(61)));
        }

        return sb.toString();
    }
}
