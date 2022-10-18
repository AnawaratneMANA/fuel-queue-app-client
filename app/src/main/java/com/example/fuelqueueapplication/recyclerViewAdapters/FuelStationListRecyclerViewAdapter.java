package com.example.fuelqueueapplication.recyclerViewAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuelqueueapplication.FuelStationDetailActivity;
import com.example.fuelqueueapplication.R;
import com.example.fuelqueueapplication.api.response.FuelStationResponse;

import java.util.ArrayList;
import java.util.List;

public class FuelStationListRecyclerViewAdapter extends RecyclerView.Adapter<FuelStationListRecyclerViewAdapter.MyViewHolder> implements Filterable {
    Context context;
    List<FuelStationResponse> stationResponseList;
    List<FuelStationResponse> stationResponseListFull;

    public FuelStationListRecyclerViewAdapter(Context context, List<FuelStationResponse> stationResponseList) {
        this.context = context;
        this.stationResponseList = stationResponseList;
        stationResponseListFull = new ArrayList<>(stationResponseList);
    }

    @NonNull
    @Override
    public FuelStationListRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shed_list_raw_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuelStationListRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.location.setText(stationResponseList.get(position).getLocation());
        holder.endTime.setText(stationResponseList.get(position).getEndingTime());
        holder.StartingTime.setText(stationResponseList.get(position).getStartingTime());
    }

    @Override
    public int getItemCount() {
        return stationResponseList.size();
    }

    @Override
    public Filter getFilter() {
        return FuelStationFilter;
    }

    private Filter FuelStationFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FuelStationResponse> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(stationResponseListFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (FuelStationResponse fuelStationResponse : stationResponseListFull) {
                    if (fuelStationResponse.getLocation().toLowerCase().contains(filterPattern)) {
                        filteredList.add(fuelStationResponse);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            stationResponseList.clear();
            stationResponseList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView location, endTime, StartingTime;
        LinearLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            location = itemView.findViewById(R.id.fuelStationLocation);
            endTime = itemView.findViewById(R.id.fuelStationEndTime);
            StartingTime = itemView.findViewById(R.id.fuelStationStartingTime);
            layout = itemView.findViewById(R.id.fuelStationRawViewOuterLayout);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String locationName = stationResponseList.get(getAdapterPosition()).getLocation();
                    String id = stationResponseList.get(getAdapterPosition()).getId();
                    Intent intent = new Intent(context, FuelStationDetailActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("locationName", locationName);
                    context.startActivity(intent);
                }
            });


        }
    }
}
