package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data

@Entity
@Table(name="booking_status")
public class BookingStatus implements Serializable{
	@Id
	@Column(name="ticket_id")
	private int ticketId;
	@Column
	private int id;
	@Column(name="flight_id")
	private int flightId;
	@Column(name="no_of_seats_booked")
	private int noofseatsbooked;
	private FlightDetails flightDetails;
	private AirlineUsers airlineUsers;
	

}
