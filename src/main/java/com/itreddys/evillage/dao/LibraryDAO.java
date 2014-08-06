/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:03:11 PM
 * 
 */
package com.itreddys.evillage.dao;

import java.util.List;

import com.itreddys.evillage.bean.LibraryDetails;
import com.itreddys.evillage.exception.eVillageException;

/**
 * Library DAO Interface
 */
public interface LibraryDAO {
	public List<LibraryDetails> findAll() throws eVillageException;

}
