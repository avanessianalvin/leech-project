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
        elementService.save(new Element().setTitle("AA").setCode("VV"));
    }

    @Test
    void update(){
        Element element = new Element().setTitle("11").setCode("22");
        elementService.save(element);
        System.out.println(element);

        element.setTitle("33").setCode("44");
        elementService.save(element); //update

        System.out.println(element);

    }
}