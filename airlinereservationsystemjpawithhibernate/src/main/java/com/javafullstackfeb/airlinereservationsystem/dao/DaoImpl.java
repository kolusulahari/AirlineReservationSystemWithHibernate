package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.javafullstackfeb.airlinereservationsystem.dto.AirlineUsers;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingStatus;
import com.javafullstackfeb.airlinereservationsystem.dto.FlightDetails;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;

public class DaoImpl implements Dao {
	
	EntityManagerFactory factory = null;

	public boolean register(AirlineUsers admin) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(admin);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new AirlineException("Invalid Credentials.... Already Exits!!!!");
		} finally {
			manager.close();
			factory.close();
		}
	}

	public AirlineUsers check(String email, String password) {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select user from  AirlineUsers user where user.emailId = :emailId and user.password =:password";
		TypedQuery<AirlineUsers> query = manager.createQuery(jpql, AirlineUsers.class);
		query.setParameter("emailId", email);
		query.setParameter("password", password);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			throw new AirlineException("Invalid Login Credentials, Please Enter Correctly");
		} finally {
			manager.close();
			factory.close();
		}
	}

	public boolean addingFlights(FlightDetails flightDetails) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(flightDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new AirlineException("Flight Details already Exists ");
		} finally {
			manager.close();
			factory.close();
		}
	}

	public boolean deletingFlight(int flightId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			FlightDetails flightDetails = manager.find(FlightDetails.class, flightId);
			manager.remove(flightDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new AirlineException("Flight Can't Be Removed or Deleted from flight Details");
		} finally {
			manager.close();
			factory.close();
		}
	}

	public List<FlightDetails> getFlightDetails() {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select f from FlightDetails f";
		TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
		List<FlightDetails> recordlist = query.getResultList();
		manager.close();
		factory.close();
		return recordlist;
	}

	public List<BookingStatus> bookingStatus() {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookingStatus b";
		TypedQuery<BookingStatus> query = manager.createQuery(jpql, BookingStatus.class);
		List<BookingStatus> recordlist = query.getResultList();
		manager.close();
		factory.close();
		return recordlist;
	}

	public List<FlightDetails> searchFlightByNameInUser(String flightname) {
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where flightName=:name";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("name",flightname);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			factory.close();
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	public List<FlightDetails> searchFlightBySourceInUser(String source) {
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where source=:source";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("source",source);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			factory.close();
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	public List<FlightDetails> searchFlightByDestinationInUser(String destination) {
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "Select f from FlightDetails f where destination=:destination";
			TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
			  query.setParameter("destination",destination);
			List<FlightDetails> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			factory.close();
			return recordList;
		}catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	public List<FlightDetails> getFlightDetailsInUser() {
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select f from FlightDetails f";
		TypedQuery<FlightDetails> query = manager.createQuery(jpql, FlightDetails.class);
		List<FlightDetails> recordlist = query.getResultList();
		manager.close();
		factory.close();
		return recordlist;
	}

	public BookingStatus requestBook(BookingStatus status) {
		EntityManager manager = null;
		EntityTransaction transaction = null;  
		FlightDetails flightDetails=new FlightDetails();
		AirlineUsers user=new AirlineUsers();
		int flightId=0;
		int userId=0;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			flightDetails = manager.find(FlightDetails.class, status.getFlightId());

			if (flightDetails != null) {
				flightId=flightDetails.getFlightId();
				transaction.commit();
				if(flightId==status.getFlightId()) {
					transaction.begin();
					user = manager.find(AirlineUsers.class, status.getId());
					if(user!=null) {
						userId=user.getId();
						transaction.commit();
						if(userId==status.getId()) {
							transaction.begin();
							manager.persist(status);
							transaction.commit();
							return status;
						}
					}else {
						throw new AirlineException("Invalid Request, User ID Not Found");
					}
				}
				
			} else {
				throw new AirlineException("Invalid Request, Flight ID Not Found");
			}
		} catch (AirlineException e) {
			throw new AirlineException(e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
		
		return null;
	}

	public boolean cancelTicket(int ticketId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookingStatus bookingStatus = manager.find(BookingStatus.class, ticketId);
			manager.remove(bookingStatus);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return true;
		} finally {
			manager.close();
			factory.close();
		}
	}


}
