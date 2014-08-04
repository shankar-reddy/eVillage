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
		 account.setEmailId("sankara.telukutla@gmail.com");
		 account.setFirstName("Sankara");
		 account.setLastName("Telukutla");
		 account.setMiddleName("Reddy");
		 account.setPassword("**********");
		 account.setPhNo("+1 510 936 0999");
		 account.setReceiveMail(true);
		 account.setReceiveSMS(true);
	     account.setUserName("sankara.telukutla");
		 
		 accounts.add(account);
		 
		 Account account2 = new Account();
		 account2.setDob(new Date());
		 account2.setEmailId("indu.bharu@gmail.com");
		 account2.setFirstName("Bharathi");
		 account2.setLastName("Nalla");
		 account2.setMiddleName("X");
		 account2.setPassword("**********");
		 account2.setPhNo("8686356437");
		 account2.setReceiveMail(true);
		 account2.setReceiveSMS(true);
	     account2.setUserName("bharathi.nalla");
	     accounts.add(account2);
	     
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
