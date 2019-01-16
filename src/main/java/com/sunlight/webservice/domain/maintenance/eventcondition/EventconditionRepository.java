package com.sunlight.webservice.domain.maintenance.eventcondition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventconditionRepository extends JpaRepository<Eventcondition, Long>, EventconditionCustom {
	
}