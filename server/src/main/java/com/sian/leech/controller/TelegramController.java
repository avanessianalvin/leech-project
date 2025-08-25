package com.sian.leech.controller;

import com.sian.leech.model.entity.Telegram;
import com.sian.leech.model.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/telegram")
public class TelegramController {
    @Autowired
    TelegramService telegramService;

    @GetMapping("/get")
    public ResponseEntity<Telegram> get(@RequestParam("id") long i){
        return ResponseEntity.ok(telegramService.get(i));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Telegram>> getAll(){
        return ResponseEntity.ok(telegramService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Telegram> save(@RequestBody Telegram telegram){
        telegramService.save(telegram);
        return ResponseEntity.ok(telegram);
    }

    @PostMapping("remove")
    public ResponseEntity<Telegram> remove(@RequestBody  Telegram telegram){
        telegramService.remove(telegram);
        return ResponseEntity.ok(telegram);
    }
}
