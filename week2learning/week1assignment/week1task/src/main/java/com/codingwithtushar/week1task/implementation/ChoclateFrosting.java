package com.codingwithtushar.week1task.implementation;

import com.codingwithtushar.week1task.interfaces.Frosting;
import org.springframework.stereotype.Component;

@Component("choclateFrosting")
public class ChoclateFrosting implements Frosting {
    @Override
    public String getFosteringType() {
        return "Choclate Frosting";
    }
}
