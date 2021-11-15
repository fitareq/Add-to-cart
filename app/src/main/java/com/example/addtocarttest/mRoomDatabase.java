package com.example.addtocarttest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DataClass.class},version = 1, exportSchema = false)
public abstract class mRoomDatabase extends RoomDatabase {
    public abstract DataDao dataDao();

    public static volatile mRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static mRoomDatabase getINSTANCE(Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (mRoomDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), mRoomDatabase.class,"localdata").build();
                }
            }
        }
        return INSTANCE;
    }

}
