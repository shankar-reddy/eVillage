package com.itreddys.evillage.rest.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.itreddys.evillage.bean.BankDetails;
import com.itreddys.evillage.bean.EventDetails;
import com.itreddys.evillage.service.EventService;

/**
 * @author Bharathi Nalla EventsController class will expose a series of RESTful
 *         end points
 */
@Controller
public class EventsController extends BaseController {

	@Autowired
	private EventService eventsService;

	@Autowired
	private View jsonView_i;

	private static final Logger logger_c = Logger
			.getLogger(EventsController.class);

	/**
	 * Gets all Event.
	 * 
	 * @return the Event
	 */
	@RequestMapping(value = "/rest/events", method = RequestMethod.GET)
	public ModelAndView findAllEvents() {
		List<EventDetails> events = null;
		try {
			events = eventsService.findAll();

		} catch (Exception e) {
			String sMessage = "Error getting Event details. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Event details: " + events.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, events);
	}

	/**
	 * Create Event
	 * 
	 * @return EventDetails
	 */
	@RequestMapping(value = "/rest/events", method = RequestMethod.POST)
	public ModelAndView createEvent(
			@RequestParam("eventName") String eventName,
			@RequestParam("eventDate") Date eventDate) {

		EventDetails event = new EventDetails();
		try {
			event.setEventName(eventName);
			event.setEventDate(eventDate);

			logger_c.info("Creating EventDetails for the Event: " + eventName);

			event = eventsService.createEvent(event);

		} catch (Exception e) {
			String sMessage = "Error Creating record for event. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Event: " + event.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, event);
	}

}
