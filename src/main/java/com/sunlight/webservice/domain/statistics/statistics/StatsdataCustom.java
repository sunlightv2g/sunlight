package com.sunlight.webservice.domain.statistics.statistics;

import java.util.List;

import com.sunlight.webservice.dto.statistics.statistics.StatsdataMainResponseDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataSearchRequestDto;
import com.sunlight.webservice.dto.statistics.statistics.StatsdataTimeResponseDto;

public interface StatsdataCustom {

	List<StatsdataMainResponseDto> getStatisticsByQuerydsl(StatsdataSearchRequestDto statisticsSearchRequestDto);
	
	List<StatsdataMainResponseDto> getStatisticsList(StatsdataSearchRequestDto statisticsSearchRequestDto);

	String getStatisticsTotalByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto);
	
	List<StatsdataTimeResponseDto> getStatisticsTimeByQuerydsl(StatsdataSearchRequestDto statsdataSearchRequestDto);

}
