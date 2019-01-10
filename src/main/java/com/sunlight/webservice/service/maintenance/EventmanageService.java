package com.sunlight.webservice.service.maintenance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.maintenance.eventmanage.EventmanageRepository;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventmanage.EventmanageSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EventmanageService {
    private EventmanageRepository eventmanageRepository;
    
    @Transactional(readOnly = true)
    public Page<EventmanageMainResponseDto> getEventmanageListByQueryDSL(EventmanageSearchRequestDto eventmanageSearchResponseDto, Pageable pageable) {
        return eventmanageRepository.getEventmanageList(eventmanageSearchResponseDto, pageable);
    }
    
}