package com.english.word.db.repository;

import com.english.word.db.entity.Word;
import com.english.word.db.entity.WordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, WordId> {

}
