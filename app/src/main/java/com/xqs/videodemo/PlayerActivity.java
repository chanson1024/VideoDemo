package com.xqs.videodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mVideoView = (VideoView) findViewById(R.id.vv);

//        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Test_Movie.m4v");
        Uri uri = Uri.parse("http://myapp-1251321133.costj.myqcloud.com/shipin/01.mp4");
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        mVideoView.requestFocus();

    }

}
