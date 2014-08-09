/**
 * Author : Sankara Reddy Telukutla
 * Jul 20, 2014  9:53:43 PM
 * 
 */
package com.itreddys.evillage.bean;

import java.util.Date;

/**
 * 
 */
public class EventDetails {
	private String eventName = new String();
	private Date eventDate = new Date();

	// TODO Add event related fields
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName
	 *            the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDate
	 */
	public Date getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate
	 *            the eventDate to set
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

}
