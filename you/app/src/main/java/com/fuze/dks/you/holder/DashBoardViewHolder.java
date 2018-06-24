package com.fuze.dks.you.holder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuze.dks.you.R;
import com.fuze.dks.you.models.DashBoardViewModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashBoardViewHolder extends ViewHolder {

    private TextView userName,lastMsg,lastDate,unreadCount;
    private ImageView extra;
    private CircleImageView pic,onlineDot;

    public DashBoardViewHolder(View itemView) {
        super(itemView);
        userName = itemView.findViewById(R.id.tv_name);
        lastDate = itemView.findViewById(R.id.tv_date);
        lastMsg = itemView.findViewById(R.id.tv_last_msg);
        unreadCount = itemView.findViewById(R.id.tv_unread_Count);
        pic = itemView.findViewById(R.id.pic);
        extra = itemView.findViewById(R.id.iv_extra);
        onlineDot = itemView.findViewById(R.id.online_dot);
    }

    public void bindData(final DashBoardViewModel viewModel) {
        userName.setText(viewModel.getUserName());
        lastMsg.setText(viewModel.getLastMsg());
        lastDate.setText(viewModel.getLastDate());
        if (viewModel.getUnreadCount()==0){
            unreadCount.setVisibility(View.GONE);
        }else {
            unreadCount.setText(String.valueOf(viewModel.getUnreadCount()));
        }
        onlineDot.setVisibility(View.GONE);
        if (viewModel.isOnline()){
            onlineDot.setVisibility(View.VISIBLE);
        }
    }
}
