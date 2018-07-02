package com.fuze.dks.you.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fuze.dks.you.R;
import com.fuze.dks.you.models.MessageViewModel;

public class SentMessageViewHolder extends RecyclerView.ViewHolder {
    TextView message,createdAt;
    public SentMessageViewHolder(View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.text_message);
        createdAt = itemView.findViewById(R.id.text_message_time);
    }
    public void bindMessage(MessageViewModel viewModel){
        message.setText(viewModel.getMessage());
        createdAt.setText(viewModel.getCreateAt());
    }
}