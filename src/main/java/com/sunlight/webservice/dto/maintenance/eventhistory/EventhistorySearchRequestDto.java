package com.sunlight.webservice.dto.maintenance.eventhistory;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventhistorySearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String cYear;
    private String cMonth;
    
    private String pYear;
    private String pMonth;
    private String nYear;
    private String nMonth;
	
}