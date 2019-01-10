package com.sunlight.webservice.domain.maintenance.eventmanage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventmanageRepository extends JpaRepository<Eventmanage, Long>, EventmanageCustom {
	
	
}