package com.sunlight.webservice.domain.statistics.statistics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsdataRepository extends JpaRepository<Statsdata, Long>, StatsdataCustom {
	

}