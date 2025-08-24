package com.sian.leech.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Accessors( chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ChainElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "default_seq")
    long id;

    // Fields copied from Element
    @Column(length = 16)
    String code;

    @Column(length = 64)
    String title;
}
