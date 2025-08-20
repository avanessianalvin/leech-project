package com.sian.leech.model.service;

import com.sian.leech.model.entity.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ElementServiceTest {

    @Autowired
    ElementService elementService;

    @Test
    void save() {
        elementService.save(new Element().setName("AA").setOpposite("VV"));
    }

    @Test
    void update(){
        Element element = new Element().setName("11").setOpposite("22");
        elementService.save(element);
        System.out.println(element);

        element.setName("33").setOpposite("44");
        elementService.save(element); //update

        System.out.println(element);

    }
}