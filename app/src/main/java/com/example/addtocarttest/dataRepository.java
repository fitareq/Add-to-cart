package com.example.addtocarttest;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class dataRepository
{
    private DataDao dataDao;
    private LiveData<List<DataClass>> data;

    public dataRepository(Application application) {
        mRoomDatabase db = mRoomDatabase.getINSTANCE(application);
        dataDao = db.dataDao();
        data = dataDao.getData();
    }

    public LiveData<List<DataClass>> getData() {
        return data;
    }

    public void setData(DataClass data) {
        mRoomDatabase.databaseWriteExecutor.execute(() -> {
            dataDao.insert(data);
        });
    }
}
