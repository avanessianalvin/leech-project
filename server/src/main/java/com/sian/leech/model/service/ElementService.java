package com.sian.leech.model.service;

import com.sian.leech.model.entity.Element;
import com.sian.leech.model.repository.ElementDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ElementService {

    @Autowired
    ElementDA elementDA;
    public void save(Element element){
        
        elementDA.save(element);
    }

    public void remove(Element element){
        elementDA.delete(element);
    }

    public Element get(long id){
        return elementDA.findById(id).orElseThrow(()-> new NoSuchElementException("Element not found"));
    }

    public List<Element> getAll(){
        return elementDA.findAll();
    }

}
