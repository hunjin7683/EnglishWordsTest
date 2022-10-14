package com.english.word.controller;

import com.english.word.response.WordResDto;
import com.english.word.service.WordService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class WordConrtoller {
    private final WordService wordService;

    @GetMapping("/today/{startUnit}/{endUnit}/{wordCnt}")
    public ResponseEntity<List<WordResDto>> getTodayWords(@PathVariable("startUnit") String startUnit, @PathVariable("endUnit") String endUnit, @PathVariable("wordCnt") int wordCnt) {
        return new ResponseEntity<>(wordService.getTodayWords(startUnit, endUnit, wordCnt), HttpStatus.OK);
    }

    @GetMapping("/match/{krName}")
    public ResponseEntity<List<WordResDto>> findEnName(@PathVariable("krName") String krName) {
        return new ResponseEntity<>(wordService.findEnName(krName), HttpStatus.OK);
    }
}
