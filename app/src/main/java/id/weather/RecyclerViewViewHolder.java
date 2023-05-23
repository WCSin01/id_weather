package id.weather;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;

public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements IObserver {

    protected Handler handler;

    protected int index;

    protected final TextView timeLabel;
    protected final TextView temperatureLabel;
    protected final ImageView bikeImage, weatherImage;

    public RecyclerViewViewHolder(@NonNull View itemView, int index, Handler handler) {

        super(itemView);

        this.handler = handler;
        this.index = index;

        timeLabel = itemView.findViewById(R.id.time_label);
        temperatureLabel = itemView.findViewById(R.id.temperature_label);
        bikeImage = itemView.findViewById(R.id.bikeImage);
        weatherImage = itemView.findViewById(R.id.weather_image);

    }

    protected void setDetails(int hour, float temperature, int weathercode, boolean isDay) {

        timeLabel.setText(String.format("%02d : 00", hour % 24)); // Set time label time
        temperatureLabel.setText(String.format("%.1f °C", temperature));
        bikeImage.setImageResource(weathercode >= 51 && weathercode <= 67 ? R.drawable.umbrella : R.drawable.bike );
        weatherImage.setImageResource(Weathercode.toIcon(weathercode, isDay));


    }

    public void setIndex(int index) {

        this.index = index;

        // need to manually update with most recent data since this holder might have been
        // created after the last automatic update
        WeatherData cachedWeatherData = WeatherApi.getCachedWeatherData();
        if (cachedWeatherData != null) {
            update(cachedWeatherData);
        }
    }

    @Override
    public void update(WeatherData weatherData) {

        if (weatherData.getIsSuccess()) {
            int baseHour = LocalDateTime.now().getHour();
            int hour = baseHour + index;

            int weathercode = weatherData.getHourly().getWeathercode(hour);
            float temperature = weatherData.getHourly().getTemperature_2m(hour);
            boolean isDay = weatherData.getHourly().getIs_day(hour);

            handler.post(() -> setDetails(hour, temperature, weathercode, isDay));

        }

    }

}
