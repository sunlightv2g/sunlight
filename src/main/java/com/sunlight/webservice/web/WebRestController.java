package com.sunlight.webservice.web;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunlight.webservice.dto.environment.routine.RoutinecheckSaveRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSaveRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.sunlight.webservice.dto.posts.PostsSaveRequestDto;
import com.sunlight.webservice.service.environment.RoutinecheckService;
import com.sunlight.webservice.service.environment.UserinfoService;
import com.sunlight.webservice.service.posts.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;
	private RoutinecheckService routinecheckService;
	private UserinfoService userinfoService;
	private Environment env;

	@GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
    	postsService.save(dto);
    }
    
    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
    
/*    @PostMapping("/environment/routinechecklist")
    public ResponseEntity<List<RoutinecheckMainResponseDto>> routinecheckList(Model model){
    	List<RoutinecheckMainResponseDto> resultDto = routinecheckService.findAllDesc();
    	return new ResponseEntity<List<RoutinecheckMainResponseDto>>(resultDto, HttpStatus.OK);
    }*/
    
    @PostMapping("/environment/routinecheck")
    public void routinecheckSave(@RequestBody RoutinecheckSaveRequestDto dto){
		routinecheckService.save(dto);	
    }
    
    @PostMapping("/environment/userinfo")
    public void userinfoSave(@RequestBody UserinfoSaveRequestDto dto){
    	userinfoService.save(dto);	
    }
    
    @PutMapping("/environment/userinfo")
    public void userinfoUpdate(@RequestBody UserinfoSaveRequestDto dto){
    	userinfoService.update(dto);	
    }
    
    @PostMapping("/environment/useridchk")
    public long useridchk(@RequestBody UserinfoSearchRequestDto dto){
    	System.out.println("dto : " + dto.getUserid());
    	long rstCnt = userinfoService.getUserinfo(dto.getUserid());
//    	System.out.println("resultDto : " + resultDto.getUserid());
    	return rstCnt;
    }
        
    @PostMapping("/environment/userlogin")
    public long userlogin(HttpServletRequest request,@RequestBody UserinfoSaveRequestDto dto){
    	HttpSession httpSession = request.getSession(true);
    	System.out.println("dto : " + dto.getUserid());
    	long rstCnt = userinfoService.getUserinfo(dto.getUserid(),dto.getUserpass());
    	if(rstCnt > 0) {
    		 
    		 httpSession.setAttribute("USEID", dto.getUserid());
    	}
    	System.out.println("rstCnt : " + rstCnt);
    	System.out.println("httpSession USEID : " + httpSession.getAttribute("USEID"));
    	return rstCnt;
    }
    
    
    @PostMapping("/environment/userlogout")
    public long userlogout(HttpServletRequest request){
    	HttpSession httpSession = request.getSession(true);
    	httpSession.setAttribute("USEID", "");
    	httpSession.invalidate();
    	return 0;
    }
    
}
