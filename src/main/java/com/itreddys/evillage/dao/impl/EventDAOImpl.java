/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.EventDetails;
import com.itreddys.evillage.dao.EventDAO;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Bharathi
 *
 */
@Service
public class EventDAOImpl implements EventDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.EventDAO#findAll()
	 */
	public List<EventDetails> findAll() throws eVillageException {
		List<EventDetails> eventsDetails = new ArrayList<EventDetails>();
		// Load Temp data
		eventsDetails = loadTempEventData(eventsDetails);
		return eventsDetails;
	}

	/**
	 * @param Event
	 *            Details
	 * @return
	 */
	private List<EventDetails> loadTempEventData(List<EventDetails> eventsDetails) {
		//TODO
		return eventsDetails;
	}

}
