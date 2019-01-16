package com.sunlight.webservice.domain.maintenance.eventcondition;

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
public class Eventcondition extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private long id;

    @Column(length = 255, nullable = false)
    private String workdate;
    
    @Column(length = 255, nullable = false)
    private String place;
    
    @Column(length = 255, nullable = false)
    private String equipment;
    
    @Column(length = 255, nullable = false)
    private String flag;
    
    @Column(length = 255, nullable = false)
    private String name;
    
    @Column(length = 255, nullable = false)
    private String status;
    
    @Builder
    public Eventcondition(long id, String workdate, String place, String equipment, String flag, String name, String status) {
    	this.id = id;
    	this.workdate = workdate;
    	this.place = place;
    	this.equipment = equipment;
        this.flag = flag;
        this.name = name;
        this.status = status;
    }
}
