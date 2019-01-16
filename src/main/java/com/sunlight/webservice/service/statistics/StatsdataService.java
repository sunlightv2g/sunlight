package com.sunlight.webservice.service.statistics;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.statistics.statistics.StatsdataRepository;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataMainResponseDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataSearchRequestDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataTimeResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StatsdataService {
    private StatsdataRepository statisticsRepository;
    
    
    @Transactional(readOnly = true)
    public List<StatsdataMainResponseDto> getStatisticsByQueryDSL(StatsdataSearchRequestDto statisticsSearchRequestDto) {
        return statisticsRepository.getStatisticsByQuerydsl(statisticsSearchRequestDto);
    }
    
    @Transactional(readOnly = true)
    public List<StatsdataMainResponseDto> getStatisticsList(StatsdataSearchRequestDto statisticsSearchRequestDto) {
    	return statisticsRepository.getStatisticsList(statisticsSearchRequestDto);
    }
    
    @Transactional(readOnly = true)
    public String getStatisticsTotalByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto) {
    	return statisticsRepository.getStatisticsTotalByQuerydsl(statsdataSearchRequestDto);
    }
    
    @Transactional(readOnly = true)
    public List<StatsdataTimeResponseDto> getStatisticsTimeByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto) {
    	return statisticsRepository.getStatisticsTimeByQuerydsl(statsdataSearchRequestDto);
    }
    
}