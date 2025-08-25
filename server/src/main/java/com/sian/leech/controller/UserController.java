package com.sian.leech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/islogged")
    public ResponseEntity<String> logged(){
        return ResponseEntity.ok("yes");
    }
}
