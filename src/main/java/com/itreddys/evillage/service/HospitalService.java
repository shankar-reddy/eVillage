package com.itreddys.evillage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.HospitalDetails;
import com.itreddys.evillage.dao.impl.HospitalDAOImpl;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Bharathi Nalla
 * 
 */
@Service
public class HospitalService {

	@Autowired
	HospitalDAOImpl dao;

	/**
	 * Get the All Hospital Details.
	 * 
	 * @throws eVillageException
	 */
	public List<HospitalDetails> findAll() throws eVillageException {
		return dao.findAll();
	}

	/**
	 * 
	 * Create Hospital
	 * 
	 * @throws eVillageException
	 * 
	 */
	public HospitalDetails createHospital(HospitalDetails hospitals)
			throws eVillageException {
		return dao.createHospital(hospitals);
	}
}
