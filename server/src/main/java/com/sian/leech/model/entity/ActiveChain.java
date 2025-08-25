package com.sian.leech.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ActiveChain {
    @Id
    @GeneratedValue(generator = "default_seq")
    long id;

    @Column(columnDefinition = "CHARACTER VARYING(16)")
    String title;

    @Column(columnDefinition = "CHARACTER VARYING(16)")
    String symbol;

    @Column(columnDefinition = "CHARACTER VARYING(32)")
    String info;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    List<ChainElement> chainElementList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @OrderBy("id ASC")
    List<MessageElement> waitList;

    boolean active;

    long startTime;
    long confirmTime;

    @Column(columnDefinition = "CHARACTER VARYING(64)")
    String tags;

    @Column(columnDefinition = "CHARACTER VARYING(256)")
    String message;


}
