package com.sunlight.webservice.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoSearchRequestDto;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckMainResponseDto;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckSearchRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionSearchRequestDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistoryMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySearchRequestDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageSearchRequestDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataMainResponseDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataSearchRequestDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataTimeResponseDto;
import com.sunlight.webservice.service.environment.EquipmentinfoService;
import com.sunlight.webservice.service.environment.RoutinecheckService;
import com.sunlight.webservice.service.environment.UserinfoService;
import com.sunlight.webservice.service.maintenance.EventconditionService;
import com.sunlight.webservice.service.maintenance.EventhistoryService;
import com.sunlight.webservice.service.maintenance.EventmanageService;
import com.sunlight.webservice.service.posts.PostsService;
import com.sunlight.webservice.service.statistics.StatsdataService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;
	private RoutinecheckService routineCheckService;
	private UserinfoService userinfoService;
	private EquipmentinfoService equipmentinfoService;
	private EventmanageService eventmanageService;
	private EventhistoryService eventhistoryService;
	private StatsdataService statsdataService;
	private EventconditionService eventconditionService;
	
    @GetMapping("/")
    public String main(Model model) {
    	
    	//model.addAttribute("posts", postsService.findAllDesc());
        //return "main";
    	return "redirect:/monitoring/livemonitoring";
    }
    

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    
    @GetMapping("/monitoring/livemonitoring")
    public String livemonitoring(Model model, StatsdataSearchRequestDto statsdataSearchResponseDto, EventconditionSearchRequestDto eventconditionSearchRequestDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 3) Pageable pageable){
    	/*ㅇ 문백보건지소 : 0002840
    	ㅇ 광혜원보건지소 : 0004092
    	ㅇ 서울에너지공사 : 0004201
    	ㅇ 신포천변전소 : 0004372*/
    	
    	int min = 0;
    	int max = 0;
    	int randomNum = 0;
    	
    	max = 1320;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0002840"); //1320
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	String rst1 = statsdataService.getStatisticsTotalByQuerydsl(statsdataSearchResponseDto);
    	model.addAttribute("rstTotal1", rst1);
    	
    	max = 1323;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0004092"); //1320
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	String rst2 = statsdataService.getStatisticsTotalByQuerydsl(statsdataSearchResponseDto);
    	model.addAttribute("rstTotal2", rst2);
    	
    	max = 1347;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0004201"); //1320
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	String rst3 = statsdataService.getStatisticsTotalByQuerydsl(statsdataSearchResponseDto);
    	model.addAttribute("rstTotal3", rst3);
    	
    	max = 1360;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0004372"); //1320
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	String rst4 = statsdataService.getStatisticsTotalByQuerydsl(statsdataSearchResponseDto);
    	model.addAttribute("rstTotal4", rst4);
    	
    	Page<EventconditionMainResponseDto> eventconditionMainResponseDto = eventconditionService.getEventconditionListByQueryDSL(eventconditionSearchRequestDto, pageable);
    	
    	model.addAttribute("search", eventconditionSearchRequestDto);
    	model.addAttribute("dataList", eventconditionMainResponseDto);
    	
    	model.addAttribute("currentPage", pageable.getPageNumber()+1);
    	model.addAttribute("countPerPageGroup",pageable.getPageSize());
    	model.addAttribute("totlalCount", eventconditionMainResponseDto.getTotalElements());
    	model.addAttribute("totlalPageCount", eventconditionMainResponseDto.getTotalPages());
    	
    	StatsdataSearchRequestDto statsdataSearchRequestDto = new StatsdataSearchRequestDto();
    	
    	List<StatsdataTimeResponseDto> daydata =  statsdataService.getStatisticsTimeByQuerydsl(statsdataSearchRequestDto);
    	String timeval = "";
    	String dayflag = "";
    	int totalval = 0;
    	for(StatsdataTimeResponseDto s : daydata) {
    		
    		timeval += s.getTimeval() + ",";
    		dayflag += "'" + s.getDayflag() + "',";
    		
    		totalval += Double.valueOf(s.getTimeval());
    	}
    	
    	model.addAttribute("timeval", timeval);
    	model.addAttribute("dayflag", dayflag);
    	model.addAttribute("totalval", totalval);

    	
    	System.out.println("timeval >> " + timeval);
    	System.out.println("dayflag >> " + dayflag);
    	System.out.println("totalval >> " + totalval);
    	
    	return "monitoring/livemonitoring";
    }
    
    @GetMapping("/statistics/statistics")
    public String statistics(Model model, StatsdataSearchRequestDto statsdataSearchResponseDto){
    	/*ㅇ 문백보건지소 : 0002840
    	ㅇ 광혜원보건지소 : 0004092
    	ㅇ 서울에너지공사 : 0004201
    	ㅇ 신포천변전소 : 0004372*/
    	System.out.println("0002840");
    	
    	int min = 0;
    	int max = 0;
    	int randomNum = 0;
    	
    	max = 1320;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0002840"); //1320
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	List<StatsdataMainResponseDto> statsdataMainResponseDto1 = statsdataService.getStatisticsList(statsdataSearchResponseDto);
    	model.addAttribute("rstStats1", statsdataMainResponseDto1.get(0));

    	max = 1323;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0004092"); // 1323
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	List<StatsdataMainResponseDto> statsdataMainResponseDto2 = statsdataService.getStatisticsList(statsdataSearchResponseDto);
    	model.addAttribute("rstStats2", statsdataMainResponseDto2.get(0));
    	
    	max = 1347;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0004201"); //1347
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	List<StatsdataMainResponseDto> statsdataMainResponseDto3 = statsdataService.getStatisticsList(statsdataSearchResponseDto);
    	model.addAttribute("rstStats3", statsdataMainResponseDto3.get(0));
    	
    	max = 1360;
    	randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    	statsdataSearchResponseDto.setUserid("0004372");//1360
    	statsdataSearchResponseDto.setOffset((long) randomNum);
    	List<StatsdataMainResponseDto> statsdataMainResponseDto4 = statsdataService.getStatisticsList(statsdataSearchResponseDto);
    	model.addAttribute("rstStats4", statsdataMainResponseDto4.get(0));
    	
    	return "statistics/statistics";
    }
    
    @GetMapping("/maintenance/eventmanage")
    public String eventmanage(Model model, EventmanageSearchRequestDto eventmanageSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	
    	Page<EventmanageMainResponseDto> eventmanageMainResponseDto = eventmanageService.getEventmanageListByQueryDSL(eventmanageSearchResponseDto, pageable);
    	
    	model.addAttribute("search", eventmanageSearchResponseDto);
    	model.addAttribute("dataList", eventmanageMainResponseDto);
    	
    	model.addAttribute("currentPage", pageable.getPageNumber()+1);
    	model.addAttribute("countPerPageGroup",pageable.getPageSize());
    	model.addAttribute("totlalCount", eventmanageMainResponseDto.getTotalElements());
    	model.addAttribute("totlalPageCount", eventmanageMainResponseDto.getTotalPages());
    	
    	return "maintenance/eventmanage";
    }
    
    @GetMapping("/maintenance/eventhistory")
    public String eventhistory(Model model, EventhistorySearchRequestDto eventhistorySearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	String cYear = eventhistorySearchResponseDto.getCYear();
    	String cMonth = eventhistorySearchResponseDto.getCMonth();
    	
    	if(cYear == null || cYear.equals("")) {
    		cYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    		eventhistorySearchResponseDto.setCYear(cYear);
    	} 
    	if(cMonth == null || cMonth.equals("")) {
    		cMonth = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
    		eventhistorySearchResponseDto.setCMonth(addZero(cMonth));
    	} 
    	    	 
    	
    	/*Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, Integer.valueOf(cYear)); 
    	cal.set(Calendar.MONTH, Integer.valueOf(cMonth)-1); 
    	String pYear = String.valueOf(cal.get(Calendar.YEAR));
    	String pMonth = String.valueOf(cal.get(Calendar.MONTH));*/

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(cYear);
		int month = Integer.parseInt(cMonth);
		cal.set(year, month - 1, 0);
		String pYear = dateFormat.format(cal.getTime()).substring(0,4); 
		String pMonth = dateFormat.format(cal.getTime()).substring(4,6);
		
		cal.set(year, month + 1, 0);
		String nYear = dateFormat.format(cal.getTime()).substring(0,4); 
		String nMonth = dateFormat.format(cal.getTime()).substring(4,6); 
		
		eventhistorySearchResponseDto.setPYear(pYear);
		eventhistorySearchResponseDto.setPMonth(pMonth);
		eventhistorySearchResponseDto.setNYear(nYear);
		eventhistorySearchResponseDto.setNMonth(nMonth);
		
		System.out.println("이전년도 : " + pYear);
		System.out.println("이전월 : " + pMonth);
		System.out.println("다음년도 : " + nYear);
		System.out.println("다음월 : " + nMonth);
        
    	List<EventhistoryMainResponseDto> eventhistoryMainResponseDto = eventhistoryService.getEventhistoryListByQueryDSL(eventhistorySearchResponseDto);
    	
    	model.addAttribute("search", eventhistorySearchResponseDto);
    	model.addAttribute("dataList", eventhistoryMainResponseDto);
    	
    	return "maintenance/eventhistory";
    }
    
    @GetMapping("/environment/routinecheck")
    public String routinecheck(Model model, RoutinecheckSearchRequestDto routinecheckSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	
    	Page<RoutinecheckMainResponseDto> routinecheckMainResponseDto = routineCheckService.getRoutinecheckListByQueryDSL(routinecheckSearchResponseDto, pageable);

    	model.addAttribute("search", routinecheckSearchResponseDto);
    	model.addAttribute("dataList", routinecheckMainResponseDto);
    	
    	model.addAttribute("currentPage", pageable.getPageNumber()+1);
    	model.addAttribute("countPerPageGroup",pageable.getPageSize());
    	model.addAttribute("totlalCount", routinecheckMainResponseDto.getTotalElements());
    	model.addAttribute("totlalPageCount", routinecheckMainResponseDto.getTotalPages());
    	
    	return "environment/routinecheck";
    }
    
    
    @GetMapping("/environment/userinfo")
    public String userinfo(Model model, UserinfoSearchRequestDto userinfoSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	
    	Page<UserinfoMainResponseDto> userinfoMainResponseDto = userinfoService.getUserinfoListByQueryDSL(userinfoSearchResponseDto, pageable);
    	
    	model.addAttribute("search", userinfoSearchResponseDto);
    	model.addAttribute("dataList", userinfoMainResponseDto);
    	
    	model.addAttribute("currentPage", pageable.getPageNumber()+1);
    	model.addAttribute("countPerPageGroup",pageable.getPageSize());
    	model.addAttribute("totlalCount", userinfoMainResponseDto.getTotalElements());
    	model.addAttribute("totlalPageCount", userinfoMainResponseDto.getTotalPages());
    	
    	return "environment/userinfo";
    }

    
    @GetMapping("/environment/equipmentinfo")
    public String equipmentinfo(Model model, EquipmentinfoSearchRequestDto equipmentinfoSearchResponseDto, @PageableDefault(sort = { "id" }, direction = Direction.DESC, page=0, size = 10) Pageable pageable){
    	
    	Page<EquipmentinfoMainResponseDto> equipmentinfoMainResponseDto = equipmentinfoService.getEquipmentinfoListByQueryDSL(equipmentinfoSearchResponseDto, pageable);
    	
    	model.addAttribute("search", equipmentinfoSearchResponseDto);
    	model.addAttribute("dataList", equipmentinfoMainResponseDto);
    	
    	model.addAttribute("currentPage", pageable.getPageNumber()+1);
    	model.addAttribute("countPerPageGroup",pageable.getPageSize());
    	model.addAttribute("totlalCount", equipmentinfoMainResponseDto.getTotalElements());
    	model.addAttribute("totlalPageCount", equipmentinfoMainResponseDto.getTotalPages());
    	
    	return "environment/equipmentinfo";
    }
    
    
    @GetMapping("/environment/login")
    public String login(){
    	return "environment/login";
    }
    
	public static String addZero(String str) {
	    if(str.length() == 1) {
	    	str = "0" + str;
	    }
	    return str;
	}
    
}