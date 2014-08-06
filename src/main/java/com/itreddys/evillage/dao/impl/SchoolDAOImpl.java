/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.SchoolDetails;
import com.itreddys.evillage.dao.SchoolDAO;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
@Service
public class SchoolDAOImpl implements SchoolDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.SchoolDAO#findAll()
	 */
	public List<SchoolDetails> findAll() throws eVillageException {
		List<SchoolDetails> schoolDetails = new ArrayList<SchoolDetails>();
		// Load Temp data
		schoolDetails = loadTempSchoolData(schoolDetails);
		return schoolDetails;
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

}
