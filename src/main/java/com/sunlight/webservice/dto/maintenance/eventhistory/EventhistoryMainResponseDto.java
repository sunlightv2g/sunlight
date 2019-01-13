package com.sunlight.webservice.dto.maintenance.eventhistory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sunlight.webservice.domain.maintenance.eventhistory.Eventhistory;

import lombok.Getter;

@Getter
public class EventhistoryMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String workdate;
    private String equipment;
    private String author;
    private String worker;
    private String content;
    private String result;
    private String remark;
    private String modifiedDate;

    public EventhistoryMainResponseDto(Eventhistory entity) {
        id = entity.getId();
        workdate = entity.getWorkdate();
        equipment = entity.getEquipment();
        author = entity.getAuthor();
        worker = entity.getWorker();
        content = entity.getContent();
        result = entity.getResult();
        remark = entity.getRemark();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }
    
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}