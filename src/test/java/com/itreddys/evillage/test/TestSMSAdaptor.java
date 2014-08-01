package com.itreddys.evillage.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itreddys.evillage.exception.eVillageException;
import com.itreddys.evillage.util.SMSAdaptorImpl;
import com.itreddys.evillage.util.SMSMessage;

/**
 * Author :Bharathi Nalla
 *  Jul 21, 2014 10:13:26 PM
 * 
 */

public class TestSMSAdaptor {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.itreddys.evillage.util.SMSAdaptorImpl#sendSMS(com.itreddys.evillage.util.SMSMessage)}
	 * .
	 * 
	 * @throws eVillageException
	 */
	@Test
	public void testSendSMS() throws eVillageException {
		ApplicationContext context = new ClassPathXmlApplicationContext("../resources/app-context.xml");
		SMSAdaptorImpl smsAdaptor = (SMSAdaptorImpl) context.getBean("smsAdaptorService");
		SMSMessage smsMessage = new SMSMessage();
		smsMessage.setReceiver("+1 510 936 0999");
		smsMessage.setMessage("Dear User, \n Welcome To eVillage");
		smsAdaptor.sendSMS(smsMessage);
		// fail("Not yet implemented");
	}

}
