package com.example.addtocarttest;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DataClass dataClass);
    @Query("SELECT * FROM data")
    LiveData<List<DataClass>> getData();
    @Delete
    void delete(DataClass dataClass);

}
