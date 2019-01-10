package com.sunlight.webservice.domain.maintenance.eventmanage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageSearchRequestDto;

public interface EventmanageCustom {

    Page<EventmanageMainResponseDto> getEventmanageList(EventmanageSearchRequestDto eventmanageSearchResponseDto, Pageable pageable);
}
