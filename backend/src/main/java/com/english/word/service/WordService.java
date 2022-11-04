package com.english.word.service;

import com.english.word.response.WordGetRes;

import java.util.List;

public interface WordService {
    public List<WordGetRes> getTodayWordsByUnit(int startUnit, int endUnit, int wordCnt);
    public List<WordGetRes> getTodayWordsByPage(int startPage, int endPage, int wordCnt);
    public List<WordGetRes> findEnName(String krName);
}
