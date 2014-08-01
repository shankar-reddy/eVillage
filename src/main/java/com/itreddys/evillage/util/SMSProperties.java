/**
 * Author : Bharathi Nalla
 * Aug 01, 2014  9:26:16 AM
 * 
 */
package com.itreddys.evillage.util;

/**
 * SMS Properties bean
 */
public class SMSProperties {
	String providerUrl = new String();
	String route = new String();
	String senderId = new String();
	String authkey = new String();

	/**
	 * @return the providerUrl
	 */
	public String getProviderUrl() {
		return providerUrl;
	}

	/**
	 * @param providerUrl
	 *            the providerUrl to set
	 */
	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * @param route
	 *            the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * @return the senderId
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId
	 *            the senderId to set
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the authkey
	 */
	public String getAuthkey() {
		return authkey;
	}

	/**
	 * @param authkey
	 *            the authkey to set
	 */
	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}

}
