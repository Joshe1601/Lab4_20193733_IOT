package com.mptechprojects.lab4_20193733;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mptechprojects.lab4_20193733.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnected();

        binding.btnInto.setOnClickListener(v -> {

            if(!isConnected) {
                showDialog(v);
                return;
            }

            Intent intent = new Intent(MainActivity.this, AppActivity.class);
            startActivity(intent);
        });
    }

    public void showDialog(View view) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("No hay conexión a internet");
        builder.setMessage("No se pudo establecer una conexión con Internet. " +
                        "Por favor, conecte su dispositivo para continuar.");
        builder.setPositiveButton("Aceptar", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.setNeutralButton("Configuración", (dialog, which) -> {
            Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
            startActivity(intent);
        });
        builder.show();


    }
}