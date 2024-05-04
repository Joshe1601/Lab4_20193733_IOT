package com.mptechprojects.lab4_20193733;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mptechprojects.lab4_20193733.databinding.FragmentGeolocationBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeolocationFragment extends Fragment {

    private FragmentGeolocationBinding binding;
    private final static String KEY = "8dd6fc3be19ceb8601c2c3e811c16cf1";

    private List<Geolocation> finalListGeolocation;

    AppService appService;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        finalListGeolocation = new ArrayList<>();

        binding = FragmentGeolocationBinding.inflate(inflater, container, false);

        binding.btnSearch.setOnClickListener(v -> {
            createRetrofitService();
            String searchText = binding.etCity.getText().toString();
            binding.etCity.getText().clear();
            searchWeather(searchText);
        });



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void createRetrofitService() {
        appService = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AppService.class);
    }

    private void searchWeather(String searchText) {
        appService.getGeolocation(searchText, 1, KEY).enqueue(new Callback<List<Geolocation>>() {
            @Override
            public void onResponse(@NonNull Call<List<Geolocation>> call, @NonNull Response<List<Geolocation>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Geolocation> geolocation = response.body();


                    finalListGeolocation.add(0, geolocation.get(0));

                    GeolocationAdapter adapter = new GeolocationAdapter();
                    adapter.setContext(getContext());
                    adapter.setGeolocation(finalListGeolocation);

                    binding.rvGeolocation.setAdapter(adapter);
                    binding.rvGeolocation.setLayoutManager(new LinearLayoutManager(getContext()));
                } else {
                    Toast.makeText(getContext(), "No se encontraron ciudades", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<List<Geolocation>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Error al buscar la ciudad", Toast.LENGTH_LONG).show();
                Log.d("GeolocationFragment", "Error: " + t.getMessage());
            }
        });
    }


}