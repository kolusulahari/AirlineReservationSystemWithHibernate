package com.javafullstackfeb.airlinereservationsystem.factory;

import com.javafullstackfeb.airlinereservationsystem.dao.Dao;
import com.javafullstackfeb.airlinereservationsystem.dao.DaoImpl;
import com.javafullstackfeb.airlinereservationsystem.service.Service;
import com.javafullstackfeb.airlinereservationsystem.service.ServiceImpl;

public class AirlineFactory {
	private AirlineFactory() {
		
	}
    public static Dao getDaoImplInstance() {
    	Dao dao=new DaoImpl();
    	return dao;
    }
    public static Service getServiceImplInstance() {
    	Service service=new ServiceImpl();
    	return service;
    }
}
