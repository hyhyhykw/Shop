package com.hy.shop;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.hy.shop.model.QueryResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * time: 2017/5/5.
 */
public class GoodsAdapter extends BaseAdapter {
    private List<QueryResult.ResListBean.GoodsListBean> mGoodsInfos = new ArrayList<>();

    public void addData(List<QueryResult.ResListBean.GoodsListBean> goodsInfos) {
        mGoodsInfos.addAll(goodsInfos);
        notifyDataSetChanged();
    }

    public void setData(List<QueryResult.ResListBean.GoodsListBean> goodsInfos) {
        mGoodsInfos.clear();
        addData(goodsInfos);
    }

    @Override
    public int getCount() {
        return mGoodsInfos.size();
    }

    @Override
    public QueryResult.ResListBean.GoodsListBean getItem(int position) {
        return mGoodsInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        ViewHolder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_goods, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        QueryResult.ResListBean.GoodsListBean info = getItem(position);


        Picasso.with(parent.getContext())
                .load(info.getImage())
                .into(holder.mIvImage);

        holder.mTvName.setText(info.getName());
        holder.mTvCurrentPrice.setText(context.getString(R.string.price, info.getPrice()));

        String price = context.getString(R.string.price, info.getOld_price());
        SpannableString obsPrice = new SpannableString(price);
        obsPrice.setSpan(new StrikethroughSpan(), 0, obsPrice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.mTvObsoletePrice.setText(obsPrice);

        return convertView;
    }


    class ViewHolder {
        ImageView mIvImage;
        TextView mTvName;
        TextView mTvCurrentPrice;
        TextView mTvObsoletePrice;

        ViewHolder(View view) {
            mIvImage = (ImageView) view.findViewById(R.id.iv_goods_image);
            mTvName = (TextView) view.findViewById(R.id.tv_goods_name);
            mTvCurrentPrice = (TextView) view.findViewById(R.id.tv_price_current);
            mTvObsoletePrice = (TextView) view.findViewById(R.id.tv_price_obsolete);
        }
    }
}
