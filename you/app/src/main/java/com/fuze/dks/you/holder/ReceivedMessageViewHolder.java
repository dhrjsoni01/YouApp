package com.fuze.dks.you.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fuze.dks.you.R;
import com.fuze.dks.you.models.MessageViewModel;

public class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
    TextView message,createdAt,userName;
    public ReceivedMessageViewHolder(View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.text_message);
        userName = itemView.findViewById(R.id.text_sender_name);
        createdAt = itemView.findViewById(R.id.text_message_time);
    }
    public void bindMessage(MessageViewModel viewModel){
        userName.setText(viewModel.getUserName());
        message.setText(viewModel.getMessage());
        createdAt.setText(viewModel.getCreateAt());
    }
}
