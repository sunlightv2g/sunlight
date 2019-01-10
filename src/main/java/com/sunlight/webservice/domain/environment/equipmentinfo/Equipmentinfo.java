package com.sunlight.webservice.domain.environment.equipmentinfo;

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
public class Equipmentinfo extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String equipment;
    
    @Column(length = 255, nullable = false)
    private String model;
    
    @Column(length = 255, nullable = false)
    private String madeby;
    
    @Column(length = 255, nullable = true)
    private String installaddr;
    
    @Column(length = 255, nullable = true)
    private String installdate;
    
    @Column(length = 255, nullable = true)
    private String remark;
    
    @Builder
    public Equipmentinfo(String equipment, String model, String madeby, String installaddr, String installdate, String remark) {
    	this.equipment = equipment;
        this.model = model;
        this.madeby = madeby;
        this.installaddr = installaddr;
        this.installdate = installdate;
        this.remark = remark;
    }
}