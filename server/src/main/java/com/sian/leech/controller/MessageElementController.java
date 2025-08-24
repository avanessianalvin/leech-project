package com.sian.leech.controller;

import com.sian.leech.model.entity.ActiveChain;
import com.sian.leech.model.entity.MessageElement;
import com.sian.leech.model.manager.ChainManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/message")
@Controller
public class MessageElementController {
    @Autowired
    private ChainManager chainManager;

    @PostMapping("/feed")
    public ResponseEntity<MessageElement> feed(@RequestBody MessageElement messageElement){
        messageElement.setReceivedDate(System.currentTimeMillis());
        chainManager.newMessage(messageElement);
        return ResponseEntity.ok(messageElement);

    }

}
