/**
 * Author : Sankara Reddy Telukutla
 * Jul 20, 2014  9:37:13 PM
 * 
 */
package com.itreddys.evillage.bd.bean;

import java.util.Date;

/**
 * Account Information
 */
public class Account {
	private String firstName = new String();
	private String middleName = new String();
	private String lastName = new String();
	private String emailId = new String();
	private Date dob = new Date();
	private String phNo = new String();
	
	private boolean receiveMail = false;
	private boolean receiveSMS  = false;
	
	//TODO Add more feilds about Account related
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the phNo
	 */
	public String getPhNo() {
		return phNo;
	}
	/**
	 * @param phNo the phNo to set
	 */
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	/**
	 * @return the receiveMail
	 */
	public boolean isReceiveMail() {
		return receiveMail;
	}
	/**
	 * @param receiveMail the receiveMail to set
	 */
	public void setReceiveMail(boolean receiveMail) {
		this.receiveMail = receiveMail;
	}
	/**
	 * @return the receiveSMS
	 */
	public boolean isReceiveSMS() {
		return receiveSMS;
	}
	/**
	 * @param receiveSMS the receiveSMS to set
	 */
	public void setReceiveSMS(boolean receiveSMS) {
		this.receiveSMS = receiveSMS;
	}
	
	
	
}
