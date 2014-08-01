/**
 * Author : Sankara Reddy Telukutla
 * Jul 19, 2014  9:26:16 AM
 * 
 */
package com.itreddys.evillage.util;

/**
 * SMS Message bean
 */
public class SMSMessage {
	String message = new String();
	String receiver = new String();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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

}
