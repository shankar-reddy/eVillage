package com.itreddys.evillage.bd;
import java.util.List;

import com.itreddys.evillage.bd.bean.Account;
import com.itreddys.evillage.exception.eVillageException;

/**
 * Author : Sankara Reddy Telukutla
 * Jul 20, 2014  9:33:09 PM
 * 
 */

/**
 * 
 */
public interface AccountMasterService {
	
	public String createAccount(Account account) throws eVillageException;
	public String deleteAccount(Account account) throws eVillageException;
	public String updateAccount(Account account) throws eVillageException;
	
	public String getAccounts(List<Account> accounts) throws eVillageException;
	
}
