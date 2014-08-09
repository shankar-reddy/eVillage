package com.itreddys.evillage.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.itreddys.evillage.bean.BankDetails;
import com.itreddys.evillage.service.BankService;

/**
 * @author Bharathi Nalla BankController class will expose a series of RESTful
 *         end points
 */
@Controller
public class BankController extends BaseController {

	@Autowired
	private BankService bankService;

	@Autowired
	private View jsonView_i;

	private static final Logger logger_c = Logger
			.getLogger(BankController.class);

	/**
	 * Gets all Banks.
	 * 
	 * @return the Banks
	 */
	@RequestMapping(value = "/rest/banks", method = RequestMethod.GET)
	public ModelAndView findAllBanks() {
		List<BankDetails> banks = null;
		try {
			banks = bankService.findAll();

		} catch (Exception e) {
			String sMessage = "Error getting Bank details. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Bank details: " + banks.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, banks);
	}

	/**
	 * Create Bank
	 * 
	 * @return BankDetails
	 */
	@RequestMapping(value = "/rest/banks", method = RequestMethod.POST)
	public ModelAndView createBank(@RequestParam("bankName") String bankName,
			@RequestParam("address") String address,
			@RequestParam("contactNo") String contactNo,
			@RequestParam("webSite") String webSite,
			@RequestParam("fax") String fax, @RequestParam("eMail") String eMail) {

		BankDetails bank = new BankDetails();
		try {
			bank.setBankName(bankName);
			bank.setAddress(address);
			bank.setContactNo(contactNo);
			bank.setWebSite(webSite);
			bank.setFax(fax);
			bank.seteMail(eMail);

			logger_c.info("Creating BankDetails for the Bank: " + bankName);

			bank = bankService.createBank(bank);

		} catch (Exception e) {
			String sMessage = "Error Creating record for Bank. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Bank: " + bank.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, bank);
	}

}
