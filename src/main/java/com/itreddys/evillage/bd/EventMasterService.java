/**
 * Author : Sankara Reddy Telukutla
 * Jul 20, 2014  9:49:11 PM
 * 
 */
package com.itreddys.evillage.bd;

import java.util.Date;
import java.util.List;

import com.itreddys.evillage.bd.bean.EventDetails;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
public interface EventMasterService {
	public String registerEvent(EventDetails eventDetails) throws eVillageException;
	public String updateEvent(EventDetails eventDetails) throws eVillageException;
	public String deleteEvent(EventDetails eventDetails) throws eVillageException;
	
	public List<EventDetails> getEvents() throws eVillageException;
	public List<EventDetails> getEvents(Date fromDate, Date toDate) throws eVillageException;
		
}
