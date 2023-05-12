package id.weather;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Weather {
    List<IObserver> observers;

    public void attach(IObserver observer) {
        this.observers.add(observer);
    }

    public void detach(IObserver observer) {
        this.observers.remove(observer);
    }

    // call method in a separate thread
    public void updateWeather() throws InterruptedException, ExecutionException {
        while (true) {
            Future<WeatherData> weatherDataFuture = WeatherApi.updateWeatherData();
            while (!weatherDataFuture.isDone()) {
                Thread.sleep(100);
            }
            WeatherData weatherData = weatherDataFuture.get();
            for (IObserver o: observers) {
                o.update(weatherData);
            }
            Thread.sleep(2*60*1000); // 2 min
        }
    }
}
