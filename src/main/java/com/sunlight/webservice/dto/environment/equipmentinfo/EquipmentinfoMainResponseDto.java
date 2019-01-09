package com.sunlight.webservice.dto.environment.equipmentinfo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.sunlight.webservice.domain.environment.equipmentinfo.Equipmentinfo;

import lombok.Getter;

@Getter
public class EquipmentinfoMainResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String equipment;
    private String model;
    private String madeby;
    private String installaddr;
    private String installdate;
    private String remark;

    public EquipmentinfoMainResponseDto(Equipmentinfo entity) {
        id = entity.getId();
        equipment = entity.getEquipment();
        model = entity.getModel();
        madeby = entity.getMadeby();
        installaddr = entity.getInstalladdr();
        installdate = entity.getInstalldate();
        remark = entity.getRemark();
    }
    
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

}