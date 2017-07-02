package com.xqs.videodemo.business.community;

import android.os.Bundle;

import com.xqs.videodemo.R;
import com.xqs.videodemo.base.BaseFragment;
import com.xqs.videodemo.base.BasePresenter;

/**
 * Created by xiaoqingsong
 * Date: 24/06/2017
 * Time: 2:38 PM
 */

public class CommunityFragment extends BaseFragment{

    public static CommunityFragment newInstance() {

        Bundle args = new Bundle();

        CommunityFragment fragment = new CommunityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_community;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }
}
