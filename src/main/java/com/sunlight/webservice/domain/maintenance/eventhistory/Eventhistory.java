package com.sunlight.webservice.domain.maintenance.eventhistory;

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
public class Eventhistory extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String workdate;
    
    @Column(length = 255, nullable = false)
    private String equipment;
    
    @Column(length = 255, nullable = false)
    private String author;
    
    @Column(length = 255, nullable = false)
    private String worker;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String result;

    @Column(length = 255, nullable = true)
    private String remark;
    

    @Builder
    public Eventhistory(String workdate, String equipment, String author, String worker, String content, String result, String remark) {
    	this.workdate = workdate;
    	this.equipment = equipment;
        this.author = author;
        this.worker = worker;
        this.content = content;
        this.result = result;
        this.remark = remark;
    }
}
