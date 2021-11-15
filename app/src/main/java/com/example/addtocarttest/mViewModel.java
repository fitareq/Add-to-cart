package com.example.addtocarttest;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class mViewModel extends AndroidViewModel {

    dataRepository repository;
    LiveData<List<DataClass>> data;
    public mViewModel(@NonNull Application application) {
        super(application);
        repository = new dataRepository(application);
        data = repository.getData();
    }

    public LiveData<List<DataClass>> getData() {
        return data;
    }
    public void setData(DataClass data)
    {
        repository.setData(data);
    }
}
