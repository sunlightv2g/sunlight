package com.sunlight.webservice.service.environment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.environment.userinfo.UserinfoRepository;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSaveRequestDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserinfoService {
    private UserinfoRepository userinfoRepository;

    @Transactional
    public long save(UserinfoSaveRequestDto dto){
        return userinfoRepository.save(dto.toEntity()).getId();
    }
    
    @Transactional
    public long update(UserinfoSaveRequestDto dto){
    	return userinfoRepository.update(dto.toEntity());
    }
   
    @Transactional(readOnly = true)
    public Page<UserinfoMainResponseDto> getUserinfoListByQueryDSL(UserinfoSearchRequestDto userinfoSearchResponseDto, Pageable pageable) {
        return userinfoRepository.getUserinfoList(userinfoSearchResponseDto, pageable);
    }
    
    @Transactional(readOnly = true)
    public long getUserinfo(String userid) {
        return userinfoRepository.getUserinfoByQuerydsl(userid);
    }
    
    
    @Transactional
    public void getUserinfoDelete(long id) {
    	userinfoRepository.delete(id);
    }
    
    @Transactional(readOnly = true)
    public long getUserinfo(String userid,String userpass ) {
    	return userinfoRepository.getUserinfoByQuerydsl(userid, userpass);
    }
    
}