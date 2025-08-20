package com.sian.leech.model.service;

import com.sian.leech.model.entity.Chain;
import com.sian.leech.model.repository.ChainDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChainService {
    @Autowired
    private ChainDA chainDA;

    public void save(Chain chain){
        chainDA.save(chain);
    }

    public void remove(Chain chain){
        chainDA.delete(chain);
    }

    public Chain get(long id){
        return chainDA.findById(id).orElseThrow(()->new NoSuchElementException("Chain not found"));
    }

    public List<Chain> getAll(){
        return chainDA.findAll();
    }
}
