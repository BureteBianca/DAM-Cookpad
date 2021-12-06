package com.example.cookpad;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UtilizatorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Utilizator... utilizator);

    @Delete
    void delete(Utilizator utilizator);

    @Query("SELECT * FROM utilizator")
    public List<Utilizator> getUtilizator();

    @Query("SELECT * FROM utilizator WHERE varsta > :varsta")
    public  List<Utilizator> getUtilizatorVarstaHigher(int varsta);
}
