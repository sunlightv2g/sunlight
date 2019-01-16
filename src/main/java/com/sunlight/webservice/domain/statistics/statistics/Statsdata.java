package com.sunlight.webservice.domain.statistics.statistics;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
//@Table(name="sunlightdata")
public class Statsdata implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private long id;

    @Column(length = 50, nullable = true)
    private String userid;	// A상 전압

    @Column
    private double avoltage;	// A상 전압
    
    @Column
    private double acurrent;	// A상 전류
    
   /* @Transient
    private double aelectric;	// A상 전력
*/    
    @Column
    private double bvoltage;	// B상 전압
    
    @Column
    private double bcurrent;	// B상 전류
    
  /*  @Transient
    private double belectric;	// B상 전력
*/
    @Column
    private double cvoltage;	// C상 전압
    
    @Column
    private double ccurrent;	// C상 전류
    
   /* @Transient
    private double celectric;	// C상 전력
*/
    @Column
    private int rssi1;	// S1 전압
    
    @Column
    private int temperature1;	// S1 전류
    
    @Column
    private int voltage1;	// S1 조도
    
    @Column
    private int illumination1;	// S1 온도
    
    @Builder
    public Statsdata(long id, String userid, double avoltage, double acurrent, double bvoltage, double bcurrent, double cvoltage, double ccurrent, int rssi1, int temperature1, int voltage1, int illumination1) {
    	this.id = id;
    	this.userid = userid;
    	this.avoltage = avoltage;
        this.acurrent = acurrent;
        this.bvoltage = bvoltage;
        this.bcurrent = bcurrent;
        this.cvoltage = cvoltage;
        this.ccurrent = ccurrent;
        this.rssi1 = rssi1;
        this.temperature1 = temperature1;
        this.voltage1 = voltage1;
        this.illumination1 = illumination1;
    }
    
    private double getElectric(double dble, double voltage, double current) {
    	return dble * voltage * current;
    }
    
}
