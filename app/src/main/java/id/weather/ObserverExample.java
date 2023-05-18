package id.weather;

import android.app.Activity;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class ObserverExample implements IObserver {
private Handler handler;
private Activity activity;

public ObserverExample(Handler handler, Activity activity) {
    this.handler = handler;
    this.activity = activity;
}

@Override
public void update(WeatherData weatherData) {
    TextView txt = this.activity.findViewById(R.id.exampleText);
    ImageView weather_icon = this.activity.findViewById(R.id.weather_icon);
    this.handler.post(() -> {
        if (weatherData.getIsSuccess()) {
            int currentWeather = weatherData.getDaily().getWeathercode(0);
            txt.setText(Weathercode.toText(currentWeather));
            weather_icon.setImageResource(Weathercode.toIcon(currentWeather, 1));
            // if hourly: weatherData.getHourly().getIs_day(...)
        } else {
            txt.setText("Failed to retrieve data");
        }
    });

}
}
