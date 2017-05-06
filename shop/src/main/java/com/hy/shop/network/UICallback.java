package com.hy.shop.network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created time : 2017/5/6 9:34.
 *
 * @author HY
 */
public abstract class UICallback implements Callback {

    private Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onFailureInUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            final String json = response.body().string();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onResponseInUI(call, json);
                }
            });
        }
    }

    public abstract void onFailureInUI(Call call, IOException e);

    public abstract void onResponseInUI(Call call, String json);
}
