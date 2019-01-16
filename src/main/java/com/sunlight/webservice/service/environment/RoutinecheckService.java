package com.sunlight.webservice.service.environment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.environment.routinecheck.RoutinecheckRepository;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckMainResponseDto;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckSaveRequestDto;
import com.sunlight.webservice.dto.environment.routinecheck.RoutinecheckSearchRequestDto;
import com.sunlight.webservice.dto.maintenance.eventhistory.EventhistorySaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoutinecheckService {
    private RoutinecheckRepository routinecheckRepository;

    @Transactional
    public Long save(RoutinecheckSaveRequestDto dto){
        return routinecheckRepository.save(dto.toEntity()).getId();
    }
    
    /*@Transactional(readOnly = true)
    public List<RoutinecheckMainResponseDto> findAllDesc() {
        return routinecheckRepository.findAllDesc()
                .map(RoutinecheckMainResponseDto::new)
                .collect(Collectors.toList());
    }*/
    
/*    public Page<RoutinecheckMainResponseDto>  getRoutinecheckByQueryDSL(Pageable pageable) {
        return routinecheckRepository.getUserList(pageable);
    }*/
    
    @Transactional(readOnly = true)
    public RoutinecheckMainResponseDto getRoutinecheckByQueryDSL(Long id) {
        return routinecheckRepository.getRoutinecheckByQuerydsl(id);
    }
    
    @Transactional
    public long update(RoutinecheckSaveRequestDto dto){
    	return routinecheckRepository.update(dto.toEntity());
    }
    
    @Transactional
    public void getRoutinecheckDelete(long id) {
    	routinecheckRepository.delete(id);
    }
    
    @Transactional(readOnly = true)
    public Page<RoutinecheckMainResponseDto> getRoutinecheckListByQueryDSL(RoutinecheckSearchRequestDto routinecheckSearchResponseDto, Pageable pageable) {
        return routinecheckRepository.getRoutinecheckList(routinecheckSearchResponseDto, pageable);
    }
    
}