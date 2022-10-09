package com.english.word.service;

import com.english.word.response.WordResDto;

import java.util.List;

public interface WordService {
    public List<WordResDto> getTodayWords(String startUnit, String endUnit, int wordCnt);
    public List<WordResDto> findEnName(String krName);
}
