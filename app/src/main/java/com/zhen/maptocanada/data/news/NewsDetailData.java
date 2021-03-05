package com.zhen.maptocanada.data.news;

import java.util.List;

public class NewsDetailData {

    /**
     * id : 1
     * user : 1
     * title : 留学生毕业工签延长
     * description : 2月12日，加拿大移民局又宣布了一个重磅消息。考虑到疫情的缘故，之前留学生的网课时间可以算作毕业工签申请资质的政策得到了进一步升级，即使是100%的网课学习，也符合申请毕业工签的资质。具体政策如下： 1. 是注册就读的有毕业工签资质的项目 2.开始，或者即将开始就读于2020年春季至2021年秋季学期，或者2020年3月时就已经在读。 3.已经有学习许可或者拿到了学习许可批准，或者已经提前申请了学习许可并且得到了最终批准。 4.满足其他所有的毕业工签申请条件。
     * content : 2月12日，加拿大移民局又宣布了一个重磅消息。考虑到疫情的缘故，之前留学生的网课时间可以算作毕业工签申请资质的政策得到了进一步升级，即使是100%的网课学习，也符合申请毕业工签的资质。具体政策如下： 1. 是注册就读的有毕业工签资质的项目 2.开始，或者即将开始就读于2020年春季至2021年秋季学期，或者2020年3月时就已经在读。 3.已经有学习许可或者拿到了学习许可批准，或者已经提前申请了学习许可并且得到了最终批准。 4.满足其他所有的毕业工签申请条件。
     * ts_publish : 2021-02-24T14:45:42.411000Z
     * link : pgwp-extend
     * source : null
     * author : null
     * home_push : true
     * language : zh-hans
     * thumb : null
     * category : [{"id":1,"user":1,"title_cn":"新闻","title_en":"News","code":"news","fid":null}]
     */

    private int id;
    private int user;
    private String title;
    private String description;
    private String content;
    private String ts_publish;
    private String link;
    private Object source;
    private Object author;
    private boolean home_push;
    private String language;
    private Object thumb;
    /**
     * id : 1
     * user : 1
     * title_cn : 新闻
     * title_en : News
     * code : news
     * fid : null
     */

    private List<CategoryBean> category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTs_publish() {
        return ts_publish;
    }

    public void setTs_publish(String ts_publish) {
        this.ts_publish = ts_publish;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getAuthor() {
        return author;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public boolean isHome_push() {
        return home_push;
    }

    public void setHome_push(boolean home_push) {
        this.home_push = home_push;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getThumb() {
        return thumb;
    }

    public void setThumb(Object thumb) {
        this.thumb = thumb;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean {
        private int id;
        private int user;
        private String title_cn;
        private String title_en;
        private String code;
        private Object fid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }

        public String getTitle_cn() {
            return title_cn;
        }

        public void setTitle_cn(String title_cn) {
            this.title_cn = title_cn;
        }

        public String getTitle_en() {
            return title_en;
        }

        public void setTitle_en(String title_en) {
            this.title_en = title_en;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getFid() {
            return fid;
        }

        public void setFid(Object fid) {
            this.fid = fid;
        }
    }
}
