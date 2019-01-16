package com.sunlight.webservice.dto.statistics.statistics;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsdataTimeResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String timeval;
	
    private String dayflag;

    
}