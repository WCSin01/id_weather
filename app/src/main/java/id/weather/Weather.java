package id.weather;

import java.util.List;
import java.util.concurrent.Future;

public class Weather {
    List<IObserver> observers;

    public void attach(IObserver observer) {
        this.observers.add(observer);
    }

    public void detach(IObserver observer) {
        this.observers.remove(observer);
    }

    public void updateWeather() {
        Future<WeatherData> weatherData = WeatherApi.updateWeatherData();
        // todo
        for (IObserver o: observers) {
            o.update();
        }
    }
}
