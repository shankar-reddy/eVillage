package com.itreddys.evillage.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.Account;
import com.itreddys.evillage.dao.impl.AccountDAOImpl;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 * @author Shankar Reddy
 *
 */
@Service
public class AccountService {
	
    @Autowired
	AccountDAOImpl dao;

    /**
     * Get the All Users.
     * @throws eVillageException 
     */
	public List<Account> findAll() throws eVillageException {
		return dao.findAll();
	}
}
