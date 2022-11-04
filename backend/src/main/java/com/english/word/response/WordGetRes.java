package com.english.word.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class WordGetRes {
    String krName;
    String enName;
    int unit;
    int page;
}
