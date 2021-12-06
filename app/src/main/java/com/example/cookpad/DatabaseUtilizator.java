package com.example.cookpad;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Utilizator.class},version = 1,exportSchema = false)
public abstract class DatabaseUtilizator extends RoomDatabase {
    public abstract UtilizatorDAO utilizatorDAO();
}
