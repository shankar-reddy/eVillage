package com.itreddys.evillage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.LibraryDetails;
import com.itreddys.evillage.dao.impl.LibraryDAOImpl;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Bharathi Nalla
 * 
 */
@Service
public class LibraryService {

	@Autowired
	LibraryDAOImpl dao;

	/**
	 * Get the All Library Details.
	 * 
	 * @throws eVillageException
	 */
	public List<LibraryDetails> findAll() throws eVillageException {
		return dao.findAll();
	}
}
