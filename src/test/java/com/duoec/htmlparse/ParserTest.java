package com.duoec.htmlparse;

import com.alibaba.fastjson.JSONObject;
import com.duoec.htmlparse.config.ParseConfig;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by ycoe on 16/7/19.
 */
public class ParserTest {
    @Test
    public void parseTest(){
        String path = System.getProperty("user.dir");

        String htmlPath = path + "/src/test/resources/fang.html";
        File htmlFile = new File(htmlPath);

        String html = null;
        try {
            html = FileUtils.readFileToString(htmlFile, "GB2312");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(html == null) {
            return;
        }

        String configPath = path + "/src/test/resources/fang.json";
        File configFile = new File(configPath);
        String configStr = null;
        try{
            configStr = FileUtils.readFileToString(configFile, "UTF-8");
        }catch (IOException e) {
            e.printStackTrace();
        }
        if(configStr == null) {
            return;
        }

        ParseConfig config = JSONObject.parseObject(configStr, ParseConfig.class);

        String url = "";
        House house = new Parser<House>().parse(url, html, config);
        
        System.out.println(html);
    }
}
