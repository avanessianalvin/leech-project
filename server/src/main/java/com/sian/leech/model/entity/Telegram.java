package com.sian.leech.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Telegram {
    @Id
    @GeneratedValue(generator = "default_seq")
    long id;

    @Column(columnDefinition = "CHARACTER VARYING(16)")
    String title;

    @Column(columnDefinition = "CHARACTER VARYING(64)")
    String token;

    @Column(columnDefinition = "CHARACTER VARYING(20)")
    String chatId;

    @Column(columnDefinition = "CHARACTER VARYING(64)")
    String tags;

    boolean enabled;
}
