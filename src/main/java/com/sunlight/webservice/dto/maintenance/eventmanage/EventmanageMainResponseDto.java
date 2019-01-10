package com.sunlight.webservice.dto.maintenance.eventmanage;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sunlight.webservice.domain.maintenance.eventmanage.Eventmanage;

import lombok.Getter;

@Getter
public class EventmanageMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String eventdate;
    private String recoverdate;
    private String equipment;
    private String reason;
    private String actiondetail;
    private String worker;

    public EventmanageMainResponseDto(Eventmanage entity) {
        id = entity.getId();
        eventdate = toStringDateTime(entity.getEventdate());
        recoverdate = toStringDateTime(entity.getRecoverdate());
        equipment = entity.getEquipment();
        reason = entity.getReason();
        actiondetail = entity.getActiondetail();
        worker = entity.getWorker();
    }
    
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}