package com.sem2;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 implements Comparator<String>{
    @Override
    public int compare(String str1, String str2) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcherOne = pattern.matcher(str1);
        Matcher matcherTwo = pattern.matcher(str2);
        int sum1 = 0;
        int sum2 = 0;

        while (matcherOne.find()){
            sum1 += Integer.parseInt(matcherOne.group(0));
        }
        while (matcherTwo.find()){
            sum2 += Integer.parseInt(matcherTwo.group(0));
        }

        return (sum1 - sum2)/(((sum1 - sum2) != 0)?Math.abs(sum1 - sum2):1);
    }
}
