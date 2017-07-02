package com.xqs.videodemo.business.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.xqs.videodemo.R;
import com.yat3s.library.adapter.BaseAdapter;
import com.yat3s.library.adapter.BaseViewHolder;

/**
 * Created by xiaoqingsong
 * Date: 24/06/2017
 * Time: 4:24 PM
 */

public class HomeAdapter extends BaseAdapter<VideoModel> {

    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, VideoModel item, int position) {
        holder.setText(R.id.tv_title, item.title);
    }

    @Override
    protected int getItemViewLayoutId(int position, VideoModel item) {
        return R.layout.item_home;
    }


}
