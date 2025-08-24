package com.sian.leech.controller;

import com.sian.leech.model.entity.ActiveChain;
import com.sian.leech.model.entity.MessageElement;
import com.sian.leech.model.manager.ChainManager;
import com.sian.leech.model.service.ActiveChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api/chain/active")
public class ActiveChainController {

    @Autowired
    private ActiveChainService activeChainService;

    @Autowired
    ChainManager chainManager;

    @GetMapping("/getAll")
    public ResponseEntity<List<ActiveChain>> getAll(){
        return ResponseEntity.ok(activeChainService.getAll());
    }

    @GetMapping("/getAllActive")
    public ResponseEntity<List<ActiveChain>> getAllActive(){
        return ResponseEntity.ok(activeChainService.getAllActive());
    }

    @GetMapping("/getConfirmed")
    public ResponseEntity<List<ActiveChain>> getConfirmed(@RequestParam("limit") int limit){
        return ResponseEntity.ok(activeChainService.getConfirmed(limit));
    }

    @PostMapping("/remove")
    public ResponseEntity<ActiveChain> remove(@RequestBody ActiveChain activeChain){
        activeChainService.remove(activeChain);
        return ResponseEntity.ok(activeChain);
    }



}
