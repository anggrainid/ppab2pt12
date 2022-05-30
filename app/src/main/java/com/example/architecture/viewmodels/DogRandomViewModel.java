package com.example.architecture.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.architecture.models.DogRandomResponse;
import com.example.architecture.models.DogRepository;


public class DogRandomViewModel extends AndroidViewModel {

    private DogRepository dogRepository = new DogRepository();;


    private LiveData<DogRandomResponse> dogRandomLiveData = new MutableLiveData<>();
    public LiveData<DogRandomResponse> getDogRandomLiveData() {
        return dogRandomLiveData;
    }
    public DogRandomViewModel(@NonNull Application application) {
        super(application);
        this.dogRandomLiveData = dogRepository.getDogLiveData();
    }
    public void fetchDogData(){
        dogRandomLiveData = dogRepository.getRandomDogData();
    }
}
