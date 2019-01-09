package com.sunlight.webservice.domain.environment.routine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutinecheckRepository extends JpaRepository<Routinecheck, Long>, RoutinecheckCustom {
	
/*	@Query("SELECT p " +
            "FROM Routinecheck p " +
            "ORDER BY p.id DESC")
    Stream<Routinecheck> findAllDesc();*/
	
	Routinecheck findByContent(String content);
	
}