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
    String name;
    @OneToMany
    List<Element> elementList;
    boolean enabled;
}
