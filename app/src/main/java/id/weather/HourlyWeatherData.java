package id.weather;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HourlyWeatherData {
private LocalDateTime[] time;
private float[] temperature_2m;
private float[] apparent_temperature;
private float[] precipitation_probability;
private int[] weathercode;
private float[] snow_depth;
private int[] is_day;
private float[] temperature_2m_max;
private float[] temperature_2m_min;

public LocalDateTime[] getTime() {
    return time;
}

public void setTime(LocalDateTime[] time) {
    this.time = time;
}

public float[] getTemperature_2m() {
    return temperature_2m;
}

public void setTemperature_2m(float[] temperature_2m) {
    this.temperature_2m = temperature_2m;
}

public float[] getApparent_temperature() {
    return apparent_temperature;
}

public void setApparent_temperature(float[] apparent_temperature) {
    this.apparent_temperature = apparent_temperature;
}

public float[] getPrecipitation_probability() {
    return precipitation_probability;
}

public void setPrecipitation_probability(float[] precipitation_probability) {
    this.precipitation_probability = precipitation_probability;
}

public int[] getWeathercode() {
    return weathercode;
}

public void setWeathercode(int[] weathercode) {
    this.weathercode = weathercode;
}

public float[] getSnow_depth() {
    return snow_depth;
}

public void setSnow_depth(float[] snow_depth) {
    this.snow_depth = snow_depth;
}

public int[] getIs_day() {
    return is_day;
}

public void setIs_day(int[] is_day) {
    this.is_day = is_day;
}

public float[] getTemperature_2m_max() {
    return temperature_2m_max;
}

public void setTemperature_2m_max(float[] temperature_2m_max) {
    this.temperature_2m_max = temperature_2m_max;
}

public float[] getTemperature_2m_min() {
    return temperature_2m_min;
}

public void setTemperature_2m_min(float[] temperature_2m_min) {
    this.temperature_2m_min = temperature_2m_min;
}

@Override
public String toString() {
    return "HourlyWeatherData{" +
            "time=" + Arrays.toString(time) +
            ", temperature_2m=" + Arrays.toString(temperature_2m) +
            ", apparent_temperature=" + Arrays.toString(apparent_temperature) +
            ", precipitation_probability=" + Arrays.toString(precipitation_probability) +
            ", weathercode=" + Arrays.toString(weathercode) +
            ", snow_depth=" + Arrays.toString(snow_depth) +
            ", is_day=" + Arrays.toString(is_day) +
            ", temperature_2m_max=" + Arrays.toString(temperature_2m_max) +
            ", temperature_2m_min=" + Arrays.toString(temperature_2m_min) +
            '}';
}
}
