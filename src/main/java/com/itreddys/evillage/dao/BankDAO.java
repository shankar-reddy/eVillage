/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:03:11 PM
 * 
 */
package com.itreddys.evillage.dao;

import java.util.List;

import com.itreddys.evillage.bean.BankDetails;
import com.itreddys.evillage.exception.eVillageException;

/**
 * Bank DAO Interface
 */
public interface BankDAO {
	public List<BankDetails> findAll() throws eVillageException;

}
