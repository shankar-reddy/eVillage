/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.HospitalDetails;
import com.itreddys.evillage.dao.HospitalDAO;
import com.itreddys.evillage.exception.eVillageException;

/**
 * 
 */
@Service
public class HospitalDAOImpl implements HospitalDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.HospitalDAO#findAll()
	 */
	public List<HospitalDetails> findAll() throws eVillageException {
		List<HospitalDetails> hospitalDetails = new ArrayList<HospitalDetails>();
		// Load Temp data
		hospitalDetails = loadTempHospitalData(hospitalDetails);
		return hospitalDetails;
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

}
