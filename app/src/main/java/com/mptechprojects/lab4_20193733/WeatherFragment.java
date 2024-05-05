package com.mptechprojects.lab4_20193733;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mptechprojects.lab4_20193733.databinding.FragmentWeatherBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherFragment extends Fragment {

    private WeatherViewModel weatherViewModel;
    private FragmentWeatherBinding binding;
    private final static String KEY = "8dd6fc3be19ceb8601c2c3e811c16cf1";
    private List<Weather> finalListWeather;
    private AppService appService;

    private AppActivity appActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finalListWeather = new ArrayList<>();
        weatherViewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(inflater, container, false);

        binding.btnSearch.setOnClickListener(v -> {
            createRetrofitService();
            String searchTextLat = binding.etLat.getText().toString();
            String searchTextLon = binding.etLon.getText().toString();

            binding.etLat.getText().clear();
            binding.etLon.getText().clear();

            if (searchTextLat.isEmpty() || searchTextLon.isEmpty()) {
                Toast.makeText(getContext(), "Ingrese una latitud y longitud", Toast.LENGTH_LONG).show();
            } else {
                setButtonsEnabled(false);
                searchWeather(Double.parseDouble(searchTextLat), Double.parseDouble(searchTextLon));
            }
        });

        weatherViewModel.getWeathers().observe(getViewLifecycleOwner(), dataWeathers -> {
            updateRecyclerView(dataWeathers);
            setButtonsEnabled(true);
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

    private void searchWeather(Double lat, Double lon) {
        appService.getWeather(lat, lon, KEY).enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(@NonNull Call<Weather> call, @NonNull Response<Weather> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Weather weather = response.body();

                    finalListWeather.add(0, weather);
                    weatherViewModel.setWeathers(finalListWeather);
                } else {
                    Toast.makeText(getContext(), "No se encontraron ciudades", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Weather> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Error al buscar el clima", Toast.LENGTH_LONG).show();
                Log.d("WeatherFragment", "Error: " + t.getMessage());
            }
        });
    }

    private void updateRecyclerView(List<Weather> weathers) {
        WeatherAdapter adapter = new WeatherAdapter();
        adapter.setContext(getContext());
        adapter.setWeathers(weathers);
        binding.rvWeather.setAdapter(adapter);
        binding.rvWeather.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setButtonsEnabled(boolean enabled) {
        binding.btnSearch.setEnabled(enabled);
        if (requireActivity() instanceof AppActivity) {
            AppActivity appActivity = (AppActivity) requireActivity();
            appActivity.setMenuEnabled(enabled);
        }
    }
}