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
        ObserverExample observerExample = new ObserverExample(mainHandler, this);
        weather.attach(observerExample);
      
        // Find the RecyclerView and set it's adaptor to the RecyclerViewAdaptor

        // Finding RecyclerViews
        RecyclerView todayRecyclerView = (RecyclerView) findViewById(R.id.todayRecycler);
        RecyclerView thisWeekRecyclerView = (RecyclerView) findViewById(R.id.thisWeekRecycler);

        // Creating the adaptor instances
        RecyclerViewAdaptor todayAdaptor = new RecyclerViewAdaptor(weather, new Handler(Looper.getMainLooper()));
        RecyclerViewAdaptorDaily thisWeekAdaptor = new RecyclerViewAdaptorDaily(weather, new Handler(Looper.getMainLooper()));

        // Setting RecyclerView adaptors
        todayRecyclerView.setAdapter(todayAdaptor);
        thisWeekRecyclerView.setAdapter(thisWeekAdaptor);

        weather.updateWeather();
      
    }
}