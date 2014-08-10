/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.EventDetails;
import com.itreddys.evillage.dao.EventDAO;
import com.itreddys.evillage.exception.eVillageException;
import com.itreddys.evillage.util.DBConnectionFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * @author Bharathi
 * 
 */
@Service
public class EventDAOImpl implements EventDAO {
	DBConnectionFactory dbConnection = new DBConnectionFactory();
	DB db;
	private static final Logger logger_c = Logger.getLogger(EventDAOImpl.class);

	public EventDAOImpl() throws eVillageException {
		db = dbConnection.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.EventDAO#findAll()
	 */
	public List<EventDetails> findAll() throws eVillageException {
		List<EventDetails> eventsList = new ArrayList<EventDetails>();
		DBCollection events = db.getCollection("events");
		DBCursor eventDetails = events.find();

		while (eventDetails.hasNext()) {
			DBObject bankObject = eventDetails.next();
			EventDetails event = new EventDetails();
			event.setEventName(String.valueOf(bankObject.get("eventName")));
			event.setEventDate((Date) (bankObject.get("eventDate")));
			eventsList.add(event);

		}

		// Load Temp data
		// eventsList = loadTempEventData(eventsList);
		return eventsList;
	}

	/**
	 * @param Event
	 *            Details
	 * @return
	 */
	private List<EventDetails> loadTempEventData(
			List<EventDetails> eventsDetails) {
		// TODO
		return eventsDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.EventDAO#createEvent(com.itreddys.evillage
	 * .bd.bean.EventDetails)
	 */
	public EventDetails createEvent(EventDetails event)
			throws eVillageException {
		DBCollection events = db.getCollection("events");
		BasicDBObject eventDetails = new BasicDBObject();

		eventDetails.put("eventName", event.getEventName());
		eventDetails.put("eventDate", event.getEventDate());
		events.insert(eventDetails);

		/**** Find and display ****/
		BasicDBObject findEvent = new BasicDBObject();
		findEvent.put("eventName", event.getEventName());

		DBCursor eventResults = events.find(findEvent);

		while (eventResults.hasNext()) {
			logger_c.info("Created Event Details for the Event: "
					+ eventResults.next());
		}
		return event;
	}

}
