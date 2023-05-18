package id.weather;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewViewHolder extends RecyclerView.ViewHolder implements IObserver {

    private int index;

    private final TextView textView;

    public RecyclerViewViewHolder(@NonNull View itemView, int index) {

        super(itemView);

        this.index = index;

        textView = (TextView) itemView.findViewById(R.id.item_text_view);

    }

    public void setIndex(int index) {

        this.index = index;

        textView.setText("Item " + index); // TODO - this line is temporary, just for testing. Delete once we're done testing it
        Log.d("debugstuff", "Item " + index + " created");
    }

    @Override
    public void update(WeatherData weatherData) {
        // TODO
    }

    // TODO

}
