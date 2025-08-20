package com.sian.leech.model.service;

import com.sian.leech.model.entity.Element;
import com.sian.leech.model.mapper.ElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceMapper {
    @Autowired
    private ElementMapper elementMapper;

    public void save(Element element){
        elementMapper.insert(element);
    }

    public void update(Element element){
        elementMapper.update(element);
    }

    public void remove(Element element){
        elementMapper.delete(element);
    }

    public Element get(long id){
        return elementMapper.findOne(id);
    }

    public List<Element> getAll(){
        return elementMapper.findAll();
    }

}
