package com.codingwithtushar.week1task.implementation;

import com.codingwithtushar.week1task.interfaces.Syrup;
import org.springframework.stereotype.Component;

@Component("choclateSyrup")
public class ChoclateSyrup implements Syrup {

    @Override
    public String getSyrupType() {
        return "Choclate Syrup";
    }
}
