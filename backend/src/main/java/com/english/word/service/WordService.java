package com.english.word.service;

import com.english.word.response.WordResDto;

import java.util.List;

public interface WordService {
    public List<WordResDto> getTodayWordsByUnit(int startUnit, int endUnit, int wordCnt);
    public List<WordResDto> getTodayWordsByPage(int startUnit, int endUnit, int wordCnt);
    public List<WordResDto> findEnName(String krName);
}
