package com.sunlight.webservice.dto.environment.routinecheck;

import java.io.Serializable;

import com.sunlight.webservice.domain.environment.routinecheck.Routinecheck;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoutinecheckSaveRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
    private String period;
    private String weektime;
    private String equipment;
    private String worker;
    private String content;
    private String remark;
    private String author;

    @Builder
    public RoutinecheckSaveRequestDto(long id, String period, String weektime, String equipment, String worker, String content, String remark, String author) {
    	this.id = id;
        this.period = period;
        this.weektime = weektime;
        this.equipment = equipment;
        this.worker = worker;
        this.content = content;
        this.remark = remark;
        this.author = author;
    }
    
    public Routinecheck toEntity(){
        return Routinecheck.builder()
        		.id(id)
        		.period(period)
        		.weektime(weektime)
        		.equipment(equipment)
        		.worker(worker)
                .content(content)
                .remark(remark)
                .author(author)
                .build();
    }
}