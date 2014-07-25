package com.itreddys.evillage.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
/**
 * 
 * @author Shankar Reddy
 *
 */
public abstract class BaseController {
	
	@Autowired
	protected View jsonView_i;

	protected static final String DATA_FIELD = "data";
	protected static final String ERROR_FIELD = "error";

	public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}
	
	protected ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
