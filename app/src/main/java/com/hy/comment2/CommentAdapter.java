package com.hy.comment2;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amour on 2017/5/5.
 */

public class CommentAdapter extends BaseAdapter {

    private List<CommentBean> mComments=new ArrayList<>();

    //追加数据
    public void addData(List<CommentBean> comments) {
        mComments.addAll(comments);
        notifyDataSetChanged();
    }

    //添加数据
    public void setData(List<CommentBean> comments) {
        mComments.clear();
        addData(comments);
    }

    @Override
    public int getCount() {
        return null == mComments ? 0 : mComments.size();
    }

    @Override
    public CommentBean getItem(int position) {
        return mComments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lst_comment, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CommentBean item = getItem(position);

        holder.mTvName.setText(item.getNickname());
        holder.mTvTime.setText(item.getTime());
        if (item.getType() == 0) {//评论
            holder.mTvContent.setText(item.getContent());
        } else {
            String comment="回复 "+item.getReplyNmae()+"： "+item.getContent();
            SpannableStringBuilder builder=new SpannableStringBuilder(comment);
            ForegroundColorSpan yellowSpan=new ForegroundColorSpan(Color.parseColor("#f4c01e"));

            builder.setSpan(yellowSpan,2,4+item.getReplyNmae().length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

            holder.mTvContent.setText(builder);
        }
        return convertView;
    }

    class ViewHolder {
        TextView mTvName;
        TextView mTvTime;
        TextView mTvContent;

        ViewHolder(View view) {
            mTvName = (TextView) view.findViewById(R.id.tv_comment_name);
            mTvTime = (TextView) view.findViewById(R.id.tv_comment_time);
            mTvContent = (TextView) view.findViewById(R.id.tv_comment);
        }
    }
}
