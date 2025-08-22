package com.sian.leech.controller;

import com.sian.leech.model.entity.Element;
import com.sian.leech.model.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/element")
public class ElementController {

    @Autowired
    ElementService elementService;

    @GetMapping("/getAll")
    public List<Element> getAll(){
        return elementService.getAll();
    }

    @PostMapping("/save")
    public Element save(@RequestBody Element element){
        elementService.save(element);
        return element;
    }

    @PostMapping("/remove")
    public ResponseEntity<Element> remove(@RequestBody Element element){
        elementService.remove(element);
        return ResponseEntity.ok(element);
    }

    @GetMapping("/get")
    public Element get(long id){
        return elementService.get(id);
    }

}
