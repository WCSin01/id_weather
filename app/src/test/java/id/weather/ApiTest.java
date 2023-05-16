package id.weather;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(RobolectricTestRunner.class)
public class ApiTest {
    @Test
    public void Output() throws InterruptedException, ExecutionException {
        Future<WeatherData> weatherData = WeatherApi.updateWeatherData();
        while (!weatherData.isDone()) {
            Thread.sleep(100);
        }
        System.out.println(weatherData.get());
    }
}

