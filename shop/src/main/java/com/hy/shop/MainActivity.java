package com.hy.shop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.shop.model.QueryResult;
import com.hy.shop.model.QueryBean;
import com.hy.shop.network.ShopClient;
import com.hy.shop.network.UICallback;
import com.hy.shop.utils.CommandUtils;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import okhttp3.Call;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ImageView mIvBack;
    private TextView mTvTitle;
    private ImageView mIvShare;
    private ImageView mIvShopIcon;
    private TextView mTvShopName;
    private TextView mTvShopScore;
    private TextView mTvGoodsNum;
    private TextView mTvNewGoods;
    private TextView mTvRecommend;
    private TextView mTvAll;
    private GridView mGrdGoods;

    private List<TextView> mTextViews = new ArrayList<>();

    private ShopClient mShopClient;
    private GoodsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        init();

    }


    private void bindView() {
        mToolbar = (Toolbar) findViewById(R.id.main_toobar);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mIvShare = (ImageView) findViewById(R.id.iv_share);
        mIvShopIcon = (ImageView) findViewById(R.id.iv_shopicon);
        mTvShopName = (TextView) findViewById(R.id.tv_shopname);
        mTvShopScore = (TextView) findViewById(R.id.tv_score);
        mTvGoodsNum = (TextView) findViewById(R.id.tv_goods_number);
        mTvNewGoods = (TextView) findViewById(R.id.tv_goods_new);
        mTvRecommend = (TextView) findViewById(R.id.tv_recommend);
        mTvAll = (TextView) findViewById(R.id.tv_all);
        mGrdGoods = (GridView) findViewById(R.id.grd_goods);
    }

    private void init() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mIvBack.setOnClickListener(this);
        mIvShare.setOnClickListener(this);
        mShopClient = ShopClient.newInstance();

        mTextViews.add(mTvNewGoods);
        mTextViews.add(mTvRecommend);
        mTextViews.add(mTvAll);

        for (TextView view : mTextViews) {
            view.setOnClickListener(mListener);
        }

        mAdapter = new GoodsAdapter();
        mGrdGoods.setAdapter(mAdapter);
        queryData();
    }

    //新品 促销 全部
    private View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (TextView view : mTextViews) {
                view.setSelected(false);
                view.setTextColor(Color.parseColor("#999999"));
                view.setTextSize(CommandUtils.px2sp(MainActivity.this,35));
            }

            TextView txt = (TextView) v;
            txt.setTextColor(Color.BLACK);
            txt.setTextSize(CommandUtils.px2sp(MainActivity.this,40));
            txt.setSelected(true);
        }
    };

    //连接网络，查询商店信息
    private void queryData() {
        QueryBean queryBean = new QueryBean();
        queryBean.setAction(0);
        queryBean.setCode(1033);
        queryBean.setConditions("2");
        queryBean.setPage(0);
        queryBean.setShopId("7");
        queryBean.setUserId("45");

        mShopClient.getShopInfo(queryBean).enqueue(new UICallback() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, String json) {
                QueryResult result = new Gson().fromJson(json, QueryResult.class);
                if (result.getResCode() == 1 && "查询成功".equals(result.getResMsg())) {
                    //商店详情
                    QueryResult.ResListBean resList = result.getResList();
                    QueryResult.ResListBean.ShopDetailBean shopDetail = resList.getShopDetail();

                    mTvShopScore.setText(getString(R.string.score, shopDetail.getGrade()));
                    mTvGoodsNum.setText(getString(R.string.goods_number, "" + shopDetail.getNumber()));
                    mTvShopName.setText(shopDetail.getName());

                    Picasso.with(MainActivity.this)
                            .load(shopDetail.getLogo())
                            .transform(new CropCircleTransformation())
                            .into(mIvShopIcon);

                    mAdapter.setData(resList.getGoodsList());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_share:
                // TODO: 2017/5/5
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
