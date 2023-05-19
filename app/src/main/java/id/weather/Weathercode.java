package id.weather;


import android.widget.ImageView;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class Weathercode {
private Weathercode() {}

// simplified
private static final Map<Integer, String> weathercodeToText = ImmutableMap.<Integer, String>builder()
        .put(0, "Clear")
        .put(1, "Clear")
        .put(2, "Partly Cloudy")
        .put(3, "Cloudy")
        .put(45, "Fog")
        .put(51, "Drizzle")
        .put(53, "Drizzle")
        .put(55, "Drizzle")
        .put(61, "Rain")
        .put(62, "Rain")
        .put(65, "Heavy Rain")
        .put(66, "Sleet")
        .put(67, "Sleet")
        .put(71, "Light Snow")
        .put(73, "Moderate Snow")
        .put(75, "Heavy Snow")
        .put(80, "Light Passing Showers")
        .put(81, "Moderate Passing Showers")
        .put(82, "Heavy Passing Showers")
        .put(85, "Light Passing Snow")
        .put(86, "Heavy Passing Snow")
        .put(95, "Thunderstorm")
        .put(48, "Not supported")
        .put(56, "Not supported")
        .put(47, "Not supported")
        .put(77, "Not supported")
        .build();

// To use:
//  ImageView weather_icon = findViewById(R.id.weather_icon);
//  weather_icon.setImageResource(R.drawable.clear);
private static final Map<Integer, Integer> weathercodeToIcon = ImmutableMap.<Integer, Integer>builder()
        .put(0, R.drawable.clear)
        .put(1, R.drawable.clear)
        .put(2, R.drawable.partly_cloudy)
        .put(3, R.drawable.cloudy)
        .put(45, R.drawable.fog)
        .put(51, R.drawable.drizzle)
        .put(53, R.drawable.drizzle)
        .put(55, R.drawable.drizzle)
        .put(61, R.drawable.rain)
        .put(62, R.drawable.rain)
        .put(65, R.drawable.heavy_rain)
        .put(66, R.drawable.freezing_rain)
        .put(67, R.drawable.freezing_rain)
        .put(71, R.drawable.snow)
        .put(73, R.drawable.snow)
        .put(75, R.drawable.heavy_snow)
        .put(80, R.drawable.rain)
        .put(81, R.drawable.rain)
        .put(82, R.drawable.heavy_rain)
        .put(85, R.drawable.snow)
        .put(86, R.drawable.heavy_snow)
        .put(95, R.drawable.thunderstorm)
        .put(48, R.drawable.transparent)
        .put(56, R.drawable.transparent)
        .put(47, R.drawable.transparent)
        .put(77, R.drawable.transparent)
        .build();

public static String toText(int weathercode) {
    return weathercodeToText.get(weathercode);
}

public static int toIcon(int weathercode, int is_day) {
    if (is_day == 0) {
        if (weathercode == 0 || weathercode == 1) {
            return R.drawable.clear_night;
        } else if (weathercode == 2) {
            return R.drawable.partly_cloudy_night;
        }
    }
    return weathercodeToIcon.get(weathercode);
}
}
