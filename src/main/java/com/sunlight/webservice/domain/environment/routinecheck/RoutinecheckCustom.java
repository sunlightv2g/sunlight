package com.sunlight.webservice.domain.environment.routinecheck;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunlight.webservice.domain.maintenance.eventhistory.Eventhistory;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckMainResponseDto;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckSearchRequestDto;

public interface RoutinecheckCustom {

	RoutinecheckMainResponseDto getRoutinecheckByQuerydsl(Long id);
    Page<RoutinecheckMainResponseDto> getRoutinecheckList(RoutinecheckSearchRequestDto routinecheckSearchResponseDto, Pageable pageable);
    long update(Routinecheck entity);    
}
