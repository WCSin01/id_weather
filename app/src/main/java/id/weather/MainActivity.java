package id.weather;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Weather weather;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    weather = new Weather(); // TODO - only for me to make the later code, do this properly later please

    // todo: to pass into WeatherApi what to update

    // Find the RecyclerView and set it's adaptor to the RecyclerViewAdaptor

    // Finding RecyclerViews
    RecyclerView todayRecyclerView = (RecyclerView) findViewById(R.id.todayRecycler);

    // Creating the adaptor instances
    RecyclerViewAdaptor todayAdaptor = new RecyclerViewAdaptor(weather);

    // Setting RecyclerView adaptors
    todayRecyclerView.setAdapter(todayAdaptor);

}
}