package id.weather;

public class WeatherData {
private HourlyWeatherData hourly;
private DailyWeatherData daily;

public HourlyWeatherData getHourly() {
    return hourly;
}

public DailyWeatherData getDaily() {
    return daily;
}

@Override
public String toString() {
    return "WeatherData{" +
            "hourly=" + hourly +
            ", daily=" + daily +
            '}';
}
}
