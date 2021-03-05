package com.zhen.maptocanada.data.news;

import java.util.List;

public class CategoryData {


    /**
     * count : 2
     * next : null
     * previous : null
     * results : [{"id":2,"user":1,"title_cn":"FAQ","title_en":"FAQ","code":"faq","fid":null},{"id":1,"user":1,"title_cn":"新闻","title_en":"News","code":"news","fid":null}]
     */

    private int count;
    private Object next;
    private Object previous;
    /**
     * id : 2
     * user : 1
     * title_cn : FAQ
     * title_en : FAQ
     * code : faq
     * fid : null
     */

    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
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
