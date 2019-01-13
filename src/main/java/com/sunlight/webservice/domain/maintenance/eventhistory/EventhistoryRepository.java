package com.sunlight.webservice.domain.maintenance.eventhistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventhistoryRepository extends JpaRepository<Eventhistory, Long>, EventhistoryCustom {
	
/*	@Query("SELECT p " +
            "FROM Eventhistory p " +
            "ORDER BY p.id DESC")
    Stream<Eventhistory> findAllDesc();*/
	
	Eventhistory findByContent(String content);
	
}