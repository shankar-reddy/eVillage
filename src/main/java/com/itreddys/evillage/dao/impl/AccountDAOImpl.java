/**
 * Author : Sankara Reddy Telukutla
 * Jul 21, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.Account;
import com.itreddys.evillage.dao.AccountDAO;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
@Service
public class AccountDAOImpl implements AccountDAO {

	/* (non-Javadoc)
	 * @see com.itreddys.evillage.dao.AccountDAO#findAll()
	 */
	public List<Account> findAll() throws eVillageException {
	    List<Account> accounts = new ArrayList<Account>();
		// Load Temp data
	    accounts = loadTempAccountData(accounts);
		return accounts;
	}

	/**
	 * @param accounts
	 * @return
	 */
	private List<Account> loadTempAccountData(List<Account> accounts) {
		 List<Account> accounts1 = new ArrayList<Account>();
		 Account account = new Account();
		 account.setDob(new Date());
		 account.setEmailId("sankara.telukutla@gmail.com,indu.bharu@gmail.com");
		 account.setFirstName("Sankara");
		 account.setLastName("Telukutla");
		 account.setMiddleName("Reddy");
		 account.setPassword("**********");
		 account.setPhNo("+1 510 936 0999");
		 account.setReceiveMail(true);
		 account.setReceiveSMS(true);
	     account.setUserName("sankara.telukutla");
		 
		 accounts.add(account);
		 return accounts;
	}

	/* (non-Javadoc)
	 * @see com.itreddys.evillage.dao.AccountDAO#authenticate(com.itreddys.evillage.bd.bean.Account)
	 */
	public boolean authenticate(Account account) throws eVillageException {
		// TODO Auto-generated method stub
		return false;
	}

}
