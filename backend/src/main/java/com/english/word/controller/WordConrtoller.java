package com.english.word.controller;

import com.english.word.response.WordResDto;
import com.english.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/word")
public class WordConrtoller {
    @Autowired
    WordService wordService;

    @GetMapping("/today/{startUnit}/{endUnit}/{wordCnt}")
    public ResponseEntity<List<WordResDto>> getTodayWords(@PathVariable("startUnit") String startUnit, @PathVariable("endUnit") String endUnit, @PathVariable("wordCnt") int wordCnt) {
        return new ResponseEntity<>(wordService.getTodayWords(startUnit, endUnit, wordCnt), HttpStatus.OK);
    }
}
