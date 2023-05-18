package id.weather;

import android.os.Handler;
import android.widget.ImageView;

public class MainInterface implements IObserver {
    private final ImageView img;
    private final Handler handler;

    public MainInterface(ImageView img, Handler handler) {
        this.img = img;
        this.handler = handler;
    }

    @Override
    public void update(WeatherData weatherData) {
        this.handler.post(() -> {
            if (weatherData.getIsSuccess()) {
                int currentWeather = weatherData.getDaily().getWeathercode(0);
                img.setImageResource(Weathercode.toIcon(currentWeather, 1));
                // if hourly: weatherData.getHourly().getIs_day(...)
            }
        });
    }
}
