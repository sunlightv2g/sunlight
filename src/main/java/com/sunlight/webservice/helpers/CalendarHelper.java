package com.sunlight.webservice.helpers;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.github.jknack.handlebars.Options;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

@HandlebarsHelper
public class CalendarHelper {

	public CharSequence calendar(Object context, Options options) throws IOException {

		Map<String, Object> calendatMap = null;
		try {
			String toyear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			String tomonth = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
			String year = options.param(0, toyear); // parameter.
			String month = options.param(1, tomonth); // parameter.
			
			Calendar c = Calendar.getInstance(); //Calendar 객체 생성
			System.out.println("today is "+c.getTime()); // 현재시각을 알려주는 메소드 입니다.
			System.out.println("year : " + year);
			System.out.println("month : "+ month);
			
			//set메소드를 통해 연도 월 일 을 설정
			c.set(Calendar.YEAR, Integer.valueOf(year)); 
			c.set(Calendar.MONTH, Integer.valueOf(month)-1); //시작 일이 1이 아닌 0부터 시작하여                         1을 빼줌니다
			c.set(Calendar.DAY_OF_MONTH, 1); // 처음 시작요일설정

			int dayofweek = c.get(Calendar.DAY_OF_WEEK);
			//일 = 1 월 =2 화 =3 ..
			
			System.out.println("dayofweek : "+ dayofweek);
			System.out.println("dayoCalendar.DAY_OF_MONTH : "+ Calendar.DAY_OF_MONTH);
			System.out.println("c.get(Calendar.DAY_OF_MONTH) : "+ c.get(Calendar.DAY_OF_MONTH));
			
			c.set(Calendar.DAY_OF_MONTH, 32); //32 이상일땐 마지막 요일로 자동 설정
			int lastday = 32 - c.get(Calendar.DAY_OF_MONTH);
			
			System.out.println("lastday : "+ lastday);
			
			
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			/*
			int i =0;
			List<Map> firstList = Lists.newArrayList();
			for(;i<dayofweek - 1; i++){
				System.out.print("n\t");
				Map<String, Object> numberMap = Maps.newHashMap();
				numberMap.put("firstDay", String.valueOf(i));
				firstList.add(numberMap);
			}
			
			int leftday = 0;
			List<Map> dayList = Lists.newArrayList();
			for(int day=1; day<=lastday; day++,i++){
				leftday = i % 7; 
				if(i % 7 ==0){
					System.out.println("");
				}
				Map<String, Object> numberMap = Maps.newHashMap();
				numberMap.put("leftday", (leftday == 6 ? true : false));
				numberMap.put("day", String.valueOf(day));
				dayList.add(numberMap);
				
				System.out.print(day + "\t");
			}
			//System.out.println("leftday : "+ );
			List<Map> leftList = Lists.newArrayList();
			for(i=0;i<6-leftday; i++){
				System.out.print("n\t");
				Map<String, Object> numberMap = Maps.newHashMap();
				numberMap.put("leftday", String.valueOf(i));
				leftList.add(numberMap);
			}*/
			
			calendatMap = this.makeCalendatMap(year,month, dayofweek,lastday);
			
			/*
			calendatMap.put("firstList", firstList);
			calendatMap.put("dayList", dayList);
			calendatMap.put("leftList", leftList);
			calendatMap.put("dayofweek", dayofweek);
			calendatMap.put("lastday", lastday);
			calendatMap.put("leftday", leftday);*/
			
		} catch (Exception e) {
			calendatMap = Maps.newHashMap();
		}

		return options.fn(calendatMap);
	}
	
	private Map<String, Object> makeCalendatMap(String year, String month, int dayofweek, int lastday) {
		
		String toyear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		String tomonth = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
		String today = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		
		Map<String, Object> calendatMap = Maps.newHashMap();
		
		int i = 0;
				
		List<Map> firstList = Lists.newArrayList();
		for(;i<dayofweek - 1; i++){
			System.out.print("n\t");
			Map<String, Object> numberMap = Maps.newHashMap();
			numberMap.put("firstTr", String.valueOf(i));
			firstList.add(numberMap);
		}
		
		int leftday = 0;
		List<Map> dayList = Lists.newArrayList();
		for(int day=1; day<=lastday; day++,i++){
			leftday = i % 7; 
			boolean dayFlag = false;
			if(i % 7 ==0){
				System.out.println("");
			}
			Map<String, Object> numberMap = Maps.newHashMap();
			
			if(toyear.equals(year) && addZero(tomonth).equals(addZero(month)) && addZero(today).equals(addZero(String.valueOf(day))) ) {
				dayFlag = true;
			}else {
				dayFlag = false;
			}
			
			numberMap.put("todate", year + "." + addZero(month) + "." + addZero(String.valueOf(day)));
			numberMap.put("dayFlag", dayFlag);
			numberMap.put("leftday", (leftday == 0 ? true : false));
			numberMap.put("day", String.valueOf(day));
			dayList.add(numberMap);
			
			System.out.print(day + "\t");
		}
		
		
				//System.out.println("leftday : "+ );
		List<Map> leftList = Lists.newArrayList();
		for(i=0;i<6-leftday; i++){
			System.out.print("n\t");
			Map<String, Object> numberMap = Maps.newHashMap();
			numberMap.put("leftTr", String.valueOf(i));
			leftList.add(numberMap);
		}
		
		
		calendatMap.put("firstList", firstList);
		calendatMap.put("dayList", dayList);
		calendatMap.put("leftList", leftList);

		return calendatMap;
	}

	public static String addZero(String str) {
	    if(str.length() == 1) {
	    	str = "0" + str;
	    }
	    return str;
	}
	
}
