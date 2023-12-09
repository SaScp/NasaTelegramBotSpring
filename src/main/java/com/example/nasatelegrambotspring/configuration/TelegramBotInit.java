package com.example.nasatelegrambotspring.configuration;

import com.example.nasatelegrambotspring.service.impl.DefaultNasaService;
import com.example.nasatelegrambotspring.service.impl.NasaTelegramService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class TelegramBotInit {

    private final NasaTelegramService nasaTelegramService;

    public TelegramBotInit(NasaTelegramService nasaTelegramService) {
        this.nasaTelegramService = nasaTelegramService;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            telegramBotsApi.registerBot(nasaTelegramService);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
