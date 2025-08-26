package com.sian.leech.model.service;

import com.sian.leech.model.entity.ActiveChain;
import com.sian.leech.model.entity.Telegram;
import com.sian.leech.model.repository.TelegramDA;
import com.sian.leech.util.ChainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TelegramService {

    @Autowired
    private TelegramDA telegramDA;

    public void save(Telegram telegram){
        telegramDA.save(telegram);
    }

    public void remove(Telegram telegram){
        telegramDA.delete(telegram);
    }

    public Telegram get(long id){
        return telegramDA.findById(id).orElse(null);
    }

    public List<Telegram> getAll(){
        return telegramDA.findAll();
    }
    public void sendTelegramMessage(ActiveChain activeChain){
        System.out.println("Telegram message");
        Set<String> tagSet = ChainUtil.getTagList(activeChain);
        Set<Telegram> telegramSet = telegramDA.findAll().stream().filter(Telegram::isEnabled).collect(Collectors.toSet());
        Set<Telegram> sendSet = new HashSet<>();
        for (String s : tagSet) {
            telegramSet.stream().filter(t->t.getTags().contains(s)).forEach(sendSet::add);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").withZone(ZoneId.systemDefault());

        String startFormatted = formatter.format(Instant.ofEpochMilli(activeChain.getStartTime()));
        String confirmFormatted = formatter.format(Instant.ofEpochMilli(activeChain.getConfirmTime()));

        String message =
                "Symbol : " + activeChain.getSymbol() + "\n" +
                        "Title : " + activeChain.getTitle() + "\n\n " +
                        "Start : " + startFormatted + "\n" +
                        "Confirm : " + confirmFormatted + "\n\n" +
                        activeChain.getMessage();


        sendSet.forEach(telegram -> this.sendToTelegram(message,telegram));

    }

    public void sendToTelegram(String message,Telegram telegram){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = String.format(
                    "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                    telegram.getToken(),
                    telegram.getChatId(),
                    URLEncoder.encode(message, StandardCharsets.UTF_8)
            );
            ResponseEntity<String> response = restTemplate.getForEntity(new URI(url), String.class);
            System.out.println(response.getBody());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}

