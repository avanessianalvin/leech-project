package com.sian.leech.model.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class Element implements Cloneable{
    @Id
    @GeneratedValue(generator = "default_seq",strategy = GenerationType.AUTO)
    long id;
    @Column(columnDefinition = "CHARACTER VARYING(8)")
    String code;
    @Column(columnDefinition = "CHARACTER VARYING(32)")
    String title;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
