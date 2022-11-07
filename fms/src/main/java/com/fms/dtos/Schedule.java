package com.fms.dtos;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "schedules")
public class Schedule {
	@Id
//	@Column(name = "schedule_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@NotEmpty
//	@Digits(integer = 05,fraction = 0, message = "Please provide a 5 digit Schedule ID.")
	private BigInteger scheduleId;

//	@OneToOne(cascade = CascadeType.ALL)
//	private Airport srcAirport;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	private Airport dstnAirport;

	//@OneToOne(fetch = FetchType.EAGER)
//	@JsonIgnore
	@OneToOne
//	@JoinColumn(name = "airport_name")
//	@JoinColumn(name = "airport_code")
//	@NotEmpty
	private Airport srcAirport;

	//@OneToOne(fetch = FetchType.EAGER)
//	@JsonIgnore
	@OneToOne
//	@JoinColumn(name = "airport_name")
//	@JoinColumn(name = "airport_code")
//	@NotEmpty
	private Airport dstnAirport;

//	@Column(name = "departure_date")
	@FutureOrPresent
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private LocalDateTime deptDateTime;

//	@Column(name = "arrival_date")
	@FutureOrPresent
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private LocalDateTime arrDateTime;

	/*
	 * Default constructor
	 */
	public Schedule() {

	}

	/*
	 * Parameterized constructor
	 */
	public Schedule(BigInteger scheduleId, Airport srcAirport, Airport dstnAirport,
			LocalDateTime deptDateTime, LocalDateTime arrDateTime) {
		super();
		this.scheduleId = scheduleId;
		this.srcAirport = srcAirport;
		this.dstnAirport = dstnAirport;
		this.deptDateTime = deptDateTime;
		this.arrDateTime = arrDateTime;
	}

	/*
	 * Getters and setters
	 */
	public BigInteger getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(BigInteger scheduleId) {
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
