package id.weather;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // todo: to pass into WeatherApi what to update

        ViewGroup dailyLayout = findViewById(R.id.dailyLayout);
        ViewGroup weeklyLayout = findViewById(R.id.weeklyLayout);

        DropdownPair dropdowns = new DropdownPair(dailyLayout, weeklyLayout);

        // set listeners on buttons to run the animation when pressed
        Button dailyButton = findViewById(R.id.dailyButton);
        dailyButton.setOnClickListener(v -> dropdowns.toggle(300));

        Button weeklyButton = findViewById(R.id.weeklyButton);
        weeklyButton.setOnClickListener(v -> dropdowns.toggle(300));
  
        Handler mainHandler = new Handler(Looper.getMainLooper());

        Weather weather = Weather.getInstance();
        MainInterface mainInterface = new MainInterface(findViewById(R.id.mainIcon), mainHandler);
        weather.attach(mainInterface);
        weather.updateWeather();
    }
}