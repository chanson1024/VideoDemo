package com.xqs.videodemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xiaoqingsong
 * Date: 02/07/2017
 * Time: 4:51 PM
 */

public class MyView extends View {
    public static final String TAG = "MyView";
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.w(TAG,"action_down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.w(TAG,"action_move");
                break;
            case MotionEvent.ACTION_UP:
                Log.w(TAG,"action_up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.w(TAG,"action_cancel");
                break;
        }
        return true;
//        return super.onTouchEvent(event);
    }
}
