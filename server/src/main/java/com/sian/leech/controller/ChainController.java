package com.sian.leech.controller;

import com.sian.leech.model.entity.Chain;
import com.sian.leech.model.repository.ChainDA;
import com.sian.leech.model.service.ChainService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/chain")
@Controller
public class ChainController {
    @Autowired
    private ChainService chainService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Chain>> getAll(){
        List<Chain> chainList = chainService.getAll();
        return ResponseEntity.ok(chainList);
    }

    @GetMapping("/get")
    public ResponseEntity<Chain> get(long i){
        Chain chain = chainService.get(i);
        return ResponseEntity.ok(chain);
    }

    @PostMapping("/save")
    public ResponseEntity<Chain> save(@RequestBody Chain chain){
        chainService.save(chain);
        return ResponseEntity.ok(chain);
    }

    @PostMapping("remove")
    public ResponseEntity<Chain> remove(@RequestBody Chain chain){
        chainService.remove(chain);
        return ResponseEntity.ok(chain);
    }
}
