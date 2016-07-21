package com.duoec.htmlparse.config;

import java.util.List;

/**
 * Created by ycoe on 16/7/20.
 */
public class ParseItemConfig {
    /**
     * 字段名称
     */
    private String name;

    /**
     * 分析目标: url | html
     */
    private String target;

    /**
     * 正则表达式
     */
    private String pattern;

    /**
     * DOM路径选择器
     */
    private String path;

    /**
     * 处理管道,经过路径获取到的值,进入管道清洗
     */
    private List<String> pipes;

    /**
     * 验证,从管道出来的值,进行验证,必须通过所有验证条件的才认为是正确的
     */
    private List<String> validates;

    /**
     * 如果当前属性是列表时
     */
    private List<ParseItemConfig> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getPipes() {
        return pipes;
    }

    public void setPipes(List<String> pipes) {
        this.pipes = pipes;
    }

    public List<String> getValidates() {
        return validates;
    }

    public void setValidates(List<String> validates) {
        this.validates = validates;
    }

    public List<ParseItemConfig> getItems() {
        return items;
    }

    public void setItems(List<ParseItemConfig> items) {
        this.items = items;
    }
}
