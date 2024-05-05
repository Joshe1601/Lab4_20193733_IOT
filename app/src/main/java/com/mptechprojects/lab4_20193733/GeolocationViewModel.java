package com.mptechprojects.lab4_20193733;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class GeolocationViewModel extends ViewModel {

    private final MutableLiveData<List<Geolocation>> geolocations = new MutableLiveData<>(new ArrayList<>());


    public LiveData<List<Geolocation>> getGeolocations() {
        return geolocations;
    }
    public void setGeolocations(List<Geolocation> locations) {
        geolocations.setValue(locations);
    }
}
