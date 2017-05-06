package com.hy.comment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class CommentActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTvBack;//后退
    private TextView mTvShare;//分享

    private Toolbar mToobar;
    private ImageView mIvHead;//用户头像
    private TextView mTvName;//用户昵称

    private Button mBtnFollow;//关注按钮
    private TextView mTvDetail;//帖子内容
    private GridView mGrdImage;//帖子图片
    private TextView mTvLocation;//位置
    private TextView mTvTime;//发帖时间
    private GridView mGrdFollow;
    private NoScrollListView mLstComment;//评论显示
    private List<CommentBean> mComments;


    private ImageView mIvEmoji;//回帖旁的表情按钮
    private Button mBtnComment;//评论按钮
    private EditText mEdtComment;//评论输入框


    private List<Integer> mImages = new ArrayList<>();
    private CommentAdapter mCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        //绑定视图
        bindView();
        //初始化
        init();
    }

    //绑定视图
    private void bindView() {
        mTvBack = (TextView) findViewById(R.id.tv_back);
        mTvShare = (TextView) findViewById(R.id.tv_share);

        mToobar = (Toolbar) findViewById(R.id.main_toobar);
        mIvHead = (ImageView) findViewById(R.id.iv_head);
        mTvName = (TextView) findViewById(R.id.tv_nickname);
        mBtnFollow = (Button) findViewById(R.id.btn_follow);

        mTvDetail = (TextView) findViewById(R.id.tv_detail);
        mGrdImage = (GridView) findViewById(R.id.grd_image);
        mTvLocation = (TextView) findViewById(R.id.tv_location);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mGrdFollow = (GridView) findViewById(R.id.grd_follow);
        mLstComment = (NoScrollListView) findViewById(R.id.lst_comment);
        mIvEmoji = (ImageView) findViewById(R.id.iv_emoji);
        mBtnComment = (Button) findViewById(R.id.btn_comment);
        mEdtComment = (EditText) findViewById(R.id.edt_comment);
    }

    //初始化
    private void init() {
        setSupportActionBar(mToobar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageAdapter adapter = new ImageAdapter();
        //添加假数据
        mImages.add(R.drawable.ic_test);
        mImages.add(R.drawable.ic_test);
        mImages.add(R.drawable.ic_test);
        adapter.setData(mImages);
        //设置适配器
        mGrdImage.setAdapter(adapter);
        mGrdFollow.setAdapter(new FollowsAdapter());

        mCommentAdapter = new CommentAdapter();
        getComments();
        mCommentAdapter.setData(mComments);
        mLstComment.setAdapter(mCommentAdapter);
        //点击事件
        mTvBack.setOnClickListener(this);
        mTvShare.setOnClickListener(this);
        mBtnFollow.setOnClickListener(this);
        mBtnComment.setOnClickListener(this);
        mIvEmoji.setOnClickListener(this);
    }

    //添加假数据
    private void getComments() {
        mComments = new ArrayList<>();
        CommentBean comment1 = new CommentBean();
        comment1.setType(0);
        comment1.setNickname("静静的鱼");
        comment1.setTime("30分钟前");
        comment1.setContent("景色不错");
        mComments.add(comment1);

        CommentBean comment2 = new CommentBean();
        comment2.setType(1);
        comment2.setReplyNmae("奔跑的小鸟");
        comment2.setNickname("行走在路上");
        comment2.setTime("35分钟前");
        comment2.setContent("这是哪里");
        mComments.add(comment2);

        CommentBean comment3 = new CommentBean();
        comment3.setType(0);
        comment3.setNickname("奔跑的小鸟");
        comment3.setTime("40分钟前");
        comment3.setContent("不错，点个赞");
        mComments.add(comment3);

        CommentBean comment4 = new CommentBean();
        comment4.setType(0);
        comment4.setNickname("长安瑾萱");
        comment4.setTime("1小时前");
        comment4.setContent("风景真好");
        mComments.add(comment4);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back://后退
                onBackPressed();
                break;
            case R.id.tv_share://分享
                // TODO: 2017/5/5 分享按钮点击
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_follow://关注
                // TODO: 2017/5/5 关注按钮点击
                Toast.makeText(this, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_comment://评论
                // TODO: 2017/5/5 评论按钮点击
                Toast.makeText(this, "评论", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_emoji://表情
                // TODO: 2017/5/5
                Toast.makeText(this, "表情", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
