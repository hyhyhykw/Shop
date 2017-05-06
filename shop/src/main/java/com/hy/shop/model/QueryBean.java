package com.hy.shop.model;

/**
 * Created time : 2017/5/6 9:22.
 *
 * @author HY
 */
public class QueryBean {

    /**
     * action : 0
     * code : 1033
     * conditions : 2
     * page : 0
     * shopId : 7
     * userId : 45
     */

    private int action;
    private int code;
    private String conditions;
    private int page;
    private String shopId;
    private String userId;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
