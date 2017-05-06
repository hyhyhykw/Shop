package com.hy.shop.network;

import com.google.gson.Gson;
import com.hy.shop.model.QueryBean;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created time : 2017/5/6 9:23.
 *
 * @author HY
 */

public class ShopClient {
    private OkHttpClient mClient;
    private Gson mGson;
    private static final String BASE_URL = "http://gchannel.com.cn/index.php/Api/";
    //###########################      单例模式(start)      ###########################

    private static ShopClient mShopClient;

    private ShopClient() {
        // 日志拦截器的创建
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // OkHttpClient 的初始化


        mClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        mGson = new Gson();
    }

    public static synchronized ShopClient newInstance() {
        if (null == mShopClient) {
            mShopClient = new ShopClient();
        }
        return mShopClient;
    }

    //#############################      单例模式(end)      ###############################

    //查询商店
    public Call getShopInfo(QueryBean queryBean) {
        RequestBody body = new FormBody
                .Builder()
                .add("JSON", mGson.toJson(queryBean))
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .build();

        return mClient.newCall(request);
    }

}
