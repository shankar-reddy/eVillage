package com.itreddys.evillage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.SchoolDetails;
import com.itreddys.evillage.dao.impl.SchoolDAOImpl;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Bharathi Nalla
 * 
 */
@Service
public class SchoolService {

	@Autowired
	SchoolDAOImpl dao;

	/**
	 * Get the All School Details.
	 * 
	 * @throws eVillageException
	 */
	public List<SchoolDetails> findAll() throws eVillageException {
		return dao.findAll();
	}

	/**
	 * 
	 * Create Schools
	 * 
	 * @throws eVillageException
	 * 
	 */
	public SchoolDetails createSchool(SchoolDetails school)
			throws eVillageException {
		return dao.createSchool(school);
	}
}
