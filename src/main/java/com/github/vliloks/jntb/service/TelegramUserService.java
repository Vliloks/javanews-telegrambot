package com.github.vliloks.jntb.service;

import com.github.vliloks.jntb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    void save(TelegramUser telegramUser);

    List<TelegramUser> findAllActiveUsers();

    List<TelegramUser> findAllInActiveUsers();

    Optional<TelegramUser> findByChatId(Long chatId);
}
