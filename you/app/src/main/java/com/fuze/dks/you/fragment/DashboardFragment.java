package com.fuze.dks.you.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fuze.dks.you.R;
import com.fuze.dks.you.adaptor.DashboardAdaptor;
import com.fuze.dks.you.holder.DashBoardViewHolder;
import com.fuze.dks.you.models.DashBoardViewModel;
import com.fuze.dks.you.util.DashBoardTouchListener;

import java.util.ArrayList;
import java.util.Collections;


public class DashboardFragment extends Fragment {
    DashboardAdaptor  adaptor;
    ArrayList<DashBoardViewModel> list;
    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dashboard, container, false);
        RecyclerView dashboardRecycler = view.findViewById(R.id.recycler_dashboard);
        dashboardRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dashboardRecycler.setLayoutManager(layoutManager);
        list = getSeedData();
        adaptor = new DashboardAdaptor(list);
        dashboardRecycler.setAdapter(adaptor);
        dashboardRecycler.addOnItemTouchListener(new DashBoardTouchListener(getActivity(), dashboardRecycler, new ClickListener() {
            @Override
            public void onSingleClick(View view, int position) {
                moveToTop(position);
                Toast.makeText(getActivity(),"Single click on "+ String.valueOf(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getActivity(),"Long click on "+ String.valueOf(position),Toast.LENGTH_SHORT).show();

            }
        }));
        return  view;
    }

    private void moveToTop(int i){
        DashBoardViewModel Item = list.get(i);
        list.remove(i);  // remove item from the list
        list.add(0,Item); // add at 0 index of your list
        adaptor.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private ArrayList<DashBoardViewModel> getSeedData(){
        ArrayList<DashBoardViewModel> seed = new ArrayList<>();
        for (int i=0; i<10;i++){
            DashBoardViewModel data = new DashBoardViewModel();
            data.setUserName("Dheeraj kumar Soni " +String.valueOf(i));
            data.setLastMsg("dklvnsfbhsbkdlajodihafbjk nsvab");
            data.setLastDate("15 july");
            data.setUnreadCount(9);
            data.setOnline(false);
            seed.add(data);
        }
        seed.get(5).setUnreadCount(0);
        seed.get(7).setOnline(true);
        return seed;
    }


    public static interface ClickListener{
        public void onSingleClick(View view,int position);
        public void onLongClick(View view,int position);
    }



}
