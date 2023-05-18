package id.weather;

import java.io.IOException;
import java.util.HashSet;

public class Weather {
private static Weather instance;
private static HashSet<IObserver> observers;

private Weather() {
    observers = new HashSet<>();
}

public static Weather getInstance() {
    if (instance == null) {
        instance = new Weather();
    }
    return instance;
}

public void attach(IObserver observer) {
    observers.add(observer);
}

public void detach(IObserver observer) {
    observers.remove(observer);
}

public void updateWeather() {
    new Thread(() -> {
        while (true) {
            try {
                WeatherData weatherData = WeatherApi.updateWeatherData();
                for (IObserver o : observers) {
                    o.update(weatherData);
                }
            } catch (IOException e) {
                for (IObserver o : observers) {
                    WeatherData unsuccessful = new WeatherData(false);
                    o.update(unsuccessful);
                }
            }
            try {
                Thread.sleep(2 * 60 * 1000); // 2 min
            } catch (InterruptedException e) {
                // unhandled
            }
        }
    }).start();
}
}
