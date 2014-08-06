/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:03:11 PM
 * 
 */
package com.itreddys.evillage.dao;

import java.util.List;

import com.itreddys.evillage.bean.EventDetails;
import com.itreddys.evillage.exception.eVillageException;

/**
 * Events DAO Interface
 */
public interface EventDAO {
	public List<EventDetails> findAll() throws eVillageException;

}
