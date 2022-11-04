package com.english.word.service;

import com.english.word.db.repository.WordRepository;
import com.english.word.response.WordGetRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Override
    public List<WordGetRes> getTodayWordsByUnit(int startUnit, int endUnit, int wordCnt) {
        List<WordGetRes> wordResDtoList = wordRepository.findTodayWordsByUnit(startUnit, endUnit, wordCnt).stream()
                .map(word -> word.toWordGetRes()).collect(Collectors.toList());

        int cnt = 1;
        for (WordGetRes word: wordResDtoList) {
            System.out.print(cnt + ". ");
            System.out.println(word.getKrName());
//            System.out.print("enName: " + word.getEnName());
//            System.out.println("unit: " + word.getUnit());
            cnt++;
        }

        return wordResDtoList;
    }

    @Override
    public List<WordGetRes> getTodayWordsByPage(int startPage, int endPage, int wordCnt) {
        List<WordGetRes> wordResDtoList = wordRepository.findTodayWordsByPage(startPage, endPage, wordCnt).stream()
                .map(word -> word.toWordGetRes()).collect(Collectors.toList());

        int cnt = 1;
        for (WordGetRes word: wordResDtoList) {
            System.out.print(cnt + ". ");
            System.out.println(word.getKrName());
//            System.out.print("enName: " + word.getEnName());
//            System.out.println("unit: " + word.getUnit());
            cnt++;
        }

        return wordResDtoList;
    }

    @Override
    public List<WordGetRes> findEnName(String krName) {
        return wordRepository.findWordByKrNameContains(krName).stream().map(word -> word.toWordGetRes()).collect(Collectors.toList());
    }
}
