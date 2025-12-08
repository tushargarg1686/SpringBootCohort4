package com.codingwithtushar.week1task.baker;

import com.codingwithtushar.week1task.interfaces.Frosting;
import com.codingwithtushar.week1task.interfaces.Syrup;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

@Component
public class CakeBaker {
    private final ApplicationContext context;

    public CakeBaker(ApplicationContext context) {
        this.context = context;
    }


    public String bakeCake(Frosting frosting, Syrup syrup) {

        return "Baking a cake with " + frosting.getFosteringType() + " and " + syrup.getSyrupType();
    }
}
