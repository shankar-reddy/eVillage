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
import com.itreddys.evillage.bean.SchoolDetails;
import com.itreddys.evillage.service.SchoolService;

/**
 * @author Bharathi Nalla 
 * SchoolsController class will expose a series of
 *         RESTful end points
 */
@Controller
public class SchoolsController extends BaseController {

	@Autowired
	private SchoolService schoolService;

	@Autowired
	private View jsonView_i;

	private static final Logger logger_c = Logger
			.getLogger(SchoolsController.class);

	/**
	 * Gets all Schools.
	 * 
	 * @return the Schools
	 */
	@RequestMapping(value = "/rest/schools", method = RequestMethod.GET)
	public ModelAndView findAllSchools() {
		List<SchoolDetails> schools = null;
		try {
			schools = schoolService.findAll();

		} catch (Exception e) {
			String sMessage = "Error getting School details. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning School details: " + schools.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, schools);
	}
	
	/**
	 * Create School
	 * 
	 * @return SchoolDetails
	 */
	@RequestMapping(value = "/rest/schools", method = RequestMethod.POST)
	public ModelAndView createSchool(@RequestParam("schoolName") String schoolName,
			@RequestParam("address") String address,
			@RequestParam("contactNo") String contactNo,
			@RequestParam("webSite") String webSite,
			@RequestParam("fax") String fax, @RequestParam("eMail") String eMail) {

		SchoolDetails school = new SchoolDetails();
		try {
			school.setSchoolName(schoolName);
			school.setAddress(address);
			school.setContactNo(contactNo);
			school.setWebSite(webSite);
			school.setFax(fax);
			school.seteMail(eMail);

			logger_c.info("Creating SchoolDetails for the School: " + schoolName);

			school = schoolService.createSchool(school);

		} catch (Exception e) {
			String sMessage = "Error Creating record for school. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning school: " + school.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, school);
	}
}
