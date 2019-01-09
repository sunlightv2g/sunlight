package com.sunlight.webservice.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoSearchRequestDto;
import com.sunlight.webservice.dto.environment.routine.RoutinecheckMainResponseDto;
import com.sunlight.webservice.dto.environment.routine.RoutinecheckSearchRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.sunlight.webservice.service.environment.EquipmentinfoService;
import com.sunlight.webservice.service.environment.RoutinecheckService;
import com.sunlight.webservice.service.environment.UserinfoService;
import com.sunlight.webservice.service.posts.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;
	private RoutinecheckService routineCheckService;
	private UserinfoService userinfoService;
	private EquipmentinfoService equipmentinfoService;
	
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
    
    @GetMapping("/maintenance/eventmanage")
    public String eventmanage(){
    	return "maintenance/eventmanage";
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
    
    
}