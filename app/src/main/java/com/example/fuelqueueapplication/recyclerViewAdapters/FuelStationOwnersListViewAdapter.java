package com.example.fuelqueueapplication.recyclerViewAdapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuelqueueapplication.FuelStationDetailActivity;
import com.example.fuelqueueapplication.FuelStationInsertForm;
import com.example.fuelqueueapplication.R;
import com.example.fuelqueueapplication.api.response.FuelStationResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FuelStationOwnersListViewAdapter extends RecyclerView.Adapter<FuelStationOwnersListViewAdapter.MyViewHolder> implements Filterable {
    Context context;
    List<FuelStationResponse> stationResponseList;
    List<FuelStationResponse> stationResponseListArrayList;

    public FuelStationOwnersListViewAdapter(Context context, List<FuelStationResponse> fuelStationResponses){
        this.context = context;
        this.stationResponseList = fuelStationResponses;
        stationResponseListArrayList = new ArrayList<>(fuelStationResponses);
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
                filteredList.addAll(stationResponseListArrayList);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (FuelStationResponse fuelStationResponse : stationResponseListArrayList) {
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

    @NonNull
    @Override
    public FuelStationOwnersListViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shed_list_raw_view_v2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuelStationOwnersListViewAdapter.MyViewHolder holder, int position) {
        holder.Location.setText(stationResponseList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return stationResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Define View Items
        TextView Location;
        LinearLayout Layout;
        ImageView UpdateButton;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            // Register View Items
            Location = itemView.findViewById(R.id.FuelStationOwnerLocationName);
            Layout = itemView.findViewById(R.id.FuelStationOwnerLayout);
            UpdateButton = itemView.findViewById(R.id.SelectUpdateStationButton);
            UpdateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String locationName = stationResponseList.get(getAdapterPosition()).getLocation();
                    String id = stationResponseList.get(getAdapterPosition()).getId();
                    Intent intent = new Intent(context, FuelStationInsertForm.class);
                    intent.putExtra("id", id);
                    intent.putExtra("locationName", locationName);
                    context.startActivity(intent);
                }
            });

        }
    }

}
