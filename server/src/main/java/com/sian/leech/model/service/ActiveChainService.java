package com.sian.leech.model.service;

import com.sian.leech.model.entity.ActiveChain;
import com.sian.leech.model.repository.ActiveChainDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveChainService {
    @Autowired
    ActiveChainDA activeChainDA;
    public void save(ActiveChain activeChain){
        activeChainDA.save(activeChain);
    }

    public void remove(ActiveChain activeChain){
        activeChainDA.delete(activeChain);
    }

    public ActiveChain get(long id){
        return activeChainDA.findById(id).orElse(null);
    }

    public List<ActiveChain> getAll(){
        return activeChainDA.findAll();
    }

    public List<ActiveChain> getAllActive() {
        return activeChainDA.findAllActive();
    }

    public List<ActiveChain> getConfirmed(int limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by("confirmTime").descending());
        return activeChainDA.findByConfirmTimeGreaterThan(0, pageable);

    }
}
