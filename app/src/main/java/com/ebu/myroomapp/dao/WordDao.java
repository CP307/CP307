package com.ebu.myroomapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ebu.myroomapp.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM words")
    void deleteAll();

    @Query("SELECT * FROM words ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();
}
