package com.sunlight.webservice.dto.environment.routinecheck;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoutinecheckSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String equipment;
    private String startDate;
    private String endDate;
	
}