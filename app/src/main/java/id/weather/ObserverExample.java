package id.weather;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
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
    View view = this.activity.findViewById(R.id.MainConstraintLayout);
    TextView txt = this.activity.findViewById(R.id.exampleText);
    ImageView weather_icon = this.activity.findViewById(R.id.weather_icon);
    this.handler.post(() -> {
        if (weatherData.getIsSuccess()) {
            System.out.println(weatherData);
            int currentWeather = weatherData.getDaily().getWeathercode(0);
            txt.setText(Weathercode.toText(currentWeather));
            weather_icon.setImageResource(Weathercode.toIcon(currentWeather, true));
            view.setBackgroundResource(Weathercode.toBackground(currentWeather, true));
            // if hourly: weatherData.getHourly().getIs_day(...)
        } else {
            txt.setText("Failed to retrieve data");
            weather_icon.setImageResource(R.drawable.transparent);
            view.setBackgroundResource(R.drawable.clear_background);
        }
    });
}
}