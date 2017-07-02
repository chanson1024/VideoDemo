package com.xqs.videodemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xqs.videodemo.R;

/**
 * Created by xiaoqingsong
 * Date: 02/07/2017
 * Time: 4:53 PM
 */

public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);
    }
}
