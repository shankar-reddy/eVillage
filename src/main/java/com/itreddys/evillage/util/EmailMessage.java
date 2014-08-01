/**
 * Author : Sankara Reddy Telukutla
 * 07/19/2014  9:20:41 AM
 * 
 */
package com.itreddys.evillage.util;


/**
 * @author stelukut
 * 
 */
public class EmailMessage {
	String receiver = new String();
	String subject = new String();
	String message = new String();

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver
	 *            the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
