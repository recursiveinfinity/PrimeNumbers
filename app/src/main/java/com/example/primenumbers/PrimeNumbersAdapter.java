package com.example.primenumbers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersAdapter extends RecyclerView.Adapter<PrimeNumbersAdapter.PrimeNumberViewHolder> {

    private List<String> results = new ArrayList<>();


    public void setData(List<Integer> data) {
        results.clear();
        for (Integer result : data) {
            results.add(result.toString());
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PrimeNumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_result, viewGroup, false);
        return new PrimeNumberViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrimeNumberViewHolder primeNumberViewHolder, int position) {
        primeNumberViewHolder.tvResult.setText(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class PrimeNumberViewHolder extends RecyclerView.ViewHolder {

        TextView tvResult;

        public PrimeNumberViewHolder(@NonNull View itemView) {
            super(itemView);
            tvResult = itemView.findViewById(R.id.tvResult);
        }
    }
}
