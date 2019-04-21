package com.ratel.single.single;

import com.power.common.util.OkHttp3Util;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * User: niexiang
 * Date: 2019/4/21
 */
public class ReptileTest {



    @Test
    public void test(){
        Map<String, String> param = new HashMap<>();
        param.put("ssdm","11");
        param.put("year","2017");
        param.put("kldm","11");
        param.put("score","600");
        param.put("ranger","10");
        param.put("type","0");
        param.put("entrytype","gkstu");


        Map<String, String> header = new HashMap<>();
        header.put("Cookie","aliyungf_tc=AQAAAFf/J3jOJwYA3yxXccBx7MidNZA7; acw_tc=2760825e15558112504208873ea133e765bc1ed0808e217b287a1ecb197095; _ga=GA1.3.624643797.1555811251; _gid=GA1.3.1620976712.1555811251; JSESSIONID=C132E519A1C05CD493E0C05DACEC8195; _gat_gtag_UA_100524_6=1");
        header.put("Referer","https://gaokao.chsi.com.cn/lqfs/query.do?ssdm=11&year=2017&kldm=11&score=600&ranger=10&entrytype=gkstu  ");
        header.put("Host","gaokao.chsi.com.cn");
        header.put("entrytype","gkstu");


        String url = "https://gaokao.chsi.com.cn/lqfs/query.do";
        String s = OkHttp3Util.syncGet(url, param);
        System.out.println(s);



    }


}
