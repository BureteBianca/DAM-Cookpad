package com.example.cookpad;

import android.content.Context;

import androidx.room.Room;

public class Database {

    private static Database database;
    private DatabaseUtilizator databaseUtilizator;
    private Database(Context context){
        databaseUtilizator = Room.databaseBuilder(context,
                DatabaseUtilizator.class, "utilizator-database").build();
    }

    public static Database getInstance(Context context){
        synchronized (DatabaseUtilizator.class) {
            if (database == null) {
                database = new Database(context);
            }
            return database;
        }
    }
    public DatabaseUtilizator getDataBase(){
        return databaseUtilizator;
    }

}
