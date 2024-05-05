package com.mptechprojects.lab4_20193733;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Weather> weathers;
    private Context context;


    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_weather, parent, false);
        return new WeatherAdapter.WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        Weather w = weathers.get(position);
        holder.weather = w;

        TextView textViewName = holder.itemView.findViewById(R.id.tvPlaceName);

        if (w.getName() == null) {
            textViewName.setText("Desconocido");
        } else {
            textViewName.setText(w.getName());
        }

        TextView textViewTemp = holder.itemView.findViewById(R.id.tvTemp);
        textViewTemp.setText(MessageFormat.format("{0}K", w.getMain().getTemp().toString()));

        TextView textViewLat = holder.itemView.findViewById(R.id.tvMinTemp);
        textViewLat.setText(MessageFormat.format("{0}K", w.getMain().getTemp_max().toString()));

        TextView textViewLon = holder.itemView.findViewById(R.id.tvMaxTemp);
        textViewLon.setText(MessageFormat.format("{0}K", w.getMain().getTemp_min().toString()));

    }

    @Override
    public int getItemCount() {
        return weathers.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        Weather weather;
        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
