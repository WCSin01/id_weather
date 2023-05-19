package id.weather;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInterface implements IObserver {
    private final ImageView img;
    private final TextView currentTempTxt;
    private final TextView currentWeatherTxt;
    private final TextView highTempTxt;
    private final TextView lowTempTxt;
    private final Handler handler;

    public MainInterface(ImageView img, TextView currentWeatherTxt, TextView currentTempTxt, TextView highTempTxt, TextView lowTempTxt, Handler handler) {
        this.img = img;
        this.currentTempTxt = currentTempTxt;
        this.currentWeatherTxt = currentWeatherTxt;
        this.highTempTxt = highTempTxt;
        this.lowTempTxt = lowTempTxt;

        this.handler = handler;
    }

    @Override
    public void update(WeatherData weatherData) {
        this.handler.post(() -> {
            if (weatherData.getIsSuccess()) {
                int currentTime = weatherData.getCurrentHour();

                int currentWeather = weatherData.getHourly().getWeathercode(currentTime);
                img.setImageResource(Weathercode.toIcon(currentWeather, 1));
                currentWeatherTxt.setText(Weathercode.toText(currentWeather));
                currentTempTxt.setText(String.format("%s°C", weatherData.getHourly().getTemperature_2m(currentTime)));
                highTempTxt.setText(String.format("H: %s°C", weatherData.getDaily().getTemperature_2m_max(0)));
                lowTempTxt.setText(String.format("L: %s°C", weatherData.getDaily().getTemperature_2m_min(0)));
                // if hourly: weatherData.getHourly().getIs_day(...)
            }
        });
    }
}
