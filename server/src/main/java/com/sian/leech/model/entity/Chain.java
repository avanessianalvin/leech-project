package com.sian.leech.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Chain {
    @Id
    @GeneratedValue(generator = "default_seq", strategy = GenerationType.AUTO)
    long id;
    @Column(columnDefinition = "CHARACTER VARYING(16)")
    String title;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "FK")
    List<ChainElement> elementList;
    @Column(columnDefinition = "CHARACTER VARYING")
    String symbols;
    @Column(columnDefinition = "CHARACTER VARYING")
    String sequence;
    @Column(columnDefinition = "CHARACTER VARYING(32)")
    String description;
    boolean enabled;
    @Column(columnDefinition = "CHARACTER VARYING(64)")
    String telegramTags;
    @Column(columnDefinition = "CHARACTER VARYING(256)")
    String message;
}
