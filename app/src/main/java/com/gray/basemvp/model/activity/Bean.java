package com.gray.basemvp.model.activity;

import com.google.gson.annotations.SerializedName;
import com.gray.basemvp.base.BaseBean;

import java.util.List;

/**
 * @author wjy on 2018/3/30.
 */

public class Bean extends BaseBean {

    /**
     * data : [{"id":"1","cover_pic":"http://rentcloudtest.image.alimmdn.com/2/15142681609797.jpg","title":"这是云租的第一个故事","introduction":"云租故事测试-102093","city":"温州","created_at":"2017-12-26","url":"http://xx222.sss.ss","saw":"0"}]
     * api_code : 200
     */


    @SerializedName("data")
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * cover_pic : http://rentcloudtest.image.alimmdn.com/2/15142681609797.jpg
         * title : 这是云租的第一个故事
         * introduction : 云租故事测试-102093
         * city : 温州
         * created_at : 2017-12-26
         * url : http://xx222.sss.ss
         * saw : 0
         */

        @SerializedName("id")
        private String id;
        @SerializedName("cover_pic")
        private String coverPic;
        @SerializedName("title")
        private String title;
        @SerializedName("introduction")
        private String introduction;
        @SerializedName("city")
        private String city;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("url")
        private String url;
        @SerializedName("saw")
        private String saw;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCoverPic() {
            return coverPic;
        }

        public void setCoverPic(String coverPic) {
            this.coverPic = coverPic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSaw() {
            return saw;
        }

        public void setSaw(String saw) {
            this.saw = saw;
        }
    }
}
