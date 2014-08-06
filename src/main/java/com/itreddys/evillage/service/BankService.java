package com.itreddys.evillage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.BankDetails;
import com.itreddys.evillage.dao.impl.BankDAOImpl;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Bharathi Nalla
 * 
 */
@Service
public class BankService {

	@Autowired
	BankDAOImpl dao;

	/**
	 * Get the All Bank Details.
	 * 
	 * @throws eVillageException
	 */
	public List<BankDetails> findAll() throws eVillageException {
		return dao.findAll();
	}
}
