package com.codingwithtushar.week1task.controller;

import com.codingwithtushar.week1task.baker.CakeBaker;
import com.codingwithtushar.week1task.interfaces.Frosting;
import com.codingwithtushar.week1task.interfaces.Syrup;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CakeBakerController {
    private final ApplicationContext context;
    private final CakeBaker cakeBaker;

    public CakeBakerController(ApplicationContext context, CakeBaker cakeBaker) {
        this.context = context;
        this.cakeBaker = cakeBaker;
    }

    @GetMapping("/bake")
    public String bakeCake(@RequestParam String frosting, @RequestParam String syrup) {
        Frosting frostingBean = (Frosting) context.getBean(frosting + "Frosting");
        Syrup syrupBean = (Syrup) context.getBean(syrup + "Syrup");
        return cakeBaker.bakeCake(frostingBean, syrupBean);
    }
}
