package com.example.notesappconqueringfirebase.databaseFirebase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesappconqueringfirebase.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class databaseRoom extends RoomDatabase
{
    private static databaseRoom database;
    private static String DATABASE_NAME = "NoteApp";

    public synchronized static databaseRoom getInstance(Context context)
    {
        if(database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                            databaseRoom.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract MainDataAccessObject mainDataAccessObject();
}

