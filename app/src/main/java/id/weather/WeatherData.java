package id.weather;

public class WeatherData {
private HourlyWeatherData hourly;
private DailyWeatherData daily;

public HourlyWeatherData getHourly() {
    return hourly;
}

public void setHourly(HourlyWeatherData hourly) {
    this.hourly = hourly;
}

public DailyWeatherData getDaily() {
    return daily;
}

public void setDaily(DailyWeatherData daily) {
    this.daily = daily;
}

@Override
public String toString() {
    return "WeatherData{" +
            "hourly=" + hourly +
            ", daily=" + daily +
            '}';
}
}
