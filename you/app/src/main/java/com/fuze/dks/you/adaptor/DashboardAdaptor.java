package com.fuze.dks.you.adaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuze.dks.you.R;
import com.fuze.dks.you.holder.DashBoardViewHolder;
import com.fuze.dks.you.models.DashBoardViewModel;

import java.util.ArrayList;

public class DashboardAdaptor extends RecyclerView.Adapter<DashBoardViewHolder> {

    ArrayList<DashBoardViewModel> models;

    @NonNull
    @Override
    public DashBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new DashBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashBoardViewHolder holder, int position) {
        ((DashBoardViewHolder) holder).bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    @Override
    public int getItemViewType(final int position) {
        return R.layout.dashboard_item;
    }

    public DashboardAdaptor(ArrayList<DashBoardViewModel> models) {
        this.models = models;
    }
}
