package com.codingwithtushar.week1task.implementation;

import com.codingwithtushar.week1task.interfaces.Syrup;
import org.springframework.stereotype.Component;

@Component("strawberrySyrup")
public class StrawberrySyrup implements Syrup {
    @Override
    public String getSyrupType() {
        return "Strawberry Syrup";
    }
}
