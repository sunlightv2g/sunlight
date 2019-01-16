package com.sunlight.webservice.dto.statistics.statistics;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sunlight.webservice.domain.statistics.statistics.Statsdata;

import lombok.Getter;

@Getter
public class StatsdataMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private long id;
    private String userid;
    private double avoltage;
    private double acurrent;
    private double bvoltage;
    private double bcurrent;
    private double cvoltage;
    private double ccurrent;
    private int rssi1;
    private int temperature1;
    private int voltage1;
    private int illumination1;
    

    public StatsdataMainResponseDto(Statsdata entity) {
    	id = entity.getId();
    	userid = entity.getUserid();
    	avoltage = entity.getAvoltage();
    	acurrent = entity.getAcurrent();
    	bvoltage = entity.getBvoltage();
    	bcurrent = entity.getBcurrent();
    	cvoltage = entity.getCvoltage();
    	ccurrent = entity.getCcurrent();
    	rssi1 = entity.getRssi1();
    	temperature1 = entity.getTemperature1();
    	voltage1 = entity.getVoltage1();
    	illumination1 = entity.getIllumination1();
        //modifiedDate = toStringDateTime(entity.getModifiedDate());
    }
    
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    
}