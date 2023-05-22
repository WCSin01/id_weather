package id.weather;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdaptorDaily extends RecyclerView.Adapter<RecyclerViewViewHolderDaily> {

    private Handler handler;

    private static final int itemCount = 7;

    private final Weather weather;

    public RecyclerViewAdaptorDaily(Weather weather, Handler handler) {

        this.handler = handler;
        this.weather = weather;

    }

    @NonNull
    @Override
    public RecyclerViewViewHolderDaily onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_row_item, parent, false);

        RecyclerViewViewHolderDaily holder = new RecyclerViewViewHolderDaily(v, 0, handler);

        weather.attach(holder);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolderDaily holder, int position) {

        holder.setIndex(position);

    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

}
