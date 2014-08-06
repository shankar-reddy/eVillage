package com.itreddys.evillage.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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
}
