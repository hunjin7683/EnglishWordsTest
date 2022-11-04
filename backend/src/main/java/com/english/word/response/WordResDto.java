package com.english.word.response;

import com.english.word.db.entity.Word;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WordResDto {
    String krName;
    String enName;
    int unit;
    int page;

    public static WordResDto of(Word word) {
        if (word == null)
            return null;

        return WordResDto.builder()
                .krName(word.getKrName())
                .enName(word.getEnName())
                .unit(word.getUnit())
                .page(word.getPage())
                .build();
    }
}
