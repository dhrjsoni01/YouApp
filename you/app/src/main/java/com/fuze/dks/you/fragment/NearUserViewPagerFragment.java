package com.fuze.dks.you.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuze.dks.you.R;
import com.fuze.dks.you.adaptor.CardFragmentPagerAdapter;
import com.fuze.dks.you.util.ShadowTransformer;

public class NearUserViewPagerFragment extends Fragment{


    public NearUserViewPagerFragment() {
        // Required empty public constructor
    }

    public static NearUserViewPagerFragment newInstance() {
        NearUserViewPagerFragment fragment = new NearUserViewPagerFragment();
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
        View view = inflater.inflate(R.layout.fragment_near_user_view_pager, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getChildFragmentManager(), dpToPixels(2, getActivity()));
        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
        fragmentCardShadowTransformer.enableScaling(true);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
