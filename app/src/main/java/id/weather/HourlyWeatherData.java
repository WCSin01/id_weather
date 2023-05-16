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
    return time.clone();
}

public float[] getTemperature_2m() {
    return temperature_2m.clone();
}

public float[] getApparent_temperature() {
    return apparent_temperature.clone();
}

public float[] getPrecipitation_probability() {
    return precipitation_probability.clone();
}

public int[] getWeathercode() {
    return weathercode.clone();
}

public float[] getSnow_depth() {
    return snow_depth.clone();
}

public int[] getIs_day() {
    return is_day.clone();
}

public float[] getTemperature_2m_max() {
    return temperature_2m_max.clone();
}

public float[] getTemperature_2m_min() {
    return temperature_2m_min.clone();
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
