package com.mptechprojects.lab4_20193733;

import java.util.List;

public class Weather {

    public static class Coord {
        private Double lon;
        private Double lat;

        public Double getLon() { return lon; }
        public void setLon(Double lon) { this.lon = lon; }
        public Double getLat() { return lat; }
        public void setLat(Double lat) { this.lat = lat; }
    }

    public static class WeatherCondition {
        private Integer id;
        private String main;
        private String description;
        private String icon;

        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
        public String getMain() { return main; }
        public void setMain(String main) { this.main = main; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }

    public static class Main {
        private Double temp;
        private Double feels_like;
        private Double temp_min;
        private Double temp_max;
        private Integer pressure;
        private Integer humidity;

        public Double getTemp() { return temp; }
        public void setTemp(Double temp) { this.temp = temp; }
        public Double getFeels_like() { return feels_like; }
        public void setFeels_like(Double feels_like) { this.feels_like = feels_like; }
        public Double getTemp_min() { return temp_min; }
        public void setTemp_min(Double temp_min) { this.temp_min = temp_min; }
        public Double getTemp_max() { return temp_max; }
        public void setTemp_max(Double temp_max) { this.temp_max = temp_max; }
        public Integer getPressure() { return pressure; }
        public void setPressure(Integer pressure) { this.pressure = pressure; }
        public Integer getHumidity() { return humidity; }
        public void setHumidity(Integer humidity) { this.humidity = humidity; }
    }

    private Coord coord;
    private List<WeatherCondition> weather;
    private String base;
    private Main main;
    private String name;

    public Coord getCoord() { return coord; }
    public void setCoord(Coord coord) { this.coord = coord; }
    public List<WeatherCondition> getWeather() { return weather; }
    public void setWeather(List<WeatherCondition> weather) { this.weather = weather; }
    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }
    public Main getMain() { return main; }
    public void setMain(Main main) { this.main = main; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
