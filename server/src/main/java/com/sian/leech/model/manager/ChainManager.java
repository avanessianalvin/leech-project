package com.sian.leech.model.manager;

import com.sian.leech.model.entity.ActiveChain;
import com.sian.leech.model.entity.Chain;
import com.sian.leech.model.entity.MessageElement;
import com.sian.leech.model.service.ActiveChainService;
import com.sian.leech.model.service.ChainService;
import com.sian.leech.model.service.MessageElementService;
import com.sian.leech.model.service.TelegramService;
import com.sian.leech.util.ChainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChainManager {
    @Autowired
    private ChainService chainService;

    @Autowired
    private ActiveChainService activeChainService;

    @Autowired
    private MessageElementService messageElementService;

    @Autowired
    private TelegramService telegramService;

    public void newMessage(MessageElement messageElement){
        // new chains
        List<Chain> chainList = chainService.getAll();

        for (Chain chain : chainList) {
            if (chain.getElementList().get(0).getCode().equals(messageElement.getCode())){
                if (chain.getSymbols() != null && chain.getSymbols().contains(messageElement.getSymbol())){
                    ActiveChain activeChain = ChainUtil.createActiveChain(chain.getTitle(), messageElement.getSymbol(), "no info", chain);
                    activeChainService.save(activeChain);
                }
            }
        }

        // check all active chain's sequence

        List<ActiveChain> activeChainList = activeChainService.getAllActive();
        for (ActiveChain activeChain : activeChainList) {
            ChainUtil.checkSequence(activeChain, messageElement);
            activeChainService.save(activeChain);
        }

        // check confirmation
        for (ActiveChain activeChain : activeChainList) {
            boolean confirmation = ChainUtil.checkConfirmation(activeChain);
            activeChainService.save(activeChain);

            if (confirmation)telegramService.sendTelegramMessage(activeChain);
        }

    }


}
