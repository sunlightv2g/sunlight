package com.sunlight.webservice.domain.environment.equipmentinfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoSearchRequestDto;

public interface EquipmentinfoCustom {

/*	EquipmentinfoMainResponseDto getEquipmentinfoByQuerydsl(Long id);*/
    Page<EquipmentinfoMainResponseDto> getEquipmentinfoList(EquipmentinfoSearchRequestDto equipmentinfocheckSearchResponseDto, Pageable pageable);
}
