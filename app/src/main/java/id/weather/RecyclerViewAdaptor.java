package id.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewViewHolder> {

    private static final int itemCount = 6;

    private final Weather weather;

    public RecyclerViewAdaptor(Weather weather) {

        this.weather = weather;

    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_row_item, parent, false);

        RecyclerViewViewHolder holder = new RecyclerViewViewHolder(v, 0);

        weather.attach(holder);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {

        holder.setIndex(position);

    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

}
