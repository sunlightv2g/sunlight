package com.sunlight.webservice.dto.environment.equipmentinfo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentinfoSearchRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private String searchFirst;
    private String searchSecond;
    private String searchStr;
    private String searchDate;
	
}