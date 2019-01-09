package com.sunlight.webservice.domain.environment.userinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long>, UserinfoCustom {

}