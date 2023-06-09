package id.weather;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
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

        // set up dropdown pair for daily/weekly weather
        ViewGroup dailyLayout = findViewById(R.id.dailyLayout);
        ViewGroup weeklyLayout = findViewById(R.id.weeklyLayout);

        dailyLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        dailyLayout.setClipToOutline(true);

        DropdownPair weatherDropdowns = new DropdownPair(dailyLayout, weeklyLayout);

        // set listeners on buttons to run the animation when pressed
        Button dailyButton = findViewById(R.id.dailyButton);
        dailyButton.setOnClickListener(v -> weatherDropdowns.toggle(300));

        Button weeklyButton = findViewById(R.id.weeklyButton);
        weeklyButton.setOnClickListener(v -> weatherDropdowns.toggle(300));

        // set up dropdown pair for settings menu
        ViewGroup mainLayout = findViewById(R.id.mainLayout);
        ViewGroup settingsLayout = findViewById(R.id.settingsLayout);

        DropdownPair settingsDropdown = new DropdownPair(mainLayout, settingsLayout);
        System.out.println(mainLayout.getLayoutParams().height);

        // set listeners on buttons to run the animation when pressed
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(v -> settingsDropdown.toggle(400));

        Button mainButton = findViewById(R.id.mainButton);
        mainButton.setOnClickListener(v -> settingsDropdown.toggle(400));
  
        Handler mainHandler = new Handler(Looper.getMainLooper());

        Weather weather = Weather.getInstance();
        MainInterface mainInterface = new MainInterface(
                findViewById(R.id.background),
                findViewById(R.id.mainIcon),
                findViewById(R.id.currentTemp),
                findViewById(R.id.highTemp),
                findViewById(R.id.lowTemp),
                findViewById(R.id.rainChance),
                findViewById(R.id.rainTime),
                findViewById(R.id.warningText),
                mainHandler);
        weather.attach(mainInterface);

      
        // Find the RecyclerView and set it's adaptor to the RecyclerViewAdaptor

        // Finding RecyclerViews
        RecyclerView todayRecyclerView = (RecyclerView) findViewById(R.id.todayRecycler);
        RecyclerView thisWeekRecyclerView = (RecyclerView) findViewById(R.id.thisWeekRecycler);

        // Creating the adaptor instances
        RecyclerViewAdaptor todayAdaptor = new RecyclerViewAdaptor(weather, mainHandler);
        RecyclerViewAdaptorDaily thisWeekAdaptor = new RecyclerViewAdaptorDaily(weather, mainHandler);

        // Setting RecyclerView adaptors
        todayRecyclerView.setAdapter(todayAdaptor);
        thisWeekRecyclerView.setAdapter(thisWeekAdaptor);

        // don't load app until data is ready
        View content = findViewById(R.id.content);
        content.getViewTreeObserver().addOnPreDrawListener(mainInterface);

        weather.updateWeather();
    }
}