package com.duoec.htmlparse.config;

import java.util.List;

/**
 * Created by ycoe on 16/7/19.
 */
public class ParseConfig {
    /**
     * 路径测试,测试本配置是否适配此解析器
     * 必须匹配所有条件!
     */
    private List<String> test;

    /**
     * 适配的实体类(含包名)
     */
    private String entity;

    /**
     * 当前分析的根路径,默认为body
     */
    private String path;

    /**
     * 每个字段的配置
     */
    private List<ParseItemConfig> items;

    public List<String> getTest() {
        return test;
    }

    public void setTest(List<String> test) {
        this.test = test;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ParseItemConfig> getItems() {
        return items;
    }

    public void setItems(List<ParseItemConfig> items) {
        this.items = items;
    }
}
