package com.mptechprojects.lab4_20193733;

import java.util.List;

public class Weather {

    public static class Coord {
        private double lon;
        private double lat;

        // Getters y setters
        public double getLon() { return lon; }
        public void setLon(double lon) { this.lon = lon; }
        public double getLat() { return lat; }
        public void setLat(double lat) { this.lat = lat; }
    }

    public static class WeatherCondition {
        private int id;
        private String main;
        private String description;
        private String icon;

        // Getters y setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getMain() { return main; }
        public void setMain(String main) { this.main = main; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }

    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;

        // Getters y setters
        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }
        public double getFeels_like() { return feels_like; }
        public void setFeels_like(double feels_like) { this.feels_like = feels_like; }
        public double getTemp_min() { return temp_min; }
        public void setTemp_min(double temp_min) { this.temp_min = temp_min; }
        public double getTemp_max() { return temp_max; }
        public void setTemp_max(double temp_max) { this.temp_max = temp_max; }
        public int getPressure() { return pressure; }
        public void setPressure(int pressure) { this.pressure = pressure; }
        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }

    private Coord coord;
    private List<WeatherCondition> weather;
    private String base;
    private Main main;

    // Getters y setters
    public Coord getCoord() { return coord; }
    public void setCoord(Coord coord) { this.coord = coord; }
    public List<WeatherCondition> getWeather() { return weather; }
    public void setWeather(List<WeatherCondition> weather) { this.weather = weather; }
    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }
}
