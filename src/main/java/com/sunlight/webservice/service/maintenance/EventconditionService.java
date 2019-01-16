package com.sunlight.webservice.service.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.maintenance.eventcondition.EventconditionRepository;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventcondition.EventconditionSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EventconditionService {
    private EventconditionRepository eventconditionRepository;

    @Transactional(readOnly = true)
    public Page<EventconditionMainResponseDto> getEventconditionListByQueryDSL(EventconditionSearchRequestDto eventconditionSearchRequestDto, Pageable pageable) {
        return eventconditionRepository.getEventconditionList(eventconditionSearchRequestDto, pageable);
    }
    
}