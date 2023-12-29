package com.javaintensive.telegrambot.config;

import com.javaintensive.telegrambot.Bot;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramBotConfiguration {

    private TelegramBotsApi telegramBotsApi;

    private Bot bot;

    public TelegramBotConfiguration(Bot bot) {
        this.bot = bot;
    }

    @PostConstruct
    public void init() throws TelegramApiException {
        telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
