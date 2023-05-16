package id.weather;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Weather {
    Weather instance;
    HashSet<IObserver> observers;

    private Weather() {
        this.observers = new HashSet<>();
    }

    public Weather getInstance() {
        if (this.instance == null) {
        return new Weather();
        } else {
            return instance;
        }
    }

    public void attach(IObserver observer) { this.observers.add(observer); }
    public void attach(HashSet<IObserver> observers) { this.observers.addAll(observers); }

    public void detach(IObserver observer) {
        this.observers.remove(observer);
    }
    public void detach(HashSet<IObserver> observers) { this.observers.removeAll(observers); }

    // call method in a separate thread
    public void updateWeather() throws InterruptedException, ExecutionException {
        while (true) {
            Future<WeatherData> weatherDataFuture = WeatherApi.updateWeatherData();
            try {
                WeatherData weatherData = weatherDataFuture.get(10L, TimeUnit.SECONDS);
                for (IObserver o : observers) {
                    o.update(weatherData);
                }
            } catch (TimeoutException e) {
                // todo: handle exception
            } finally {
                Thread.sleep(2*60*1000); // 2 min
            }
        }
    }
}
