package com.github.vliloks.jntb.command;

import com.github.vliloks.jntb.service.SendBotMessageService;
import com.github.vliloks.jntb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StatCommand implements Command{

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;
    public final static String STAT_MESSAGE = "Меня использует %s человек.";

    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.telegramUserService = telegramUserService;
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.findAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), String.format(STAT_MESSAGE, activeUserCount));

    }
}
