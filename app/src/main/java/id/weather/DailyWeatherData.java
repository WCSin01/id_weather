package id.weather;

import java.time.LocalDate;
import java.util.Arrays;

public class DailyWeatherData {
private LocalDate[] time;
private float[] temperature_2m_max;
private float[] temperature_2m_min;
private float[] precipitation_probability_mean;
private int[] weathercode;

public LocalDate getDay(int idx) {
    return time[idx];
}

public float getTemperature_2m_max(int idx) {
    return temperature_2m_max[idx];
}

public float getTemperature_2m_min(int idx) {
    return temperature_2m_min[idx];
}

public float getPrecipitation_probability_mean(int idx) {
    return precipitation_probability_mean[idx];
}

public int getWeathercode(int idx) {
    return weathercode[idx];
}

@Override
public String toString() {
    return "DailyWeatherData{" +
            "time=" + Arrays.toString(time) +
            ", temperature_2m_max=" + Arrays.toString(temperature_2m_max) +
            ", temperature_2m_min=" + Arrays.toString(temperature_2m_min) +
            ", precipitation_probability_mean=" + Arrays.toString(precipitation_probability_mean) +
            ", weathercode=" + Arrays.toString(weathercode) +
            '}';
}
}
