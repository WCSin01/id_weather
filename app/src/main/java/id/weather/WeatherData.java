package id.weather;

public class WeatherData {
private boolean isSuccess;
private HourlyWeatherData hourly;
private DailyWeatherData daily;

public WeatherData() {
    this.isSuccess = true;
}

public WeatherData(boolean isSuccess) {
    this.isSuccess = false;
}

public boolean getIsSuccess() {
    return isSuccess;
}

public HourlyWeatherData getHourly() {
    return hourly;
}

public DailyWeatherData getDaily() {
    return daily;
}

@Override
public String toString() {
    return "WeatherData{" +
            "isSuccess=" + isSuccess +
            ", hourly=" + hourly +
            ", daily=" + daily +
            '}';
}
}
