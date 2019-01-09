package com.sunlight.webservice.domain.environment.routine;

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
public class Routinecheck extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String period;
    
    @Column(length = 255, nullable = false)
    private String weektime;
    
    @Column(length = 255, nullable = false)
    private String equipment;
    
    @Column(length = 255, nullable = false)
    private String worker;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 255, nullable = true)
    private String remark;
    
    private String author;

    @Builder
    public Routinecheck(String period, String weektime, String equipment, String worker, String content, String remark, String author) {
    	this.period = period;
        this.weektime = weektime;
        this.equipment = equipment;
        this.worker = worker;
        this.content = content;
        this.remark = remark;
        this.author = author;
    }
}
