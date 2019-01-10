package com.sunlight.webservice.domain.maintenance.eventmanage;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import com.sunlight.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Eventmanage extends BaseTimeEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Long id;
    
    @CreatedDate
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime eventdate;
    
    @CreatedDate
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime recoverdate;
    
    @Column(length = 255, nullable = false)
    private String equipment;
    
    @Column(length = 255, nullable = false)
    private String reason;
    
    @Column(length = 255, nullable = false)
    private String actiondetail;
    
    @Column(length = 255, nullable = false)
    private String worker;

    @Builder
    public Eventmanage(LocalDateTime eventdate, LocalDateTime recoverdate, String equipment, String reason, String actiondetail, String worker) {
    	this.eventdate = eventdate;
        this.recoverdate = recoverdate;
        this.equipment = equipment;
        this.reason = reason;
        this.actiondetail = actiondetail;
        this.worker = worker;
    }
}
