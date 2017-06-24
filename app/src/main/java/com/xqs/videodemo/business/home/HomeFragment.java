package com.xqs.videodemo.business.home;

import com.xqs.videodemo.R;
import com.xqs.videodemo.base.BaseFragment;
import com.xqs.videodemo.base.BasePresenter;

/**
 * Created by xiaoqingsong
 * Date: 24/06/2017
 * Time: 2:05 PM
 */

public class HomeFragment extends BaseFragment {
    @Override
    protected int getContentViewLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }
}
