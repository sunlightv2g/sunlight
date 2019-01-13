package com.sunlight.webservice.domain.maintenance.eventhistory;

import java.util.List;

import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistoryMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySearchRequestDto;

public interface EventhistoryCustom {

	EventhistoryMainResponseDto getEventhistoryByQuerydsl(Long id);
    List<EventhistoryMainResponseDto> getEventhistoryList(EventhistorySearchRequestDto eventhistorySearchResponseDto);
	long update(Eventhistory entity);    	
}
