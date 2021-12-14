package com.github.vliloks.jntb.bot;

import com.github.vliloks.jntb.command.CommandContainer;
import com.github.vliloks.jntb.javarushclient.JavaRushGroupClient;
import com.github.vliloks.jntb.service.GroupSubService;
import com.github.vliloks.jntb.service.SendBotMessageServiceImpl;
import com.github.vliloks.jntb.service.StatisticsService;
import com.github.vliloks.jntb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static com.github.vliloks.jntb.command.CommandName.NO;

@Component
public class JavaNewsTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Autowired
    public JavaNewsTelegramBot(TelegramUserService telegramUserService, JavaRushGroupClient groupClient, GroupSubService groupSubService,
                               @Value("#{'${bot.admins}'.split(',')}") List<String> admins, StatisticsService statisticsService) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this),
                        telegramUserService, groupClient, groupSubService, admins, statisticsService);
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            if (message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier, username).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName(), username).execute(update);
            }



        }
    }
}
