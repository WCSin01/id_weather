package id.weather;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

public class MainInterface implements IObserver, ViewTreeObserver.OnPreDrawListener {
    private final ImageView img;
    private final TextView currentTempText, highTempText, lowTempText, rainChanceText, rainTimeText;
    private final Handler handler;
    private final View background;
    private boolean hasLoaded;

    public MainInterface(
            View background,
            ImageView img,
            TextView currentTempText,
            TextView highTempText,
            TextView lowTempText,
            TextView rainChanceText,
            TextView rainTimeText,
            Handler handler
    ) {
        this.background = background;
        this.img = img;
        this.currentTempText = currentTempText;
        this.highTempText = highTempText;
        this.lowTempText = lowTempText;
        this.rainChanceText = rainChanceText;
        this.rainTimeText = rainTimeText;

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
                boolean isDay = weatherData.getHourly().getIs_day(currentTime);
                img.setImageResource(Weathercode.toIcon(currentWeather, isDay));
                currentTempText.setText(String.format("%s°C", weatherData.getHourly().getTemperature_2m(currentTime)));
                highTempText.setText(String.format("H: %s°C", weatherData.getDaily().getTemperature_2m_max(0)));
                lowTempText.setText(String.format("L: %s°C", weatherData.getDaily().getTemperature_2m_min(0)));

                if (nextPrecip < currentTime + 24) {
                    rainChanceText.setText(String.format("%s%% chance of rain at",
                            Math.round(weatherData.getHourly().getPrecipitation_probability(nextPrecip))));
                    rainTimeText.setText(String.format("%02d:00", nextPrecip % 24));
                } else {
                    rainChanceText.setText("No rain expected soon!");
                    rainTimeText.setText("");
                }
                // if hourly: weatherData.getHourly().getIs_day(...)
                hasLoaded = true;
                background.setBackgroundResource(Weathercode.toBackground(currentWeather, isDay));
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
