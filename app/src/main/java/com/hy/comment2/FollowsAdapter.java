package com.hy.comment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


/**
 * Created by Amour on 2017/5/5.
 */

public class FollowsAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null==convertView){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grd_follows,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        ImageView iv=holder.mIvFollow;
        if (position==8){
            iv.setImageResource(R.drawable.ic_more);
            iv.setBackgroundResource(R.drawable.icon_bg);
        }else{
            iv.setImageResource(R.drawable.ic_person);
        }
        return convertView;
    }

     class ViewHolder {
        ImageView mIvFollow;

        ViewHolder(View view) {
            mIvFollow= (ImageView) view.findViewById(R.id.iv_follow);
        }
    }
}
