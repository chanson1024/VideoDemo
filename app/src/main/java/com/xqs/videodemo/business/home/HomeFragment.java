package com.xqs.videodemo.business.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.xqs.videodemo.MainActivity;
import com.xqs.videodemo.R;
import com.xqs.videodemo.base.BaseFragment;
import com.xqs.videodemo.base.BasePresenter;
import com.xqs.videodemo.widget.CustomToolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiaoqingsong
 * Date: 24/06/2017
 * Time: 2:05 PM
 */

public class HomeFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";

    @BindView(R.id.customToolbar)
    CustomToolbar customToolbar;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    HomeAdapter mHomeAdapter;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initialize() {

        customToolbar.setNavigationClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity() instanceof MainActivity){
                    ((MainActivity) getActivity()).toggleDrawer();
                }
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mHomeAdapter = new HomeAdapter(this.getContext());
        mRecyclerView.setAdapter(mHomeAdapter);

        mHomeAdapter.addFirstDataSet(mockData());

    }

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    public List<VideoModel> mockData(){
        List<VideoModel> modelList = new ArrayList<>();
        modelList.add(new VideoModel("视频01"));
        modelList.add(new VideoModel("视频02"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        modelList.add(new VideoModel("视频03"));
        return modelList;
    }
}
