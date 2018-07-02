package com.fuze.dks.you.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fuze.dks.you.R;
import com.fuze.dks.you.adaptor.MessageAdaptor;
import com.fuze.dks.you.models.MessageViewModel;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        RecyclerView recyclerView = findViewById(R.id.recycler_chat);
        MessageAdaptor messageAdaptor = new MessageAdaptor(this,getSeed());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(messageAdaptor);
    }
    private ArrayList<MessageViewModel> getSeed(){
        ArrayList<MessageViewModel> seed = new ArrayList<>();
        for (int i=0; i<10;i++){
            MessageViewModel data = new MessageViewModel();
            data.setUserName("Dheeraj kumar Soni " +String.valueOf(i));
            if (i%2==0){
                data.setSent(true);
            }else {
                data.setSent(false);
            }
            if (i%3==0){
                data.setMessage("Hii this is;sfkBNLGM VKNGB,DFN VKAJBGALKMF mvf n, kmlcmdessage");
            }else if (i%3 == 2){
            data.setMessage("Hii this is message");
            }else{
                data.setMessage("Hii this is messagcadkvnlle from me");
            }
            data.setCreateAt("11:50 PM");
            seed.add(data);
        }
        return seed;
    }
}
