package com.sunlight.webservice.dto.environment.userinfo;

import java.io.Serializable;

import com.sunlight.webservice.domain.environment.userinfo.Userinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserinfoSaveRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String userid;
	private String userpass;
	private String username;
	private String userrole;
	private String userpart;
	private String userhp;
	private String usertel;
	private String useremail;
	private String usersms;

    @Builder
    public UserinfoSaveRequestDto(long id, String userid, String userpass, String username, String userrole, String userpart, String userhp, String usertel, String useremail, String usersms) {
    	this.id = id;
    	this.userid = userid;
        this.userpass = userpass;
        this.username = username;
        this.userrole = userrole;
        this.userpart = userpart;
        this.userhp = userhp;
        this.usertel = usertel;
        this.useremail = useremail;
        this.usersms = usersms;
    }
    
    
    public Userinfo toEntity(){
        return Userinfo.builder()
        		.id(id)
        		.userid(userid)
        		.userpass(userpass)
        		.username(username)
        		.userrole(userrole)
                .userpart(userpart)
                .userhp(userhp)
                .usertel(usertel)
                .useremail(useremail)
                .usersms(usersms)
                .build();
    }
}