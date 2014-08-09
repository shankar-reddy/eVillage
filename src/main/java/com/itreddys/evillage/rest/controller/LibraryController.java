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

import com.itreddys.evillage.bean.LibraryDetails;
import com.itreddys.evillage.bean.LibraryDetails;
import com.itreddys.evillage.service.LibraryService;

/**
 * @author Bharathi Nalla LibrarysController class will expose a series of
 *         RESTful end points
 */
@Controller
public class LibraryController extends BaseController {

	@Autowired
	private LibraryService libraryService;

	@Autowired
	private View jsonView_i;

	private static final Logger logger_c = Logger
			.getLogger(LibraryController.class);

	/**
	 * Gets all Library.
	 * 
	 * @return the Library
	 */
	@RequestMapping(value = "/rest/library", method = RequestMethod.GET)
	public ModelAndView findAllLibrarys() {
		List<LibraryDetails> library = null;
		try {
			library = libraryService.findAll();

		} catch (Exception e) {
			String sMessage = "Error getting Library details. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Library details: " + library.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, library);
	}

	/**
	 * Create Library
	 * 
	 * @return LibraryDetails
	 */
	@RequestMapping(value = "/rest/library", method = RequestMethod.POST)
	public ModelAndView createLibrary(
			@RequestParam("libraryName") String libraryName,
			@RequestParam("address") String address,
			@RequestParam("contactNo") String contactNo,
			@RequestParam("webSite") String webSite,
			@RequestParam("fax") String fax, @RequestParam("eMail") String eMail) {

		LibraryDetails library = new LibraryDetails();
		try {
			library.setLibraryName(libraryName);
			library.setAddress(address);
			library.setContactNo(contactNo);
			library.setWebSite(webSite);
			library.setFax(fax);
			library.seteMail(eMail);

			logger_c.info("Creating LibraryDetails for the Library: "
					+ libraryName);

			library = libraryService.createLibrary(library);

		} catch (Exception e) {
			String sMessage = "Error Creating record for Library. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		logger_c.info("Returning Library: " + library.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, library);
	}
}
