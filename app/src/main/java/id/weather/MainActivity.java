package id.weather;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // todo: to pass into WeatherApi what to update

        // TODO: refactor into somewhere more sensible than the main function
        ViewGroup dailyLayout = findViewById(R.id.dailyLayout);
        ViewGroup weeklyLayout = findViewById(R.id.weeklyLayout);

        // default values for layout heights - get from design to avoid hardcoding
        int openHeight = dailyLayout.getLayoutParams().height;
        int closedHeight = weeklyLayout.getLayoutParams().height;

        // create animators to open/close dropdowns - each one handles both dropdowns
        // to avoid code repetition
        ValueAnimator.AnimatorUpdateListener listener = valueAnim -> {
            int val = (int)valueAnim.getAnimatedValue();

            ViewGroup.LayoutParams dailyParams = dailyLayout.getLayoutParams();
            dailyParams.height = val;
            dailyLayout.setLayoutParams(dailyParams);

            ViewGroup.LayoutParams weeklyParams = weeklyLayout.getLayoutParams();
            weeklyParams.height = openHeight + closedHeight - val;
            weeklyLayout.setLayoutParams(weeklyParams);
        };

        ValueAnimator openDailyAnim = ValueAnimator.ofInt(closedHeight, openHeight);
        openDailyAnim.addUpdateListener(listener);
        ValueAnimator openWeeklyAnim = ValueAnimator.ofInt(openHeight, closedHeight);
        openWeeklyAnim.addUpdateListener(listener);

        // set listeners on buttons to run the animation when pressed
        Button dailyButton = findViewById(R.id.dailyButton);
        dailyButton.setOnClickListener(v -> openDailyAnim.setDuration(300).start());

        Button weeklyButton = findViewById(R.id.weeklyButton);
        weeklyButton.setOnClickListener(v -> openWeeklyAnim.setDuration(300).start());
    }
}