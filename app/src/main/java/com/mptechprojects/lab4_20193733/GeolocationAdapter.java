package com.mptechprojects.lab4_20193733;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;
import java.util.List;

public class GeolocationAdapter extends RecyclerView.Adapter<GeolocationAdapter.GeolocationViewHolder> {
    private List<Geolocation> geolocation;
    private Context context;

    @NonNull
    @Override
    public GeolocationAdapter.GeolocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_geolocation, parent, false);
        return new GeolocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeolocationAdapter.GeolocationViewHolder holder, int position) {
        Geolocation g = geolocation.get(position);
        holder.geolocation = g;

        TextView textViewName = holder.itemView.findViewById(R.id.tvPlaceName);
        textViewName.setText(g.getName());

        TextView textViewEmail = holder.itemView.findViewById(R.id.tvLat);
        textViewEmail.setText(g.getLat().toString());

        TextView textViewDni = holder.itemView.findViewById(R.id.tvLon);
        textViewDni.setText(g.getLon().toString());
    }

    @Override
    public int getItemCount() {
        return geolocation.size();
    }

    public class GeolocationViewHolder extends RecyclerView.ViewHolder {

        Geolocation geolocation;
        public GeolocationViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public List<Geolocation> getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(List<Geolocation> geolocation) {
        this.geolocation = geolocation;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
