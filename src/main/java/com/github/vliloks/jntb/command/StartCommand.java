package com.github.vliloks.jntb.command;

import com.github.vliloks.jntb.repository.entity.TelegramUser;
import com.github.vliloks.jntb.service.SendBotMessageService;
import com.github.vliloks.jntb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Привет. Я JavaNews Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, которые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {

    Long chatId = update.getMessage().getChatId();

    telegramUserService.findByChatId(chatId).ifPresentOrElse(
            user -> {
                user.setActive(true);
                telegramUserService.save(user);
            },
            () -> {
                TelegramUser telegramUser = new TelegramUser();
                telegramUser.setActive(true);
                telegramUser.setChatId(chatId);
                telegramUserService.save(telegramUser);
            });

    sendBotMessageService.sendMessage(chatId.toString(), START_MESSAGE);
    }
}
