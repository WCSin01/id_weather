package id.weather;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Weathercode {
// simplified
private static final Map<Integer, String> weathercodeToText = ImmutableMap.<Integer, String>builder()
        .put(0, "clear")
        .put(1, "clear")
        .put(2, "partly cloudy")
        .put(3, "cloudy")
        .put(45, "fog")
        .put(51, "drizzle")
        .put(53, "drizzle")
        .put(55, "drizzle")
        .put(61, "rain")
        .put(62, "rain")
        .put(65, "heavy rain")
        .put(66, "freezing rain")
        .put(67, "freezing rain")
        .put(71, "light snow")
        .put(73, "moderate snow")
        .put(75, "heavy snow")
        .put(80, "light passing showers")
        .put(81, "moderate passing showers")
        .put(82, "heavy passing showers")
        .put(85, "light passing snow")
        .put(86, "heavy passing snow")
        .put(95, "thunderstorm")
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
private static final Map<Integer, Integer> weatherToBackground = ImmutableMap.<Integer, Integer>builder()
        .put(0, R.drawable.clear_background)
        .put(1, R.drawable.clear_background)
        .put(2, R.drawable.clear_background)
        .put(3, R.drawable.clear_background)
        .put(45, R.drawable.fog_background)
        .put(51, R.drawable.rain_background)
        .put(53, R.drawable.rain_background)
        .put(55, R.drawable.rain_background)
        .put(61, R.drawable.rain_background)
        .put(62, R.drawable.rain_background)
        .put(65, R.drawable.rain_background)
        .put(66, R.drawable.rain_background)
        .put(67, R.drawable.rain_background)
        .put(71, R.drawable.snow_background)
        .put(73, R.drawable.snow_background)
        .put(75, R.drawable.snow_background)
        .put(80, R.drawable.rain_background)
        .put(81, R.drawable.rain_background)
        .put(82, R.drawable.rain_background)
        .put(85, R.drawable.snow_background)
        .put(86, R.drawable.snow_background)
        .put(95, R.drawable.thunderstorm_background)
        .put(48, R.drawable.transparent)
        .put(56, R.drawable.transparent)
        .put(47, R.drawable.transparent)
        .put(77, R.drawable.transparent)
        .build();

private Weathercode() {
}

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

public static int toBackground(int weathercode, int is_day) {
    if (is_day == 0) {
        if (weathercode == 0 || weathercode == 1) {
            return R.drawable.night_background;
        } else if (weathercode == 2) {
            return R.drawable.night_background;
        }
    }
    return weatherToBackground.get(weathercode);
}
}
