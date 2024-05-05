package com.mptechprojects.lab4_20193733;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class WeatherViewModel extends ViewModel {

    private final MutableLiveData<List<Weather>> weathers = new MutableLiveData<>(new ArrayList<>());


    public LiveData<List<Weather>> getWeathers() {
        return weathers;
    }
    public void setWeathers(List<Weather> dataWeather) {
        weathers.setValue(dataWeather);
    }
}
