package com.sunlight.webservice.service.maintenance;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.maintenance.eventhistory.EventhistoryRepository;
import com.sunlight.webservice.dto.environment.userinfo.UserinfoSaveRequestDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistoryMainResponseDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySaveRequestDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EventhistoryService {
    private EventhistoryRepository eventhistoryRepository;

    @Transactional
    public Long save(EventhistorySaveRequestDto dto){
        return eventhistoryRepository.save(dto.toEntity()).getId();
    }
    
    @Transactional
    public long update(EventhistorySaveRequestDto dto){
    	return eventhistoryRepository.update(dto.toEntity());
    }
    
    @Transactional(readOnly = true)
    public EventhistoryMainResponseDto getEventhistoryByQueryDSL(Long id) {
        return eventhistoryRepository.getEventhistoryByQuerydsl(id);
    }
    
    @Transactional(readOnly = true)
    public List<EventhistoryMainResponseDto> getEventhistoryListByQueryDSL(EventhistorySearchRequestDto eventhistorySearchResponseDto) {
        return eventhistoryRepository.getEventhistoryList(eventhistorySearchResponseDto);
    }
    
}