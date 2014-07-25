/**
 * Author : Sankara Reddy Telukutla
 * Jul 21, 2014  11:03:11 PM
 * 
 */
package com.itreddys.evillage.dao;

import java.util.List;

import com.itreddys.evillage.bean.Account;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
public interface AccountDAO {
	public List<Account> findAll() throws eVillageException;

	/**
	 * @param account
	 * @return
	 */
	public boolean authenticate(Account account) throws eVillageException; 
}
