/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.LibraryDetails;
import com.itreddys.evillage.dao.LibraryDAO;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
@Service
public class LibraryDAOImpl implements LibraryDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.LibraryDAO#findAll()
	 */
	public List<LibraryDetails> findAll() throws eVillageException {
		List<LibraryDetails> libraryDetails = new ArrayList<LibraryDetails>();
		// Load Temp data
		libraryDetails = loadTempLibraryData(libraryDetails);
		return libraryDetails;
	}

	/**
	 * @param Library
	 *            Details
	 * @return
	 */
	private List<LibraryDetails> loadTempLibraryData(List<LibraryDetails> libraryDetails) {
		//TODO
		return libraryDetails;
	}

}
