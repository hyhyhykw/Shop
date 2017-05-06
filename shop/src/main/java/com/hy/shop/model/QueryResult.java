package com.hy.shop.model;

import java.util.List;

/**
 * Created time : 2017/5/6 10:03.
 *
 * @author HY
 */

public class QueryResult {


    private int resCode;
    private String resMsg;
    private ResListBean resList;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public ResListBean getResList() {
        return resList;
    }

    public void setResList(ResListBean resList) {
        this.resList = resList;
    }

    public static class ResListBean {

        private String share_url;
        private String isCollect;
        private String good_pic_url;
        private ShopDetailBean shopDetail;
        private List<GoodsListBean> goodsList;

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getIsCollect() {
            return isCollect;
        }

        public void setIsCollect(String isCollect) {
            this.isCollect = isCollect;
        }

        public String getGood_pic_url() {
            return good_pic_url;
        }

        public void setGood_pic_url(String good_pic_url) {
            this.good_pic_url = good_pic_url;
        }

        public ShopDetailBean getShopDetail() {
            return shopDetail;
        }

        public void setShopDetail(ShopDetailBean shopDetail) {
            this.shopDetail = shopDetail;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class ShopDetailBean {

            private String id;
            private String name;
            private String logo;
            private String merchant_id;
            private String grade;
            private int number;
            private String notice;
            private String status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(String merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }

        public static class GoodsListBean {

            private String id;
            private String name;
            private String category_id;
            private String price;
            private String image;
            private String image_thumb;
            private String describe;
            private String create_at;
            private String update_at;
            private String status;
            private String sort;
            private String is_top;
            private String shop_id;
            private String shop_category_id;
            private String is_post;
            private String is_shelves;
            private String old_price;
            private String sales;
            private String marques;
            private String marques_value;
            private String number;
            private String prompt;
            private String stock;
            private String entry_id;
            private Object tag_id;
            private Object stick;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getImage_thumb() {
                return image_thumb;
            }

            public void setImage_thumb(String image_thumb) {
                this.image_thumb = image_thumb;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getCreate_at() {
                return create_at;
            }

            public void setCreate_at(String create_at) {
                this.create_at = create_at;
            }

            public String getUpdate_at() {
                return update_at;
            }

            public void setUpdate_at(String update_at) {
                this.update_at = update_at;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getIs_top() {
                return is_top;
            }

            public void setIs_top(String is_top) {
                this.is_top = is_top;
            }

            public String getShop_id() {
                return shop_id;
            }

            public void setShop_id(String shop_id) {
                this.shop_id = shop_id;
            }

            public String getShop_category_id() {
                return shop_category_id;
            }

            public void setShop_category_id(String shop_category_id) {
                this.shop_category_id = shop_category_id;
            }

            public String getIs_post() {
                return is_post;
            }

            public void setIs_post(String is_post) {
                this.is_post = is_post;
            }

            public String getIs_shelves() {
                return is_shelves;
            }

            public void setIs_shelves(String is_shelves) {
                this.is_shelves = is_shelves;
            }

            public String getOld_price() {
                return old_price;
            }

            public void setOld_price(String old_price) {
                this.old_price = old_price;
            }

            public String getSales() {
                return sales;
            }

            public void setSales(String sales) {
                this.sales = sales;
            }

            public String getMarques() {
                return marques;
            }

            public void setMarques(String marques) {
                this.marques = marques;
            }

            public String getMarques_value() {
                return marques_value;
            }

            public void setMarques_value(String marques_value) {
                this.marques_value = marques_value;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getPrompt() {
                return prompt;
            }

            public void setPrompt(String prompt) {
                this.prompt = prompt;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public String getEntry_id() {
                return entry_id;
            }

            public void setEntry_id(String entry_id) {
                this.entry_id = entry_id;
            }

            public Object getTag_id() {
                return tag_id;
            }

            public void setTag_id(Object tag_id) {
                this.tag_id = tag_id;
            }

            public Object getStick() {
                return stick;
            }

            public void setStick(Object stick) {
                this.stick = stick;
            }
        }
    }
}
