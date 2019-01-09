package com.sunlight.webservice.service.environment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunlight.webservice.domain.environment.equipmentinfo.EquipmentinfoRepository;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoMainResponseDto;
import com.sunlight.webservice.dto.environment.equipmentinfo.EquipmentinfoSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EquipmentinfoService {
    private EquipmentinfoRepository equipmentinfoRepository;

/*    @Transactional
    public Long save(EquipmentinfoSaveRequestDto dto){
        return equipmentinfoRepository.save(dto.toEntity()).getId();
    }
    */
    /*@Transactional(readOnly = true)
    public List<EquipmentinfoMainResponseDto> findAllDesc() {
        return equipmentinfoRepository.findAllDesc()
                .map(EquipmentinfoMainResponseDto::new)
                .collect(Collectors.toList());
    }*/
    
/*    public Page<EquipmentinfoMainResponseDto>  getEquipmentinfoByQueryDSL(Pageable pageable) {
        return equipmentinfoRepository.getUserList(pageable);
    }*/
    
/*    @Transactional(readOnly = true)
    public EquipmentinfoMainResponseDto getEquipmentinfoByQueryDSL(Long id) {
        return equipmentinfoRepository.getEquipmentinfoByQuerydsl(id);
    }*/
    
    @Transactional(readOnly = true)
    public Page<EquipmentinfoMainResponseDto> getEquipmentinfoListByQueryDSL(EquipmentinfoSearchRequestDto equipmentinfoSearchResponseDto, Pageable pageable) {
        return equipmentinfoRepository.getEquipmentinfoList(equipmentinfoSearchResponseDto, pageable);
    }
    
}