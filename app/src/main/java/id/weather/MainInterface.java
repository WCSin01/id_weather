package id.weather;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInterface implements IObserver, ViewTreeObserver.OnPreDrawListener {
    private final ImageView img;
    private final TextView currentTempTxt;
    private final TextView currentWeatherTxt;
    private final TextView highTempTxt;
    private final TextView lowTempTxt;
    private final TextView rainChanceTxt;
    private final Handler handler;
    private final View background;
    private boolean hasLoaded;

    public MainInterface(View background, ImageView img, TextView currentWeatherTxt, TextView currentTempTxt, TextView highTempTxt, TextView lowTempTxt, TextView rainChanceTxt, Handler handler) {
        this.background = background;
        this.img = img;
        this.currentTempTxt = currentTempTxt;
        this.currentWeatherTxt = currentWeatherTxt;
        this.highTempTxt = highTempTxt;
        this.lowTempTxt = lowTempTxt;
        this.rainChanceTxt = rainChanceTxt;

        this.handler = handler;

        hasLoaded = false;
    }

    private int nextPrecipTime(WeatherData weatherData) {
        int currentTime = weatherData.getCurrentHour();
        int t = weatherData.getCurrentHour() + 24; // placeholder out of range
        for (int i = currentTime + 23; i > (currentTime - 1); i--) {
            if (weatherData.getHourly().getPrecipitation_probability(i) >= 25f) {
                t = i;
            }
        }
        return t; // Note: a returned value of 24 would mean no rain today
    }

    @Override
    public void update(WeatherData weatherData) {
        this.handler.post(() -> {
            if (weatherData.getIsSuccess()) {
                int currentTime = weatherData.getCurrentHour();

                // int maxPrecip =  weatherData.getHourly().getPrecipitation_probability(0)
                int nextPrecip = nextPrecipTime(weatherData);

                int currentWeather = weatherData.getHourly().getWeathercode(currentTime);
                img.setImageResource(Weathercode.toIcon(currentWeather, true));
                currentWeatherTxt.setText(Weathercode.toText(currentWeather));
                currentTempTxt.setText(String.format("%s°C", weatherData.getHourly().getTemperature_2m(currentTime)));
                highTempTxt.setText(String.format("H: %s°C", weatherData.getDaily().getTemperature_2m_max(0)));
                lowTempTxt.setText(String.format("L: %s°C", weatherData.getDaily().getTemperature_2m_min(0)));

                if (nextPrecip < currentTime + 24) {
                    int nextTime = nextPrecip;
                    if (nextTime >= 24) {
                        nextTime -= 24;
                    }
                    rainChanceTxt.setText(String.format("%s%% chance of rain at %s:00", Math.round(weatherData.getHourly().getPrecipitation_probability(nextPrecip)), nextTime));
                } else {
                    rainChanceTxt.setText("No rain expected soon!");
                }
                // if hourly: weatherData.getHourly().getIs_day(...)
                hasLoaded = true;
                background.setBackgroundResource(Weathercode.toBackground(currentWeather, true));
            }
            else {
                background.setBackgroundResource(R.drawable.clear_background);
            }
        });
    }

    @Override
    public boolean onPreDraw() {
        return hasLoaded;
    }
}
