package com.sian.leech.controller;

import com.sian.leech.model.entity.Element;
import com.sian.leech.model.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/element")
public class ElementController {

    @Autowired
    ElementService elementService;

    @GetMapping("getAll")
    public List<Element> getAll(){
        return elementService.getAll();
    }
}
