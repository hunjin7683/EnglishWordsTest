package com.english.word.db.entity;

import com.english.word.response.WordGetRes;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@IdClass(WordId.class)
@NoArgsConstructor
public class Word {
    @Id
    String krName;
    @Id
    String enName;
    @Id
    int unit;
    int page;

    public Word(String krName, String enName, int unit, int page) {
        this.krName = krName;
        this.enName = enName;
        this.unit = unit;
        this.page = page;
    }

    public WordGetRes toWordGetRes() {
        return WordGetRes.builder()
                .krName(this.krName)
                .enName(this.enName)
                .unit(this.unit)
                .page(this.page)
                .build();
    }
}
