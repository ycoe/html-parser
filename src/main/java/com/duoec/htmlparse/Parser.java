package com.duoec.htmlparse;

import com.duoec.htmlparse.config.ParseConfig;
import com.duoec.htmlparse.config.ParseItemConfig;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ycoe on 16/7/19.
 */
public class Parser<T> {
    private static Logger logger = LoggerFactory.getLogger(Parser.class);

    public T parse(String url, String html, ParseConfig config) {
Document doc = Jsoup.parse(html, url);

        //尝试匹配
        if (!testDoc(config, doc)) {
            return null;
        }

        //初始化实体类
        T entity = getEntity(config);

        String path = config.getPath();
        if(StringUtils.isEmpty(path)) {
            path = "body";
        }
        Elements body = doc.select(path);
        List<ParseItemConfig> items = config.getItems();
        if(items == null) {
            return null;
        }

        for (ParseItemConfig item : items) {
            String fieldName = item.getName();
        }

        return entity;
    }

    private T getEntity(ParseConfig config) {
        Class<T> clazz;
        try {
            clazz = (Class<T>) Class.forName(config.getEntity());
        } catch (ClassNotFoundException e) {
            logger.error("配置的entity值与返回值不一致!");
            throw new ParseException(e);
        }

        T entity;
        try {
            entity = clazz.newInstance();
        } catch (Exception e) {
            logger.error("初始化实体{}失败!", config.getEntity());
            throw new ParseException(e);
        }
        return entity;
    }

    private boolean testDoc(ParseConfig config, Document doc) {
        List<String> testList = config.getTest();
        if(testList != null && !testList.isEmpty()) {
            for(String selector : testList) {
                if(doc.select(selector).isEmpty()) {
                    logger.error("本文档不匹配test: {}", selector);
                    return false;
                }
            }
        }
        return true;
    }
}
