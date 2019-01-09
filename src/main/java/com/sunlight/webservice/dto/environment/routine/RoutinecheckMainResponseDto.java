package com.sunlight.webservice.dto.environment.routine;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sunlight.webservice.domain.environment.routine.Routinecheck;

import lombok.Getter;

@Getter
public class RoutinecheckMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String period;
    private String weektime;
    private String equipment;
    private String worker;
    private String content;
    private String remark;
    private String author;
    private String modifiedDate;

    public RoutinecheckMainResponseDto(Routinecheck entity) {
        id = entity.getId();
        period = entity.getPeriod();
        weektime = entity.getWeektime();
        equipment = entity.getEquipment();
        worker = entity.getWorker();
        content = entity.getContent();
        remark = entity.getRemark();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }
    
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}