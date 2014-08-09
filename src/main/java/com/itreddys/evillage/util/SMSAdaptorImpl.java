/**
 * Author : Bharathi Nalla
 * Jul 21, 2014  10:11:38 PM
 * 
 */
package com.itreddys.evillage.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
public class SMSAdaptorImpl implements SMSAdaptor {

	private static final Logger logger_c = Logger.getLogger(EmailAdaptorImpl.class);
	SMSProperties smsProps;

	@SuppressWarnings("deprecation")
	@Override
	public String sendSMS(SMSMessage smsMessage) throws eVillageException {
		logger_c.debug("Sending SMS");
		// Prepare Url
		URLConnection serviceProviderUrl = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encoded_message = URLEncoder.encode(smsMessage.getMessage());

		// Send SMS API
		String mainUrl = smsProps.getProviderUrl();

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + smsProps.getAuthkey());
		sbPostData.append("&mobiles=" + smsMessage.getReceiver());
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&route=" + smsProps.getRoute());
		sbPostData.append("&sender=" + smsProps.getSenderId());

		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			serviceProviderUrl = myURL.openConnection();
			serviceProviderUrl.connect();
			reader = new BufferedReader(new InputStreamReader(
					serviceProviderUrl.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null){
				// print response
				logger_c.debug("SMS Processing Response Id: " + response);
			}

			// finally close connection
			reader.close();
		} catch (IOException e) {
			String sMessage = "Error while sending SMS";
			logger_c.error(sMessage + e);
		}
		return null;
	}

	/**
	 * @return the smsProps
	 */
	public SMSProperties getSmsProps() {
		return smsProps;
	}

	/**
	 * @param smsProps the smsProps to set
	 */
	public void setSmsProps(SMSProperties smsProps) {
		this.smsProps = smsProps;
	}

}
