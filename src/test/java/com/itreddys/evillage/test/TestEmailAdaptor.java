package com.itreddys.evillage.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itreddys.evillage.exception.eVillageException;
import com.itreddys.evillage.util.EmailAdaptorImpl;
import com.itreddys.evillage.util.EmailMessage;

/**
 * Author : Sankara Reddy Telukutla
 * Jul 19, 2014  10:13:26 PM
 * 
 */

/**
 * 
 */
public class TestEmailAdaptor {

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
	 * Test method for {@link com.itreddys.evillage.util.EmailAdaptorImpl#sendMail(com.itreddys.evillage.util.EmailMessage)}.
	 * @throws eVillageException 
	 */
	@Test
	public void testSendMail() throws eVillageException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/config/app-context.xml");
		EmailAdaptorImpl emailAdaptor = (EmailAdaptorImpl) context.getBean("emailAdaptorService");
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setReceiver("sankara.telukutla@gmail.com");
		emailMessage.setSubject("eVillage Notification");
		emailMessage.setMessage("Dear User, \n WELCOME TO eVILLAGE");
		emailAdaptor.sendMail(emailMessage);
		//fail("Not yet implemented");
	}
}
