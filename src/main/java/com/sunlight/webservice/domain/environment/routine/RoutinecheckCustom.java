package com.sunlight.webservice.domain.environment.routine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunlight.webservice.dto.environment.routine.RoutinecheckMainResponseDto;
import com.sunlight.webservice.dto.environment.routine.RoutinecheckSearchRequestDto;

public interface RoutinecheckCustom {

	RoutinecheckMainResponseDto getRoutinecheckByQuerydsl(Long id);
    Page<RoutinecheckMainResponseDto> getRoutinecheckList(RoutinecheckSearchRequestDto routinecheckSearchResponseDto, Pageable pageable);
}
