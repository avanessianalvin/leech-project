package com.sian.leech;

import com.sian.leech.model.entity.Chain;
import com.sian.leech.model.entity.Element;
import com.sian.leech.model.entity.User;
import com.sian.leech.model.repository.ChainDA;
import com.sian.leech.model.repository.ElementDA;
import com.sian.leech.model.repository.UserDA;
import com.sian.leech.model.service.ChainService;
import com.sian.leech.model.service.ElementService;
import com.sian.leech.model.service.UserService;
import com.sian.leech.util.ChainUtil;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductInit implements ApplicationRunner {
    @Autowired
    UserService userService;

    @Autowired
    ElementService elementService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ChainService chainService;

    public void createUser(String username, String password) {


        User user = new User()
                .setUsername(username)
                .setPassword(passwordEncoder.encode(password))
                .setRole("ROLE_USER");

        userService.save(user);
    }

    public Element createElement(String code, String title){
        Element element = new Element()
                .setCode(code)
                .setTitle(title);
        elementService.save(element);
        return element;

    }

    public Chain createChain(String title,String symbols, Element... elements){
        Chain chain = new Chain()
                .setTitle(title)
                .setSymbols(symbols)
                .setElementList(Arrays.stream(elements).map(ChainUtil::fromElement).toList())
                .setEnabled(true)

                .setDescription("description " + title);
        chainService.save(chain);
        return chain;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Creating user ");
        createUser("alvin", "q1q1q1Q!");

        System.out.println("Creating some elements");
        Element cu15 = createElement("CU15", "Cross up 15 min");
        Element cd15 = createElement("CD15", "Cross down 15 min");
        Element sh15 = createElement("SH15", "Saturation high 15 min");
        Element sl15 = createElement("SL15", "Saturation low 15 min");


        createChain("Buy","EURUSD,USDJPY",cu15,sh15,cu15);
        createChain("Buy","EURUSD",cd15,sl15);

    }
}
