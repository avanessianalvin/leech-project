package com.sian.leech.model.manager;

import com.sian.leech.model.service.ChainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChainManagerTest {

    @Autowired
    ChainManager chainManager;

    @Autowired
    ChainService chainService;

    @Test
    void newMessage() {

    }
}