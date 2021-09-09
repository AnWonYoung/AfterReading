package com.wonyoung.afterreading.board;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.text.html.HTMLDocument;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class BoardService {
    private static String bestSeller_URL = "http://www.kyobobook.co.kr/bestSellerNew/bestseller.laf";

    public List<CrawlEntity> getBestSellerDatas() throws IOException{
        List<CrawlEntity> bestSellerList = new ArrayList<>();
        Document doc = Jsoup.connect(bestSeller_URL).get();
        Elements element = doc.select("ul.list_type01 li");
//        System.out.println(element);
//
//        Iterator<Element> ie1 = element.select(".cover img").iterator();
//        Iterator<Element> ie2 = element.select(".title strong").iterator();
//        Iterator<Element> ie3 = element.select("div.author").iterator();
//
//        while(ie1.hasNext()) {
//            System.out.println(ie1.next().text()+ie2.next().text()+ie3.next().text());
//        }

        for(Element item : element) {
            CrawlEntity crawlEntity = CrawlEntity.builder()
                    .bookCover(item.select("div.cover a img").attr("src"))
                    .title(item.select(".title strong").text())
                    .author(item.select("div.author").text()).build();

            bestSellerList.add(crawlEntity);
            System.out.println(crawlEntity.toString());
        }
        return bestSellerList;
    }

}
