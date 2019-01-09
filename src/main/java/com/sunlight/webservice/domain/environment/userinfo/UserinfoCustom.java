package com.sunlight.webservice.domain.environment.userinfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunlight.webservice.dto.environment.userinfo.UserinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSearchRequestDto;

public interface UserinfoCustom {
    Page<UserinfoMainResponseDto> getUserinfoList(UserinfoSearchRequestDto userinfoSearchResponseDto, Pageable pageable);
    long getUserinfoByQuerydsl(String userid);
    long getUserinfoByQuerydsl(String userid, String userpass);
	long update(Userinfo entity);
}