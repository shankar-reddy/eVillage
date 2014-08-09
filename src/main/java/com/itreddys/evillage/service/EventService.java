package com.itreddys.evillage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.EventDetails;
import com.itreddys.evillage.dao.impl.EventDAOImpl;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Bharathi Nalla
 * 
 */
@Service
public class EventService {

	@Autowired
	EventDAOImpl dao;

	/**
	 * Get the All Event Details.
	 * 
	 * @throws eVillageException
	 */
	public List<EventDetails> findAll() throws eVillageException {
		return dao.findAll();
	}

	/**
	 * 
	 * Create Event
	 * 
	 * @throws eVillageException
	 * 
	 */
	public EventDetails createEvent(EventDetails event)
			throws eVillageException {
		return dao.createEvent(event);
	}
}
