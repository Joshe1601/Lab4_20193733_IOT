package com.mptechprojects.lab4_20193733;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mptechprojects.lab4_20193733.databinding.FragmentGeolocationBinding;
import com.mptechprojects.lab4_20193733.databinding.FragmentWeatherBinding;


public class WeatherFragment extends Fragment {

    private FragmentWeatherBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentWeatherBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}