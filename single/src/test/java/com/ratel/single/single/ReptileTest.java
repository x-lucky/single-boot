package com.ratel.single.single;

import com.alibaba.fastjson.JSON;
import com.power.common.util.OkHttp3Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        header.put("Cookie","aliyungf_tc=AQAAAAh98lcBCgsARuQRt2IEBOSt1/cF; acw_tc=2760821d15558977047377958e78fd36ae3d20e574f85ee6709bb367eb4420; _ga=GA1.3.1153965120.1555897721; _gid=GA1.3.1823233480.1555897721; JSESSIONID=8309A74FD57F587DCC0646FBBBA0CB74");

        String url = "https://gaokao.chsi.com.cn/lqfs/query.do";
        String s = OkHttp3Util.syncGet(url, param,header);

        System.out.println(s);

    }

    @Test
    public void jsoup() throws Exception {
        File file = new File("D:\\myspace\\single-boot\\gaokaohtml.txt");
        Document document = Jsoup.parse(file, "UTF-8");
        Element body = document.body();
        Elements table = body.getElementsByTag("table");
        //高校信息
        Element schoolAllEle = table.get(2);

        //高校信息带标题
        Elements trs = schoolAllEle.getElementsByTag("tr");

        //验证数据
        Elements ths = trs.get(0).getElementsByTag("th");
        Element valid = ths.get(0);
        if (!valid.text().equals("高校名称")) {
            throw new Exception("没数据了");
        }
        List<SchoolInfo> schoolInfos = new ArrayList<>();
        int size = trs.size();
        for (int i = 2; i < size; i++) {
            SchoolInfo schoolInfo = new SchoolInfo();
            Element schoolInfoEle = trs.get(i);
            Elements tds = schoolInfoEle.getElementsByTag("td");
            System.out.println("--------------------------------");
            System.out.println(tds);
            System.out.println("--------------------------------");
            for (int j = 0; j < tds.size(); j++) {
                Element td = tds.get(j);
                String text = td.text();
                switch (j){
                    case 0 :
                        schoolInfo.setSchoolName(text);
                        continue;
                    case 1 :
                        schoolInfo.setSchoolLocation(text);
                        continue;
                    case 2 :
                        schoolInfo.setBatch(text);
                        continue;
                    case 4 :
                        schoolInfo.setScoreLimit(text);
                        continue;
                    case 5 :
                        schoolInfo.setSchoolAverage(text);
                        continue;
                }
            }
            schoolInfos.add(schoolInfo);
        }
        System.out.println(JSON.toJSONString(schoolInfos));

    }


}
