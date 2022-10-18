package com.english.word.db.repository;

import com.english.word.db.entity.Word;
import com.english.word.db.entity.WordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, WordId> {
    @Query(value = "select * from Word where unit between ?1 and ?2 order by rand() limit ?3", nativeQuery = true)
    List<Word> findTop20WordByUnit(int l, int r, int wordCnt);

    List<Word> findWordByKrNameContains(String krName);
}
