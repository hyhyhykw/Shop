package com.hy.shop.network;

import com.google.gson.Gson;
import com.hy.shop.model.QueryBean;
import com.hy.shop.model.QueryResult;

import org.junit.Test;

import okhttp3.Call;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Created time : 2017/5/6 9:54.
 *
 * @author HY
 */
public class ShopClientTest {
    @Test
    public void getShopInfo() throws Exception {
        ShopClient client = ShopClient.newInstance();

        QueryBean queryBean = new QueryBean();
        queryBean.setAction(0);
        queryBean.setCode(1033);
        queryBean.setConditions("2");
        queryBean.setPage(0);
        queryBean.setShopId("7");
        queryBean.setUserId("45");


        Call call = client.getShopInfo(queryBean);
        Response response = call.execute();
        String string = response.body().string();

        QueryResult result = new Gson().fromJson(string, QueryResult.class);
        int resCode = result.getResCode();
        assertEquals(resCode,1);


//        assertNull(string);
    }

}