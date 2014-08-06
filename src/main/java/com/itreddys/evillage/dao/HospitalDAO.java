/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:03:11 PM
 * 
 */
package com.itreddys.evillage.dao;

import java.util.List;

import com.itreddys.evillage.bean.HospitalDetails;
import com.itreddys.evillage.exception.eVillageException;

/**
 * Hospital DAO Interface
 */
public interface HospitalDAO {
	public List<HospitalDetails> findAll() throws eVillageException;

}
