package com.sunlight.webservice.domain.environment.userinfo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sunlight.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Userinfo extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String userid;
    
    @Column(length = 255, nullable = false)
    private String userpass;
    
    @Column(length = 255, nullable = false)
    private String username;
    
    @Column(length = 255, nullable = true)
    private String userrole;
    
    @Column(length = 255, nullable = true)
    private String userpart;
    
    @Column(length = 255, nullable = true)
    private String userhp;
    
    @Column(length = 255, nullable = true)
    private String usertel;
    
    @Column(length = 255, nullable = true)
    private String useremail;
    
    @Column(length = 255, nullable = true)
    private String usersms;
    
    @Builder
    public Userinfo(long id, String userid, String userpass, String username, String userrole, String userpart, String userhp, String usertel, String useremail, String usersms) {
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
}