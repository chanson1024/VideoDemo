package com.xqs.videodemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by xiaoqingsong
 * Date: 02/07/2017
 * Time: 4:49 PM
 */

public class MyLayout extends LinearLayout {
    public static final String TAG = "MyLayout";
    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        int action = ev.getAction();
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                Log.w(TAG,"action_down");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.w(TAG,"action_move");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.w(TAG,"action_up");
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.w(TAG,"action_cancel");
//                break;
//        }

        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        int action = event.getAction();
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                Log.w(TAG,"action_down");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.w(TAG,"action_move");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.w(TAG,"action_up");
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.w(TAG,"action_cancel");
//                break;
//        }
        return super.onTouchEvent(event);
    }
}
