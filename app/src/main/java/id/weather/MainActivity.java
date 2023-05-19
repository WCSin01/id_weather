package id.weather;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
        MainInterface mainInterface = new MainInterface(findViewById(R.id.mainIcon), findViewById(R.id.currentWeather), findViewById(R.id.currentTemp), findViewById(R.id.highTemp), findViewById(R.id.lowTemp), findViewById(R.id.rainChance), mainHandler);
        weather.attach(mainInterface);
        weather.updateWeather();
      
        // Find the RecyclerView and set it's adaptor to the RecyclerViewAdaptor

        // Finding RecyclerViews
        RecyclerView todayRecyclerView = (RecyclerView) findViewById(R.id.todayRecycler);

        // Creating the adaptor instances
        RecyclerViewAdaptor todayAdaptor = new RecyclerViewAdaptor(weather);

        // Setting RecyclerView adaptors
        todayRecyclerView.setAdapter(todayAdaptor);
      
    }
}