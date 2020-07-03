package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="flight_details")
public class FlightDetails implements Serializable{
	@Id
	@Column(name="flight_id")
	private int flightId;
	@Column(name="flight_name")
	private String flightName;
	@Column
	private String source;
	@Column
	private String destination;
	@Column(name="seats_available")
	private int noofseatsavailable;
	@Column(name="arrival_date")
	private LocalDate arrivalDate;
	@Column(name="arrival_time")
	private LocalTime arrivalTime;
	@Column(name="departure_date")
	private LocalDate departureDate;
	@Column(name="departur_time")
	private LocalTime departureTime;
	
}