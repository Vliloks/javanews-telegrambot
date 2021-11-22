package com.github.vliloks.jntb.service;

import com.github.vliloks.jntb.bot.JavaNewsTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavaNewsTelegramBot javaNewsBot;

    @BeforeEach
    public void init() {
        javaNewsBot = Mockito.mock(JavaNewsTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaNewsBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(javaNewsBot).execute(sendMessage);
    }
}
