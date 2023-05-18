package id.weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherApi {
private static final Gson gsonParser = new GsonBuilder()
        .registerTypeAdapter(
                LocalDateTime.class,
                (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                        LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
        .registerTypeAdapter(
                LocalDate.class,
                (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
                        LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
        .create();
private static final OkHttpClient client = new OkHttpClient();

private WeatherApi() {
}

public static WeatherData updateWeatherData() throws IOException {
    LocalDate dateToday = LocalDate.now();

    Request request = new Request.Builder()
            .url("https://api.open-meteo.com/v1/forecast?" +
                    "latitude=52.20&longitude=0.12&" +
                    "hourly=temperature_2m,apparent_temperature,precipitation_probability,weathercode,snow_depth,is_day&" +
                    "daily=temperature_2m_max,temperature_2m_min,precipitation_probability_mean,weathercode&" +
                    "start_date=" + dateToday.toString() +
                    "&end_date=" + dateToday.plusWeeks(1).toString() +
                    "&timezone=Europe%2FLondon")
            .build();

    try (Response res = client.newCall(request).execute()) {
        return gsonParser.fromJson(res.body().string(), WeatherData.class);
    }
}
}
