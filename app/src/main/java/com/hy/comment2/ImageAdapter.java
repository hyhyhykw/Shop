package com.hy.comment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;


/**
 * Created by Amour on 2017/5/5.
 */
public class ImageAdapter extends BaseAdapter {

    private List<Integer> mIcons;

    public void setData(List<Integer> icons) {
        this.mIcons = icons;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return null == mIcons ? 0 : mIcons.size();
    }

    @Override
    public Object getItem(int position) {
        return mIcons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grd_image, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mIvImage.setImageResource(mIcons.get(position));

        return convertView;
    }

      class ViewHolder {
        ImageView mIvImage;

        ViewHolder(View view) {
            mIvImage= (ImageView) view.findViewById(R.id.iv_image);
        }

    }
}
