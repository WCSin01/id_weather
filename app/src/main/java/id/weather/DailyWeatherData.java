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
    return time;
}

public void setTime(LocalDate[] time) {
    this.time = time;
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

public float[] getPrecipitation_probability_mean() {
    return precipitation_probability_mean;
}

public void setPrecipitation_probability_mean(float[] precipitation_probability_mean) {
    this.precipitation_probability_mean = precipitation_probability_mean;
}

public int[] getWeathercode() {
    return weathercode;
}

public void setWeathercode(int[] weathercode) {
    this.weathercode = weathercode;
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
