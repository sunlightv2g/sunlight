package com.sunlight.webservice.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;


@HandlebarsHelper
public class WeatherHelper {

	public String weatherWrite() throws Exception{
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
        Calendar c1 = Calendar.getInstance();
        String strToday = sdf.format(c1.getTime());
//        System.out.println("Today : " + strToday);
        
        sdf = new SimpleDateFormat("HH:mm");
        c1 = Calendar.getInstance();
        String strTime = sdf.format(c1.getTime());
//        System.out.println("Time : " + strTime);

		
		StringBuilder urlBuilder = new StringBuilder("http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastTimeData"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=UjbhQ8MjpU431hYhsmwz8Gzpu8n0XiDJl23uJFlptqDNUCjqP2vRQQ8gDXpNnIWpkkPtcSvkwF7QfwsEdn9Oow%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(strToday.replace(".", ""), "UTF-8")); /*‘15년 12월 1일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(strTime.replace(":", ""), "UTF-8")); /*06시30분 발표(30분 단위) - 매시각 45분 이후 호출*/
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("68", "UTF-8")); /*예보지점 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("111", "UTF-8")); /*예보지점 Y 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*xml(기본값), json*/
        URL url = new URL(urlBuilder.toString());
        
//        System.out.println("날씨 : " + urlBuilder.toString());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        String result = sb.toString();
//        System.out.println(sb.toString());
		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        DocumentBuilder builder;
        Document doc = null;
        
        String temperature = "";
        String skyState = "";
        String skyCode = "";
     // xml 파싱하기
        InputSource is = new InputSource(new StringReader(result));
        builder = factory.newDocumentBuilder();
        doc = builder.parse(is);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        // XPathExpression expr = xpath.compile("/response/body/items/item");
        XPathExpression expr = xpath.compile("//items/item");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            NodeList child = nodeList.item(i).getChildNodes();
            
//            System.out.println("현재노드이름 : " + child.item(2).getNodeName());
//            System.out.println("현재노드이름 : " + child.item(2).getTextContent());
            
            if(child.item(2).getNodeName().equals("category") && child.item(2).getTextContent().equals("T1H")){
            	temperature = child.item(5).getTextContent();
            } 
            if(child.item(2).getNodeName().equals("category") && child.item(2).getTextContent().equals("SKY")){
            	skyCode = child.item(5).getTextContent();
            } 
            
            /*for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);
                if(node.getNodeName().equals("T1H")||node.getNodeName().equals("SKY")) {
                	
                }
                System.out.println("현재 노드 이름 : " + node.getNodeName());
                System.out.println("현재 노드 타입 : " + node.getNodeType());
                System.out.println("현재 노드 값 : " + node.getTextContent());
                System.out.println("현재 노드 네임스페이스 : " + node.getPrefix());
                System.out.println("현재 노드의 다음 노드 : " + node.getNextSibling());
                System.out.println("");
            }*/
        }
        
        switch (skyCode) {
        	case "1" :	// 맑음
        		skyState = "맑음";
        		break;
        	case "2" :	// 구름조금
        		skyState = "구름조금";
        		break;
        	case "3" :	// 구름많음
        		skyState = "구름많음";
        		break;
        	case "4" :	// 흐림
        		skyState = "흐림";
        		break;
        }
        
        String rstHtml = "<span class=\"w_date\">" + strToday + " " + strTime + "</span>";
        rstHtml = rstHtml + "<span class=\"w_img\"><img src=\"/images/sub/w_icon0" + skyCode + ".png\"></span>";
        rstHtml = rstHtml + "<span class=\"w_info\"> " + skyState + " " + temperature + " ℃</span>";
//        System.out.println(rstHtml);
        
        
		return rstHtml;
	}
}
