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
	String sender = new String();
	String receiver = new String();
	String message  = new String();
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}
	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}
