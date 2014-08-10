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

import com.itreddys.evillage.bean.HospitalDetails;
import com.itreddys.evillage.dao.HospitalDAO;
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
public class HospitalDAOImpl implements HospitalDAO {
	DBConnectionFactory dbConnection = new DBConnectionFactory();
	DB db;
	private static final Logger logger_c = Logger
			.getLogger(AccountDAOImpl.class);

	public HospitalDAOImpl() throws eVillageException {
		db = dbConnection.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.HospitalDAO#findAll()
	 */
	public List<HospitalDetails> findAll() throws eVillageException {
		List<HospitalDetails> hospitalsList = new ArrayList<HospitalDetails>();
		DBCollection hospitals = db.getCollection("hospitals");
		DBCursor hospitalDetails = hospitals.find();

		while (hospitalDetails.hasNext()) {
			DBObject hospitalObject = hospitalDetails.next();
			HospitalDetails hospital = new HospitalDetails();
			hospital.setHospitalName(String.valueOf(hospitalObject
					.get("hospitalName")));
			hospital.setAddress(String.valueOf(hospitalObject.get("address")));
			hospital.setContactNo(String.valueOf(hospitalObject
					.get("contactNo")));
			hospital.setWebSite(String.valueOf(hospitalObject.get("webSite")));
			hospital.setFax(String.valueOf(hospitalObject.get("fax")));
			hospital.seteMail(String.valueOf(hospitalObject.get("eMail")));
			hospitalsList.add(hospital);

		}

		// Load Temp data
		// hospitalsList = loadTempHospitalData(hospitalsList);
		return hospitalsList;
	}

	/**
	 * @param Hospital
	 *            Details
	 * @return
	 */
	private List<HospitalDetails> loadTempHospitalData(
			List<HospitalDetails> hospitalDetails) {
		HospitalDetails hospital = new HospitalDetails();
		hospital.setHospitalName("Apollo Hospitals");
		hospital.setAddress("Madhapur, hyderabad");
		hospital.setContactNo("+91-40-344-1066");
		hospital.setWebSite("http://www.apollohospitals.com/");
		hospital.setFax("+91-40-29805511");
		hospital.seteMail("info@apollohospitals.com ");

		hospitalDetails.add(hospital);

		return hospitalDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itreddys.evillage.dao.HospitalDAO#createHospital(com.itreddys.evillage
	 * .bd.bean.HospitalDetails)
	 */
	public HospitalDetails createHospital(HospitalDetails hospitalDetails)
			throws eVillageException {
		DBCollection hospitals = db.getCollection("hospitals");
		BasicDBObject hospitalDetailsObject = new BasicDBObject();

		hospitalDetailsObject.put("hospitalName",
				hospitalDetails.getHospitalName());
		hospitalDetailsObject.put("address", hospitalDetails.getAddress());
		hospitalDetailsObject.put("contactNo", hospitalDetails.getContactNo());
		hospitalDetailsObject.put("webSite", hospitalDetails.getWebSite());
		hospitalDetailsObject.put("fax", hospitalDetails.getFax());
		hospitalDetailsObject.put("eMail", hospitalDetails.geteMail());
		hospitals.insert(hospitalDetailsObject);

		/**** Find and display ****/
		BasicDBObject findHospital = new BasicDBObject();
		findHospital.put("hospitalName", hospitalDetails.getHospitalName());

		DBCursor cursor = hospitals.find(findHospital);

		while (cursor.hasNext()) {
			logger_c.info("Created Hospital Details for the Hospital: "
					+ cursor.next());
		}
		return hospitalDetails;
	}
}
