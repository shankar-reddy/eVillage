/**
 * Author : Bharathi Nalla
 * Aug 06, 2014  11:06:13 PM
 * 
 */
package com.itreddys.evillage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itreddys.evillage.bean.LibraryDetails;
import com.itreddys.evillage.dao.LibraryDAO;
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
public class LibraryDAOImpl implements LibraryDAO {
	@Autowired
	DBConnectionFactory dbConnection;
	DB db;
	private static final Logger logger_c = Logger
			.getLogger(AccountDAOImpl.class);

	public LibraryDAOImpl() throws eVillageException {
		db = dbConnection.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itreddys.evillage.dao.LibraryDAO#findAll()
	 */
	public List<LibraryDetails> findAll() throws eVillageException {
		List<LibraryDetails> librariesList = new ArrayList<LibraryDetails>();
		DBCollection libraries = db.getCollection("libraries");
		DBCursor libraryDetails = libraries.find();

		while (libraryDetails.hasNext()) {
			DBObject librarObject = libraryDetails.next();
			LibraryDetails library = new LibraryDetails();
			library.setLibraryName(String.valueOf(librarObject
					.get("libraryName")));
			library.setAddress(String.valueOf(librarObject.get("address")));
			library.setContactNo(String.valueOf(librarObject.get("contactNo")));
			library.setWebSite(String.valueOf(librarObject.get("webSite")));
			library.setFax(String.valueOf(librarObject.get("fax")));
			library.seteMail(String.valueOf(librarObject.get("eMail")));
			librariesList.add(library);

		}

		// Load Temp data
		librariesList = loadTempLibraryData(librariesList);
		return librariesList;
	}

	/**
	 * @param Library
	 *            Details
	 * @return
	 */
	private List<LibraryDetails> loadTempLibraryData(
			List<LibraryDetails> libraryDetails) {
		// TODO
		return libraryDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itreddys.evillage.dao.LibraryDAO#createLibrary(com.itreddys.evillage
	 * .bd.bean.LibraryDetails)
	 */
	public LibraryDetails createLibrary(LibraryDetails library)
			throws eVillageException {
		DBCollection libraries = db.getCollection("libraries");
		BasicDBObject libraryDetailsObject = new BasicDBObject();

		libraryDetailsObject.put("libraryName", library.getLibraryName());
		libraryDetailsObject.put("address", library.getAddress());
		libraryDetailsObject.put("contactNo", library.getContactNo());
		libraryDetailsObject.put("webSite", library.getWebSite());
		libraryDetailsObject.put("fax", library.getFax());
		libraryDetailsObject.put("eMail", library.geteMail());
		libraries.insert(libraryDetailsObject);

		/**** Find and display ****/
		BasicDBObject findLibrary = new BasicDBObject();
		findLibrary.put("libraryName", library.getLibraryName());

		DBCursor cursor = libraries.find(findLibrary);

		while (cursor.hasNext()) {
			logger_c.info("Created Library Details for the library: "
					+ cursor.next());
		}
		return library;
	}

}
