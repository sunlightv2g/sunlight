package com.sunlight.webservice.dto.environment.userinfo;

import java.io.Serializable;

import com.sunlight.webservice.domain.environment.userinfo.Userinfo;

import lombok.Getter;

@Getter
public class UserinfoMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String userid;
    private String username;
    private String userrole;
    private String userpart;
    private String userhp;
    private String usertel;
    private String useremail;
    private String usersms;

    public UserinfoMainResponseDto(Userinfo entity) {
        id = entity.getId();
        userid = entity.getUserid();
        username = entity.getUsername();
        userrole = entity.getUserrole();
        userpart = entity.getUserpart();
        userhp = entity.getUserhp();
        usertel = entity.getUsertel();
        usersms = entity.getUsersms();
    }
    
}