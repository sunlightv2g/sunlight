package com.sunlight.webservice.dto.maintenance.eventhistory;

import java.io.Serializable;

import com.sunlight.webservice.domain.maintenance.eventhistory.Eventhistory;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventhistorySaveRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String workdate;
    private String equipment;
    private String author;
    private String worker;
    private String content;
    private String result;
    private String remark;

    @Builder
    public EventhistorySaveRequestDto(long id, String workdate, String equipment, String author, String worker, String content, String result, String remark) {
    	this.id = id;
    	this.workdate = workdate;
        this.equipment = equipment;
        this.author = author;
        this.worker = worker;
        this.content = content;
        this.result = result;
        this.remark = remark;
    }
    
    public Eventhistory toEntity(){
        return Eventhistory.builder()
        		.id(id)
        		.workdate(workdate)
        		.equipment(equipment)
        		.author(author)
        		.worker(worker)
        		.content(content)
        		.result(result)
                .remark(remark)
                .build();
    }
}