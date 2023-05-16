package id.weather;


import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class Weathercode {
private Weathercode() {}

// simplified
private static Map<Integer, String> weathercodeToText = ImmutableMap.<Integer, String>builder()
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

// todo: map onto image path?
private static Map<Integer, String> weathercodeToIcon = ImmutableMap.<Integer, String>builder()
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

public static String toText(int weathercode) {
    return weathercodeToText.get(weathercode);
}

public static String toIcon(int weathercode) {
    return weathercodeToIcon.get(weathercode);
}
}
