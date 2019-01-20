package com.sunlight.webservice.web;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunlight.webservice.domain.maintenance.eventhistory.Eventhistory;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckSaveRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSaveRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySaveRequestDto;
import com.sunlight.webservice.dto.posts.PostsSaveRequestDto;
import com.sunlight.webservice.service.environment.RoutinecheckService;
import com.sunlight.webservice.service.environment.UserinfoService;
import com.sunlight.webservice.service.maintenance.EventhistoryService;
import com.sunlight.webservice.service.posts.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;
	private RoutinecheckService routinecheckService;
	private UserinfoService userinfoService;
	private EventhistoryService eventhistoryService;
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
        		.skip(1)
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
    
    @PutMapping("/environment/routinecheck")
    public void routinecheckUpdate(@RequestBody RoutinecheckSaveRequestDto dto){
    	routinecheckService.update(dto);	
    }
    
    @DeleteMapping("/environment/routinecheck/{id}")
    @ResponseBody
    public void routinecheckDelete(@PathVariable long id) {
    	routinecheckService.getRoutinecheckDelete(id);
    }
    
    @GetMapping("/maintenance/eventhistory/{id}")
    @ResponseBody
    public Eventhistory eventhistoryFindOne(@PathVariable long id) {
        return eventhistoryService.getEventhistoryByQueryDSL(id);
    }
    
    @DeleteMapping("/maintenance/eventhistory/{id}")
    @ResponseBody
    public void eventhistoryDelete(@PathVariable long id) {
    	System.out.println("삭제 : id : " + id);
    	eventhistoryService.getEventhistoryDelete(id);
    }
    
    @PostMapping("/maintenance/eventhistory")
    public void eventhistorySave(@RequestBody EventhistorySaveRequestDto dto){
    	eventhistoryService.save(dto);	
    }
    
    @PutMapping("/maintenance/eventhistory")
    public void eventhistoryUpdate(@RequestBody EventhistorySaveRequestDto dto){
    	eventhistoryService.update(dto);	
    }
    
    @PostMapping("/environment/userinfo")
    public void userinfoSave(@RequestBody UserinfoSaveRequestDto dto){
    	userinfoService.save(dto);	
    }
    
    @DeleteMapping("/environment/userinfo/{id}")
    @ResponseBody
    public void userinfoDelete(@PathVariable long id) {
    	userinfoService.getUserinfoDelete(id);
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
