package com.sian.leech.model.repository;

import com.sian.leech.model.entity.Telegram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramDA extends JpaRepository<Telegram,Long> {
}
