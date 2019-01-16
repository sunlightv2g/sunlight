package com.sunlight.webservice.dto.statistics.statistics;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsdataSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private Long offset;
    private String userid;
	
}