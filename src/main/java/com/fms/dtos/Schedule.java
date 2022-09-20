package com.fms.dtos;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "schedules")
public class Schedule {
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(@NotEmpty BigInteger scheduleId, @NotEmpty Airport srcAirport, @NotEmpty Airport dstnAirport,
			@FutureOrPresent LocalDateTime deptDateTime, @FutureOrPresent LocalDateTime arrDateTime) {
		super();
		this.scheduleId = scheduleId;
		this.srcAirport = srcAirport;
		this.dstnAirport = dstnAirport;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotEmpty
	public BigInteger scheduleId;

	@OneToOne(fetch = FetchType.EAGER,cascade =  CascadeType.MERGE)
	@NotEmpty
	public Airport srcAirport;

	@OneToOne(fetch = FetchType.EAGER,cascade =  CascadeType.MERGE)
	@NotEmpty
	public Airport dstnAirport;

	@FutureOrPresent
	public LocalDateTime deptDateTime;

	@FutureOrPresent
	public LocalDateTime arrDateTime;
	

	public BigInteger getScheduleId() {
		return scheduleId;
	}

	public void ScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Airport getSrcAirport() {
		return srcAirport;
	}

	public void setSrcAirport(Airport srcAirport) {
		this.srcAirport = srcAirport;
	}

	public Airport getDstnAirport() {
		return dstnAirport;
	}

	public void setDstnAirport(Airport dstnAirport) {
		this.dstnAirport = dstnAirport;
	}

	public LocalDateTime getDeptDateTime() {
		return deptDateTime;
	}

	public void setDeptDateTime(LocalDateTime deptDateTime) {
		this.deptDateTime = deptDateTime;
	}

	public LocalDateTime getArrDateTime() {
		return arrDateTime;
	}

	public void setArrDateTime(LocalDateTime arrDateTime) {
		this.arrDateTime = arrDateTime;
	}

}