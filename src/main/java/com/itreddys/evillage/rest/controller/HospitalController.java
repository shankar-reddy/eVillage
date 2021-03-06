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

import com.itreddys.evillage.bean.HospitalDetails;
import com.itreddys.evillage.bean.HospitalDetails;
import com.itreddys.evillage.service.HospitalService;

/**
 * @author Bharathi Nalla HospitalController class will expose a series of
 *         RESTful end points
 */
@Controller
public class HospitalController extends BaseController {

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private View jsonView_i;

	private static final Logger logger_c = Logger
			.getLogger(HospitalController.class);

	/**
	 * Gets all Hospitals.
	 * 
	 * @return the Hospitals
	 */
	@RequestMapping(value = "/rest/hospitals", method = RequestMethod.GET)
	public ModelAndView findAllHospitals() {
		List<HospitalDetails> hospitals = null;
		try {
			hospitals = hospitalService.findAll();

		} catch (Exception e) {
			String sMessage = "Error getting Hospital details. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Hospital details: " + hospitals.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, hospitals);
	}

	/**
	 * Create Hospital
	 * 
	 * @return HospitalDetails
	 */
	@RequestMapping(value = "/rest/hospitals", method = RequestMethod.POST)
	public ModelAndView createHospital(
			@RequestParam("hospitalName") String hospitalName,
			@RequestParam("address") String address,
			@RequestParam("contactNo") String contactNo,
			@RequestParam("webSite") String webSite,
			@RequestParam("fax") String fax, @RequestParam("eMail") String eMail) {

		HospitalDetails hospitals = new HospitalDetails();
		try {
			hospitals.setHospitalName(hospitalName);
			hospitals.setAddress(address);
			hospitals.setContactNo(contactNo);
			hospitals.setWebSite(webSite);
			hospitals.setFax(fax);
			hospitals.seteMail(eMail);

			logger_c.info("Creating HospitalDetails for the Hospital: "
					+ hospitalName);

			hospitals = hospitalService.createHospital(hospitals);

		} catch (Exception e) {
			String sMessage = "Error Creating record for Hospital. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Hospital: " + hospitals.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, hospitals);
	}

}
