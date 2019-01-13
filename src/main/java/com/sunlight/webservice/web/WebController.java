package com.sunlight.webservice.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistoryMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySearchRequestDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageSearchRequestDto;
import com.sunlight.webservice.service.environment.EquipmentinfoService;
import com.sunlight.webservice.service.environment.RoutinecheckService;
import com.sunlight.webservice.service.environment.UserinfoService;
import com.sunlight.webservice.service.maintenance.EventhistoryService;
import com.sunlight.webservice.service.maintenance.EventmanageService;
import com.sunlight.webservice.service.posts.PostsService;

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
	
    @GetMapping("/")
    public String main(Model model) {
    	model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
    

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    
    @GetMapping("/monitoring/livemonitoring")
    public String livemonitoring(){
    	return "monitoring/livemonitoring";
    }
    
    @GetMapping("/statistics/statistics")
    public String statistics(){
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