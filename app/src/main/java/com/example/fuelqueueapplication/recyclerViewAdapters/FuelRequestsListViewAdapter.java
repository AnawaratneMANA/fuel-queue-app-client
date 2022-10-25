package com.example.fuelqueueapplication.recyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuelqueueapplication.R;
import com.example.fuelqueueapplication.api.response.FuelRequestResponse;

import java.util.ArrayList;
import java.util.List;

public class FuelRequestsListViewAdapter extends RecyclerView.Adapter<FuelRequestsListViewAdapter.MyViewHolder> implements Filterable {
    Context context;
    List<FuelRequestResponse> requestResponseList;
    List<FuelRequestResponse> requestResponseArrayList;

    public FuelRequestsListViewAdapter(Context context, List<FuelRequestResponse> queueResponseList){
        this.context = context;
        this.requestResponseList = queueResponseList;
        this.requestResponseArrayList = new ArrayList<>(queueResponseList);
    }

    @Override
    public Filter getFilter() {
        return FuelStationQueueFilter;
    }

    private Filter FuelStationQueueFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FuelRequestResponse> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(requestResponseList);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (FuelRequestResponse queueResponse : requestResponseArrayList) {
                    if (queueResponse.getApprovalStatus().toLowerCase().contains(filterPattern)) {
                        filteredList.add(queueResponse);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            requestResponseList.clear();
            requestResponseList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    @NonNull
    @Override
    public FuelRequestsListViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_list_raw_view, parent, false);
        return new FuelRequestsListViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FuelRequestsListViewAdapter.MyViewHolder holder, int position) {
        holder.textViewRequestedUserName.setText(requestResponseList.get(position).getUserId());
        holder.textViewDescription.setText("Description N/A");
    }

    @Override
    public int getItemCount() {
        return requestResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRequestedUserName;
        TextView textViewDescription;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textViewRequestedUserName = itemView.findViewById(R.id.requestedUser);
            textViewDescription = itemView.findViewById(R.id.requestDescription);
        }
    }
}
