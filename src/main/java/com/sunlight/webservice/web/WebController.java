package com.sunlight.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunlight.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;
	
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
    
    @GetMapping("/environment/routineinspection")
    public String routineinspection(){
    	return "environment/routineinspection";
    }
    
    @GetMapping("/environment/equipmentinfo")
    public String equipmentinfo(){
    	return "environment/equipmentinfo";
    }
    
    @GetMapping("/environment/userinfo")
    public String userinfo(){
        return "environment/userinfo";
    }
    
    
}