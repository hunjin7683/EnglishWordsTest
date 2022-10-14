package com.english.word.service;

import com.english.word.db.repository.WordRepository;
import com.english.word.response.WordResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Override
    public List<WordResDto> getTodayWords(String startUnit, String endUnit, int wordCnt) {
        List<WordResDto> wordResDtoList = wordRepository.findTop20WordByUnit(startUnit, endUnit, wordCnt).stream()
                .map(word -> WordResDto.of(word)).collect(Collectors.toList());

        int cnt = 1;
        for (WordResDto word: wordResDtoList) {
            System.out.print(cnt + ". ");
            System.out.println(word.getKrName());
//            System.out.print("enName: " + word.getEnName());
//            System.out.println("unit: " + word.getUnit());
            cnt++;
        }

        return wordResDtoList;
    }

    @Override
    public List<WordResDto> findEnName(String krName) {
        return wordRepository.findWordByKrNameContains(krName).stream().map(word -> WordResDto.of(word)).collect(Collectors.toList());
    }
}
