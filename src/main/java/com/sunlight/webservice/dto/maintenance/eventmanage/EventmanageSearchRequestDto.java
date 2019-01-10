package com.sunlight.webservice.dto.maintenance.eventmanage;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventmanageSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String equipment;
    private String startDate;
    private String endDate;
	
}