package com.sunlight.webservice.dto.environment.userinfo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserinfoSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
    
	private String userid;
    private String searchFlag;
    private String searchStr;

    
}