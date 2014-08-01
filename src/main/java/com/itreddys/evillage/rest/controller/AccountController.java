package com.itreddys.evillage.rest.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.itreddys.evillage.bean.Account;
import com.itreddys.evillage.service.AccountService;
import com.itreddys.evillage.util.EmailAdaptor;
import com.itreddys.evillage.util.EmailMessage;
import com.itreddys.evillage.util.SMSAdaptor;
import com.itreddys.evillage.util.SMSMessage;


/**
 * @author Shankar Reddy
 * AccountController class will expose a series of RESTful end points
 */
@Controller
public class AccountController   extends BaseController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private EmailAdaptor emailAdaptor;
	@Autowired
	private SMSAdaptor smsAdaptor;

	@Autowired
	private View jsonView_i;

	private static final Logger logger_c = Logger.getLogger(AccountController.class);

	/**
	 * Gets all Accounts.
	 * @return the Accounts
	 */
	@RequestMapping(value = "/rest/accounts", method = RequestMethod.GET)
	public ModelAndView findAllAccounts() {
		List<Account> accounts = null;
		try {
			accounts = accountService.findAll();
			for(Account account : accounts){
				if( account.isReceiveMail()){
					EmailMessage emailMessage = new EmailMessage();
					emailMessage.setReceiver(account.getEmailId());
					emailMessage.setSubject("eVillage Notification");
					emailMessage.setMessage("Dear " + account.getUserName() +", \n Welcome To eVillage");
					emailAdaptor.sendMail(emailMessage);
				}
				logger_c.debug("****" + account.isReceiveSMS());
				if( account.isReceiveSMS()){
					logger_c.debug("Sending SMS");
					SMSMessage smsMessage = new SMSMessage();
					smsMessage.setReceiver(account.getPhNo());
					smsMessage.setMessage("Dear " + account.getUserName() +", \n Welcome To eVillage");
					smsAdaptor.sendSMS(smsMessage);
				}
			
			}
			
		} catch (Exception e) {
			String sMessage = "Error getting all Accounts. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Accounts: " + accounts.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, accounts);
	}
}

