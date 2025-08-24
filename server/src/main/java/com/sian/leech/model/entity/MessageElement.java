package com.sian.leech.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.checkerframework.checker.units.qual.C;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MessageElement {
    @Id
    @GeneratedValue(generator = "default_seq")
    long id;
    long sentDate;
    long receivedDate;
    @Column(columnDefinition = "CHARACTER VARYING (16)")
    String symbol;
    @Column(columnDefinition = "CHARACTER VARYING (8)")
    String code;
    @Column(columnDefinition = "CHARACTER VARYING (16)")
    String sender;
    @Column(columnDefinition = "CHARACTER VARYING (32)")
    String info;
}
