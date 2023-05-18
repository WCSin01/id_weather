package id.weather;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInterface implements IObserver {
    private final ImageView img;
    private final TextView currentTempTxt;
    private final TextView currentWeatherTxt;
    private final Handler handler;

    public MainInterface(ImageView img, TextView currentTempTxt, TextView currentWeatherTxt, Handler handler) {
        this.img = img;
        this.currentTempTxt = currentTempTxt;
        this.currentWeatherTxt = currentWeatherTxt;

        this.handler = handler;
    }

    @Override
    public void update(WeatherData weatherData) {
        this.handler.post(() -> {
            if (weatherData.getIsSuccess()) {
                int currentTime = weatherData.getCurrentHour();

                int currentWeather = weatherData.getHourly().getWeathercode(0);
                img.setImageResource(Weathercode.toIcon(currentWeather, 1));
                currentWeatherTxt.setText(Weathercode.toText(currentWeather));
                // if hourly: weatherData.getHourly().getIs_day(...)
            }
        });
    }
}
