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

import com.itreddys.evillage.bean.SchoolDetails;
import com.itreddys.evillage.dao.SchoolDAO;
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
public class SchoolDAOImpl implements SchoolDAO {
	DBConnectionFactory dbConnection = new DBConnectionFactory();
	DB db;
	private static final Logger logger_c = Logger
			.getLogger(AccountDAOImpl.class);

	public SchoolDAOImpl() throws eVillageException {
		db = dbConnection.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.SchoolDAO#findAll()
	 */
	public List<SchoolDetails> findAll() throws eVillageException {
		List<SchoolDetails> schoolsList = new ArrayList<SchoolDetails>();
		DBCollection schools = db.getCollection("schools");
		DBCursor schoolDetails = schools.find();

		while (schoolDetails.hasNext()) {
			DBObject schoolObject = schoolDetails.next();
			SchoolDetails school = new SchoolDetails();
			school.setSchoolName(String.valueOf(schoolObject.get("schoolName")));
			school.setAddress(String.valueOf(schoolObject.get("address")));
			school.setContactNo(String.valueOf(schoolObject.get("contactNo")));
			school.setWebSite(String.valueOf(schoolObject.get("webSite")));
			school.setFax(String.valueOf(schoolObject.get("fax")));
			school.seteMail(String.valueOf(schoolObject.get("eMail")));
			schoolsList.add(school);

		}

		// Load Temp data
		// schoolsList = loadTempSchoolData(schoolsList);
		return schoolsList;
	}

	/**
	 * @param School
	 *            Details
	 * @return
	 */
	private List<SchoolDetails> loadTempSchoolData(
			List<SchoolDetails> schoolDetails) {
		SchoolDetails school = new SchoolDetails();
		school.setSchoolName("Slate The School");
		school.setAddress("House No 7-1-77/1, Behind Satyam Theatre, Dharam Karam Road, Ameerpet, Hyderabad - 500016");
		school.setContactNo("040-23801139,64598520");
		school.setWebSite("http://www.slate-theschool.com/");
		school.setFax("+91-40-29805511");
		school.seteMail("info@slate-theschool.com");

		schoolDetails.add(school);

		SchoolDetails school2 = new SchoolDetails();
		school2.setSchoolName("Delhi Public School");
		school2.setAddress("Khajaguda Village, Golkonda Post , Hyderabad 500008 ,AP India");
		school2.setContactNo("+91-40-29806765, 29806766, 29806767");
		school2.setWebSite("http://www.dpshyderabad.com/");
		school2.setFax("+91-40-29805511");
		school2.seteMail("info@dpshyderabad.com");

		schoolDetails.add(school2);

		return schoolDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itreddys.evillage.dao.SchoolDAO#createSchool(com.itreddys.evillage
	 * .bd.bean.SchoolDetails)
	 */
	public SchoolDetails createSchool(SchoolDetails school)
			throws eVillageException {
		DBCollection schools = db.getCollection("schools");
		BasicDBObject schoolDetailsObject = new BasicDBObject();

		schoolDetailsObject.put("schoolName", school.getSchoolName());
		schoolDetailsObject.put("address", school.getAddress());
		schoolDetailsObject.put("contactNo", school.getContactNo());
		schoolDetailsObject.put("webSite", school.getWebSite());
		schoolDetailsObject.put("fax", school.getFax());
		schoolDetailsObject.put("eMail", school.geteMail());
		schools.insert(schoolDetailsObject);

		/**** Find and display ****/
		BasicDBObject findSchool = new BasicDBObject();
		findSchool.put("schoolName", school.getSchoolName());

		DBCursor cursor = schools.find(findSchool);

		while (cursor.hasNext()) {
			logger_c.info("Created School Details for the School: "
					+ cursor.next());
		}
		return school;
	}

}
