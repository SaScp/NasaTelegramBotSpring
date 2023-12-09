package com.example.nasatelegrambotspring.service.impl;

import com.example.nasatelegrambotspring.configuration.TelegramBotConfiguration;
import com.example.nasatelegrambotspring.model.NasaObject;
import com.example.nasatelegrambotspring.service.TelegramService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class NasaTelegramService extends TelegramLongPollingBot implements TelegramService {
    private final DefaultNasaService defaultNasaService;
    private final TelegramBotConfiguration telegramBotConfiguration;

    public NasaTelegramService(DefaultNasaService defaultNasaService, TelegramBotConfiguration telegramBotConfiguration) {
        this.defaultNasaService = defaultNasaService;
        this.telegramBotConfiguration = telegramBotConfiguration;
    }

    @Override
    public String getBotUsername() {
        return telegramBotConfiguration.getName();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfiguration.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        String command = update.getMessage().getText();
        if (command != null) {
            switch (command) {
                case "/start" ->
                        sendMessage(chatId, "Привет, это бот для получений фотографий с сайта NASA, в твоем распоряжении есть 1 команда /photo");
                case "/photo" -> {
                    NasaObject nasaObject = defaultNasaService.getPhoto();
                    sendImage(chatId, nasaObject.getHdurl());
                    sendMessage(chatId, "Автор: " + nasaObject.getCopyright() + "\n" + "Дата съемки: " + nasaObject.getDate());
                }
                default -> sendMessage(chatId, command);
            }
        }

    }

    private void sendMessage(Long chat_id, String MessageText){

        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText(MessageText);

        try {
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    private void sendImage(long chatId, String url) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);


        InputFile inputFile = new InputFile();
        inputFile.setMedia(url);
        sendPhoto.setPhoto(inputFile);

        try {
            execute(sendPhoto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
