package id.weather;

import java.time.LocalDate;
import java.util.Arrays;

public class DailyWeatherData {
private LocalDate[] time;
private float[] temperature_2m_max;
private float[] temperature_2m_min;
private float[] precipitation_probability_mean;
private int[] weathercode;

public LocalDate[] getTime() {
    return time.clone();
}

public float[] getTemperature_2m_max() {
    return temperature_2m_max.clone();
}

public float[] getTemperature_2m_min() {
    return temperature_2m_min.clone();
}

public float[] getPrecipitation_probability_mean() {
    return precipitation_probability_mean.clone();
}

public int[] getWeathercode() {
    return weathercode.clone();
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
