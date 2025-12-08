package com.codingwithtushar.week1task.implementation;

import com.codingwithtushar.week1task.interfaces.Frosting;
import org.springframework.stereotype.Component;

@Component("strawberryFrosting")
public class StrawberryFrosting implements Frosting {
    @Override
    public String getFosteringType() {
        return "Strawberry Frostering";
    }
}
