/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.BankDetails;
import com.itreddys.evillage.dao.BankDAO;
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
public class BankDAOImpl implements BankDAO {
	DBConnectionFactory dbConnection = new DBConnectionFactory();
	DB db;
	private static final Logger logger_c = Logger.getLogger(BankDAOImpl.class);

	public BankDAOImpl() throws eVillageException {
		db = dbConnection.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.BankDAO#findAll()
	 */
	public List<BankDetails> findAll() throws eVillageException {
		List<BankDetails> banksList = new ArrayList<BankDetails>();
		DBCollection banks = db.getCollection("banks");
		DBCursor bankDetails = banks.find();

		while (bankDetails.hasNext()) {
			DBObject bankObject = bankDetails.next();
			BankDetails bank = new BankDetails();
			bank.setBankName(String.valueOf(bankObject.get("bankName")));
			bank.setAddress(String.valueOf(bankObject.get("address")));
			bank.setContactNo(String.valueOf(bankObject.get("contactNo")));
			bank.setWebSite(String.valueOf(bankObject.get("webSite")));
			bank.setFax(String.valueOf(bankObject.get("fax")));
			bank.seteMail(String.valueOf(bankObject.get("eMail")));
			banksList.add(bank);

		}

		// Load Temp data
		// bankDetails = loadTempBankData(bankDetails);
		return banksList;
	}

	/**
	 * @param Bank
	 *            Details
	 * @return
	 */
	private List<BankDetails> loadTempBankData(List<BankDetails> bankDetails) {
		BankDetails bank = new BankDetails();
		bank.setBankName("HDFC Bank");
		bank.setAddress("1st Floor,C.S.No.6/242,Senapati Bapat Marg,Lower Parel,Mumbai - 400 013");
		bank.setContactNo("1800 22 4060");
		bank.setWebSite("http://www.hdfcbank.com/");
		bank.setFax("+91-40-29805511");
		bank.seteMail("nri@hdfcbank.com ");

		bankDetails.add(bank);

		BankDetails bank2 = new BankDetails();
		bank2.setBankName("Citi Bank");
		bank2.setAddress("Khajaguda Village, Golkonda Post , Hyderabad 500008 ,AP India");
		bank2.setContactNo("1800 22 6747");
		bank2.setWebSite("http://www.online.citibank.co.in/");
		bank2.setFax("6666 2484");
		bank2.seteMail("info@citibank.com");

		bankDetails.add(bank2);

		return bankDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.BankDAO#createBank(com.itreddys.evillage
	 * .bd.bean.BankDetails)
	 */
	public BankDetails createBank(BankDetails bank) throws eVillageException {
		DBCollection banks = db.getCollection("banks");
		BasicDBObject bankDetails = new BasicDBObject();

		bankDetails.put("bankName", bank.getBankName());
		bankDetails.put("address", bank.getAddress());
		bankDetails.put("contactNo", bank.getContactNo());
		bankDetails.put("webSite", bank.getWebSite());
		bankDetails.put("fax", bank.getFax());
		bankDetails.put("eMail", bank.geteMail());
		banks.insert(bankDetails);

		/**** Find and display ****/
		BasicDBObject findBank = new BasicDBObject();
		findBank.put("bankName", bank.getBankName());

		DBCursor cursor = banks.find(findBank);

		while (cursor.hasNext()) {
			logger_c.info("Created Bank Details for the Bank: " + cursor.next());
		}
		return bank;
	}
}
