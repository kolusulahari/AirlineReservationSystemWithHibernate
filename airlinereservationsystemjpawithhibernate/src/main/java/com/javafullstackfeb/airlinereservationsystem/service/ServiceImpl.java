package com.javafullstackfeb.airlinereservationsystem.service;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dao.Dao;
import com.javafullstackfeb.airlinereservationsystem.dto.AirlineUsers;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingStatus;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.factory.AirlineFactory;
import com.javafullstackfeb.airlinereservationsystem.validation.Validations;

public class ServiceImpl implements Service{
	Validations validation = new Validations();
	Dao daoRef = AirlineFactory.getDaoImplInstance();
	
	// ***************************** Admin Operations ********************//
	public boolean addingFlights(FlightDetails flightDetails) {
		if(flightDetails!=null) {
			return daoRef.addingFlights(flightDetails);
			}
			throw new AirlineException("Enter Correct details");
			
	}
	public boolean deletingFlight(int flightId) {
		if (validation.idValidation(flightId)) {
			return daoRef.deletingFlight(flightId);
		}
		return false;
	}
	public List<FlightDetails> getFlightDetails() {
		return daoRef.getFlightDetails();
	}
	public List<BookingStatus> bookingStatus() {
		return daoRef.bookingStatus();
	}

	//************************* User Operations *************************//

	public List<FlightDetails> searchFlightByNameInUser(String flightname) {
		if (validation.nameValidation(flightname)) {
			return daoRef.searchFlightByNameInUser(flightname);
		}
		return null;
	}
	public List<FlightDetails> searchFlightBySourceInUser(String source) {
		if (validation.sourceValidation(source)) {
			return daoRef.searchFlightBySourceInUser(source);
		}
		return null;
	}
	public List<FlightDetails> searchFlightByDestinationInUser(String destination) {
		if (validation.destinationValidation(destination)) {
			return daoRef.searchFlightByDestinationInUser(destination);
		}
		return null;
	}
	public List<FlightDetails> getFlightDetailsInUser() {
		return daoRef.getFlightDetailsInUser();

	}
	public BookingStatus requestBook(BookingStatus status) {
				return daoRef.requestBook(status);
			
	}
	
	public boolean cancelTicket(int ticketId) {
		if (validation.idValidation(ticketId)) {
			return daoRef.cancelTicket(ticketId);
		}
		return false;
	}


	
	//************************ Service Validation *********************//
	
	public boolean validatingFlightID(int flightid) {
		if(validation.idValidation(flightid)){
		  return true;
		}
		throw new AirlineException("Invalid Id! Id should contain exactly 4 positive digits");
	}
	public boolean validatingFlightName(String flightname) {
	    if(validation.nameValidation(flightname)) {
	    	return true;
	    }
	    throw new AirlineException("Invalid Name! Name should have atleast 4 characters");
	}
	public boolean validatingSource(String source) {
      if(validation.sourceValidation(source)) {
    	  return true;
      }
      
      throw new AirlineException("Invalid Source! Source should have atleast 4 characters");
	}

	public boolean validatingDestination(String destination) {
		if(validation.destinationValidation(destination)) {
			return true;
		}
		throw new AirlineException("Invalid Destination! Destination should have atleast 4 characters");
	}

	public boolean validatingName(String checkName) {
		 if(validation.nameValidation(checkName)) {
		    	return true;
		    }
		    throw new AirlineException("Invalid Name! Name should have atleast 4 characters");
	}
	
	public boolean validatingMobile(long checkMobile) {
		if(validation.mobileValidation(checkMobile)) {
			return true;
		}
		throw new AirlineException("Enter Proper Mobile Number");
	}

	public boolean validatingEmail(String checkEmail) {
		if(validation.emailValidation(checkEmail)) {
		return false;
		}
		throw new AirlineException("Enter proper email such that it should consist of numbers and alphabets For ex:- chandu3@gmail.com");
	}

	public boolean validatingPassword(String checkPassword) {
		if(validation.passwordValidation(checkPassword)) {
		return false;
		}
		throw new AirlineException("Password should contain atleast 6 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) For ex:- @Chandu123");
	}


	//*************Register And Login **********************//
	public boolean register(AirlineUsers register) {
		if(validation.idValidation(register.getId())) {
			if(validation.nameValidation(register.getName())) {
				if(validation.mobileValidation(register.getMobileNo())) {
					if(validation.emailValidation(register.getEmailId())) {
						if(validation.passwordValidation(register.getPassword())) {
							if(validation.validatedRole(register.getRole())) {
							return daoRef.register(register);
							}
						}
					}
					
				}
			}
		}
		throw new AirlineException("invalid inputs");
	}

	public AirlineUsers check(String email, String password) {
		if (validation.emailValidation(email)) {
			if (validation.passwordValidation(password)) {
				return daoRef.check(email, password);
			} 
		} 
		return null;
	}

}
