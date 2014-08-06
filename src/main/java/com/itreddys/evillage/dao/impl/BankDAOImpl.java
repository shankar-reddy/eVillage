/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.BankDetails;
import com.itreddys.evillage.dao.BankDAO;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
@Service
public class BankDAOImpl implements BankDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.BankDAO#findAll()
	 */
	public List<BankDetails> findAll() throws eVillageException {
		List<BankDetails> bankDetails = new ArrayList<BankDetails>();
		// Load Temp data
		bankDetails = loadTempBankData(bankDetails);
		return bankDetails;
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

}
