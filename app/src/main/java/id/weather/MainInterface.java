package id.weather;

import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInterface implements IObserver {
    private final ImageView img;
    private final TextView currentTempTxt;
    private final TextView currentWeatherTxt;
    private final TextView highTempTxt;
    private final TextView lowTempTxt;
    private final TextView rainChanceTxt;
    private final Handler handler;

    public MainInterface(ImageView img, TextView currentWeatherTxt, TextView currentTempTxt, TextView highTempTxt, TextView lowTempTxt, TextView rainChanceTxt, Handler handler) {
        this.img = img;
        this.currentTempTxt = currentTempTxt;
        this.currentWeatherTxt = currentWeatherTxt;
        this.highTempTxt = highTempTxt;
        this.lowTempTxt = lowTempTxt;
        this.rainChanceTxt = rainChanceTxt;

        this.handler = handler;
    }

    private int nextPrecipTime(WeatherData weatherData) {
        int t = 24; // placeholder out of range
        for (int i = 23; i > (weatherData.getCurrentHour() - 1); i--) {
            if (weatherData.getHourly().getPrecipitation_probability(i) >= 0.25f) {
                t = i;
            }
        }
        Log.d("DEBUG", Integer.toString(t));
        return t; // Note: a returned value of 24 means no rain in next 24hrs
    }

    @Override
    public void update(WeatherData weatherData) {
        this.handler.post(() -> {
            if (weatherData.getIsSuccess()) {
                int currentTime = weatherData.getCurrentHour();

                // int maxPrecip =  weatherData.getHourly().getPrecipitation_probability(0)
                int nextPrecip = nextPrecipTime(weatherData);

                int currentWeather = weatherData.getHourly().getWeathercode(currentTime);
                img.setImageResource(Weathercode.toIcon(currentWeather, 1));
                currentWeatherTxt.setText(Weathercode.toText(currentWeather));
                currentTempTxt.setText(String.format("%s°C", weatherData.getHourly().getTemperature_2m(currentTime)));
                highTempTxt.setText(String.format("H: %s°C", weatherData.getDaily().getTemperature_2m_max(0)));
                lowTempTxt.setText(String.format("L: %s°C", weatherData.getDaily().getTemperature_2m_min(0)));
                rainChanceTxt.setText(String.format("%s%% chance of rain at %s:00", Math.round(weatherData.getHourly().getPrecipitation_probability(nextPrecip)), nextPrecip));
                // if hourly: weatherData.getHourly().getIs_day(...)
            }
        });
    }
}
