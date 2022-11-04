package com.english.word.db.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(WordId.class)
public class Word {
    @Id
    String krName;
    @Id
    String enName;
    @Id
    int unit;
    int page;
}
