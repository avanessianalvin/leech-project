package com.sian.leech;

import com.sian.leech.model.entity.Chain;
import com.sian.leech.model.entity.Element;
import com.sian.leech.model.entity.Telegram;
import com.sian.leech.model.entity.User;
import com.sian.leech.model.repository.ChainDA;
import com.sian.leech.model.repository.ElementDA;
import com.sian.leech.model.repository.UserDA;
import com.sian.leech.model.service.ChainService;
import com.sian.leech.model.service.ElementService;
import com.sian.leech.model.service.TelegramService;
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
//public class ProductInit{
    @Autowired
    UserService userService;

    @Autowired
    ElementService elementService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ChainService chainService;

    @Autowired
    TelegramService telegramService;

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
                .setTelegramTags("EURUSD;XAUUSD")
                .setMessage("message\n2n line\n\n3rd line")
                .setDescription("description " + title);
        chainService.save(chain);
        return chain;
    }

    //fake keys
    public static final String TELEGRAM_BOT_TOKEN = "8121401234:AAFA1SsOpagZmCdzInAZUz7iZFl8bDYN1gk";
    public static final String TELEGRAM_CHANNEL_CHAT_ID1 = "-1002957986543";
    public static final String TELEGRAM_CHANNEL_CHAT_ID2 = "-1002957983456";


    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Optional to create some items.");
        System.out.println("Creating user ");
        createUser("user", "user");

        System.out.println("Creating some elements...");
        Element cu15 = createElement("CU15", "Cross up 15 min");
        Element cd15 = createElement("CD15", "Cross down 15 min");
        Element sh15 = createElement("SH15", "Saturation high 15 min");
        Element sl15 = createElement("SL15", "Saturation low 15 min");

        System.out.println("Creating some chains... ");
        createChain("Buy","EURUSD,XAUUSD",cu15,sh15,cu15);
        createChain("Buy","EURUSD",cd15,sl15);

        System.out.println("Creating some telegram links... ");
        telegramService.save(
                new Telegram()
                        .setTitle("Catch all")
                        .setToken(TELEGRAM_BOT_TOKEN)
                        .setChatId(TELEGRAM_CHANNEL_CHAT_ID1)
                        .setTags("EURUSD;XAUUSD")
                        .setEnabled(true));

        telegramService.save(
                new Telegram()
                        .setTitle("Eurusd only")
                        .setToken("TELEGRAM_BOT_TOKEN")
                        .setChatId(TELEGRAM_CHANNEL_CHAT_ID2)
                        .setTags("EURUSD")
                        .setEnabled(true));

    }
}
