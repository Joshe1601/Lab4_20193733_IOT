package com.mptechprojects.lab4_20193733;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AppService {

    @GET("/geo/1.0/direct")
    Call<List<Geolocation>> getGeolocation(@Query("q") String q, @Query("limit") Integer number, @Query("appid") String appId);
}
