package id.weather;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecyclerViewViewHolderDaily extends RecyclerViewViewHolder {

    public RecyclerViewViewHolderDaily(@NonNull View itemView, int index, Handler handler) {
        super(itemView, index, handler);
    }

    protected void setDailyDetails(LocalDateTime dt, float temperature_min, float temperature_max, int weathercode) {

        timeLabel.setText(dt.format(DateTimeFormatter.ofPattern("dd/MM"))); // Set time label time
        temperatureLabel.setText(String.format("%.1f/%.1f °C", temperature_min, temperature_max));
        weatherImage.setImageResource(Weathercode.toIcon(weathercode, true));

    }

    @Override
    public void update(WeatherData weatherData) {

        if (weatherData.getIsSuccess()) {

            int weathercode = weatherData.getDaily().getWeathercode(index);
            float temperature_min = weatherData.getDaily().getTemperature_2m_min(index);
            float temperature_max = weatherData.getDaily().getTemperature_2m_max(index);

            handler.post(() -> setDailyDetails(LocalDateTime.now().plusDays(index), temperature_min, temperature_max, weathercode));

        }

    }

}
