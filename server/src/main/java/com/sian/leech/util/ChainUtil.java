package com.sian.leech.util;

import com.sian.leech.model.entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class ChainUtil {
    public static ChainElement fromElement(Element element){
        ChainElement ce = new ChainElement();
        ce.setCode(element.getCode());
        ce.setTitle(element.getTitle());
        return ce;
    }

    public static void refreshChainSequence(Chain chain){
        chain.setSequence(chain.getElementList().stream().map(ChainElement::getCode).collect(Collectors.joining("-")));
    }


    public static void fillWaitList(ActiveChain activeChain){
        activeChain.setWaitList(new ArrayList<>());
        for (ChainElement chainElement : activeChain.getChainElementList()) {
            MessageElement messageElement = new MessageElement()
                    .setCode(chainElement.getCode())
                    .setSymbol(activeChain.getSymbol());
            activeChain.getWaitList().add(messageElement);
        }
    }

    public static ActiveChain createActiveChain(String title, String symbol,String info, Chain chain,String tags,String message){
        ActiveChain activeChain = new ActiveChain()
                .setSymbol(symbol)
                .setInfo(info)
                .setStartTime(System.currentTimeMillis())
                .setTags(tags)
                .setMessage(message)
                .setTitle(title);

        List<ChainElement> chainElementList = new ArrayList<>(chain.getElementList());
                activeChain.setChainElementList(chainElementList);
                fillWaitList(activeChain);
                return activeChain;
    }

    private static MessageElement setParameters(MessageElement from,MessageElement to){
        to
                .setSender(from.getSender())
                .setSentDate(from.getSentDate())
                .setReceivedDate(from.getReceivedDate())
                .setInfo(from.getInfo())
                .setCode(from.getCode())
                .setSymbol(from.getSymbol());
        return to;
    }

    public static void checkSequence(ActiveChain activeChain, MessageElement messageElement) {
        MessageElement waitingMessageElement = getWaitingMessageElement(activeChain);
        if (activeChain.getSymbol().contains(messageElement.getSymbol()) && waitingMessageElement!=null && waitingMessageElement.getCode().equals(messageElement.getCode())){
            setParameters(messageElement,waitingMessageElement);
        }
    }

    public static MessageElement getWaitingMessageElement(ActiveChain activeChain){
        for (MessageElement messageElement : activeChain.getWaitList()) {
            if (messageElement.getReceivedDate()==0){
                return messageElement;
            }
        }
        return null;
    }

    public static boolean checkConfirmation(ActiveChain activeChain) {
        MessageElement messageElement = activeChain.getWaitList().get(activeChain.getWaitList().size() - 1);
        if (messageElement.getReceivedDate()>0){
            activeChain.setConfirmTime(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    public static Set<String> getTagList(ActiveChain activeChain){
        if (activeChain.getTags()== null){
            return new HashSet<String>();
        }
        return Arrays.stream(activeChain.getTags().split("[,;]")).map(String::trim).collect(Collectors.toSet());
    }
}
