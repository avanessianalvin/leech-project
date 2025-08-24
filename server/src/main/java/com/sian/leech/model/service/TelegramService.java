package com.sian.leech.model.service;

import com.sian.leech.model.entity.ActiveChain;
import org.springframework.stereotype.Service;

@Service
public class TelegramService {
    public void sendTelegramMessage(ActiveChain activeChain){
        System.out.println("Telegram message");
    }
}

