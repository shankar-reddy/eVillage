/**
 * Author : Sankara Reddy Telukutla
 * Jul 21, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.Account;
import com.itreddys.evillage.dao.AccountDAO;
import com.itreddys.evillage.exception.eVillageException;
import com.itreddys.evillage.util.DBConnectionFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 */
@Service
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	DBConnectionFactory dbConnection;
	DB db;
	private static final Logger logger_c = Logger
			.getLogger(AccountDAOImpl.class);

	public AccountDAOImpl() throws eVillageException {
		db = dbConnection.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.AccountDAO#findAll()
	 */
	public List<Account> findAll() throws eVillageException {
		List<Account> accounts = new ArrayList<Account>();

		DBCollection user = db.getCollection("users");
		DBCursor userDetails = user.find();

		while (userDetails.hasNext()) {
			DBObject userObject = userDetails.next();
			Account account = new Account();
			account.setUserName(String.valueOf(userObject.get("userName")));
			account.setPassword(String.valueOf(userObject.get("password")));
			account.setFirstName(String.valueOf(userObject.get("firstName")));
			account.setMiddleName(String.valueOf(userObject.get("middleName")));
			account.setLastName(String.valueOf(userObject.get("lastName")));
			account.setEmailId(String.valueOf(userObject.get("emailId")));
			account.setDob((Date) (userObject.get("dob")));
			account.setPhNo(String.valueOf(userObject.get("phNo")));
			account.setReceiveMail((Boolean) (userObject.get("receiveMail")));
			account.setReceiveSMS((Boolean) (userObject.get("receiveSMS")));
			accounts.add(account);

		}

		// Load Temp data
		// accounts = loadTempAccountData(accounts);
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
		account.setReceiveMail(false);
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
		account2.setReceiveMail(false);
		account2.setReceiveSMS(true);
		account2.setUserName("bharathi.nalla");
		accounts.add(account2);

		return accounts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itreddys.evillage.dao.AccountDAO#authenticate(com.itreddys.evillage
	 * .bd.bean.Account)
	 */
	public boolean authenticate(Account account) throws eVillageException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itreddys.evillage.dao.AccountDAO#createAccount(com.itreddys.evillage
	 * .bd.bean.Account)
	 */
	public Account createAccount(Account account) throws eVillageException {

		DBCollection user = db.getCollection("users");
		BasicDBObject userDetails = new BasicDBObject();

		userDetails.put("userName", account.getUserName());
		userDetails.put("password", account.getPassword());
		userDetails.put("firstName", account.getFirstName());
		userDetails.put("middleName", account.getMiddleName());
		userDetails.put("lastName", account.getLastName());
		userDetails.put("emailId", account.getEmailId());
		userDetails.put("dob", account.getDob());
		userDetails.put("phNo", account.getPhNo());
		userDetails.put("receiveMail", account.isReceiveMail());
		userDetails.put("receiveSMS", account.isReceiveSMS());
		user.insert(userDetails);

		/**** Find and display ****/
		BasicDBObject findUser = new BasicDBObject();
		findUser.put("userName", account.getUserName());

		DBCursor cursor = user.find(findUser);

		while (cursor.hasNext()) {
			logger_c.info("Created User Account for the User: " + cursor.next());
		}
		return account;
	}

}
