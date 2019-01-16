package com.sunlight.webservice.domain.maintenance.eventcondition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionSearchRequestDto;

public interface EventconditionCustom {
	
	Page<EventconditionMainResponseDto> getEventconditionList(EventconditionSearchRequestDto eventconditionSearchRequestDto, Pageable pageable);
}
