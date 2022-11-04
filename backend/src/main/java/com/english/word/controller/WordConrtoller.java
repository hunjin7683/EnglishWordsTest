package com.english.word.controller;

import com.english.word.response.WordGetRes;
import com.english.word.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/word")
@RequiredArgsConstructor
public class WordConrtoller {
    private final WordService wordService;

    @GetMapping("/today/unit/{startUnit}/{endUnit}/{wordCnt}")
    public ResponseEntity<List<WordGetRes>> getTodayWordsByUnit(@PathVariable("startUnit") int startUnit, @PathVariable("endUnit") int endUnit, @PathVariable("wordCnt") int wordCnt) {
        return new ResponseEntity<>(wordService.getTodayWordsByUnit(startUnit, endUnit, wordCnt), HttpStatus.OK);
    }

    @GetMapping("/today/page/{startPage}/{endPage}/{wordCnt}")
    public ResponseEntity<List<WordGetRes>> getTodayWordsByPage(@PathVariable("startPage") int startPage, @PathVariable("endPage") int endPage, @PathVariable("wordCnt") int wordCnt) {
        return new ResponseEntity<>(wordService.getTodayWordsByPage(startPage, endPage, wordCnt), HttpStatus.OK);
    }

    @GetMapping("/match/{krName}")
    public ResponseEntity<List<WordGetRes>> findEnName(@PathVariable("krName") String krName) {
        return new ResponseEntity<>(wordService.findEnName(krName), HttpStatus.OK);
    }
}
