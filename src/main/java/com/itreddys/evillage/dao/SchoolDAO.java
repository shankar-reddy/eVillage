/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:03:11 PM
 * 
 */
package com.itreddys.evillage.dao;

import java.util.List;

import com.itreddys.evillage.bean.SchoolDetails;
import com.itreddys.evillage.exception.eVillageException;

/**
 * School DAO Interface
 */
public interface SchoolDAO {
	public List<SchoolDetails> findAll() throws eVillageException;

}
