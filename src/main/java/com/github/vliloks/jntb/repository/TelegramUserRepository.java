package com.github.vliloks.jntb.repository;

import com.github.vliloks.jntb.repository.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {
    List<TelegramUser> findAllByActiveTrue();
    List<TelegramUser> findAllByActiveFalse();
}
