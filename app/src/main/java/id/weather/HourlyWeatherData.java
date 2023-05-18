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

public LocalDateTime getTime(int idx) {
    return time[idx];
}

public float getTemperature_2m(int idx) {
    return temperature_2m[idx];
}

public float getApparent_temperature(int idx) {
    return apparent_temperature[idx];
}

public float getPrecipitation_probability(int idx) {
    return precipitation_probability[idx];
}

public int getWeathercode(int idx) {
    return weathercode[idx];
}

public float getSnow_depth(int idx) {
    return snow_depth[idx];
}

public boolean getIs_day(int idx) {
    if (is_day[idx] == 1) {
        return true;
    } else if (is_day[idx] == 0) {
        return false;
    }
    throw new ArrayStoreException("Data corrupted");
}

public float getTemperature_2m_max(int idx) {
    return temperature_2m_max[idx];
}

public float getTemperature_2m_min(int idx) {
    return temperature_2m_min[idx];
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
