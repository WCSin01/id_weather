package id.weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.Callback;
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

private WeatherApi() {}
public static Future<WeatherData> updateWeatherData() {
    LocalDate dateToday = LocalDate.now();
    String today = dateToday.toString();
    String weekLater = dateToday.plusWeeks(1).toString();
    CompletableFuture<WeatherData> weatherDataFuture = new CompletableFuture<>();

    Request request = new Request.Builder()
            .url("https://api.open-meteo.com/v1/forecast?" +
            "latitude=52.20&longitude=0.12&" +
            "hourly=temperature_2m,apparent_temperature,precipitation_probability,weathercode,snow_depth,is_day&" +
            "daily=temperature_2m_max,temperature_2m_min,precipitation_probability_mean,weathercode&" +
            "start_date=" + today +
            "&end_date=" + weekLater +
            "&timezone=Europe%2FLondon")
            .build();
    Call call = client.newCall(request);
    // async
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            // todo: handle error
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (!response.isSuccessful()) {
                throw new IOException(response.toString());
            }
            String res = response.body().string();
            weatherDataFuture.complete(gsonParser.fromJson(res, WeatherData.class));
        }
    });

    return weatherDataFuture;
}
}
