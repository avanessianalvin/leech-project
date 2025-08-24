package com.sian.leech.model.service;

import com.sian.leech.model.entity.MessageElement;
import com.sian.leech.model.repository.MessageElementDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageElementService {
    @Autowired
    private MessageElementDA messageElementDA;

    public void save(MessageElement messageElement){
        messageElementDA.save(messageElement);
    }

}
