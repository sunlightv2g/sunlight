package com.sunlight.webservice.domain.environment.equipmentinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentinfoRepository extends JpaRepository<Equipmentinfo, Long>, EquipmentinfoCustom {
	
}