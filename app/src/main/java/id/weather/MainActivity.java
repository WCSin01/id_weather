package id.weather;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Handler mainHandler = new Handler(Looper.getMainLooper());

    Weather weather = Weather.getInstance();
    ObserverExample observerExample = new ObserverExample(mainHandler, this);
    weather.attach(observerExample);
    weather.updateWeather();
}
}