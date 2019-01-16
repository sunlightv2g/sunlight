package com.sunlight.webservice.dto.maintenance.eventcondition;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sunlight.webservice.domain.maintenance.eventcondition.Eventcondition;

import lombok.Getter;

@Getter
public class EventconditionMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String workdate;
    private String place;
    private String equipment;
    private String flag;
    private String name;
    private String status;

    public EventconditionMainResponseDto(Eventcondition entity) {
        id = entity.getId();
        workdate = entity.getWorkdate();
        place = entity.getPlace();
        equipment = entity.getEquipment();
        flag = entity.getFlag();
        name = entity.getName();
        status = entity.getStatus();
    }
    
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}